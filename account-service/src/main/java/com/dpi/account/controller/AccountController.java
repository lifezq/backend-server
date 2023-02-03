package com.dpi.account.controller;

import com.dpi.account.convert.EnterpriseRegisterConvertor;
import com.dpi.account.dto.EmailValidateRequestDTO;
import com.dpi.account.dto.EnterpriseRegisterRequestDTO;
import com.dpi.account.dto.UserInfoDTO;
import com.dpi.common.bo.AuthClientMeta;
import com.dpi.common.dto.ResponseDTO;
import com.dpi.common.service.CommonUserService;
import com.dpi.common.utils.TokenUtil;
import com.dpi.database.mapper.auto.entity.EnterpriseRegister;
import com.dpi.database.mapper.auto.entity.Tenant;
import com.dpi.database.mapper.auto.service.impl.EnterpriseRegisterServiceImpl;
import com.dpi.database.mapper.auto.service.impl.TenantServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package com.dpi.account.controller
 * @ClassName AccountController
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/16
 */
@Tag(name = "账户相关接口")
@Log4j2
@RequestMapping("/account")
@Controller
public class AccountController {
    @Value("${keycloak.realm}")
    private String realmName;
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.credentials.secret}")
    private String clientSecret;
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CommonUserService userService;
    @Autowired
    private EnterpriseRegisterServiceImpl enterpriseRegisterService;
    @Autowired
    private TenantServiceImpl tenantService;

    @GetMapping("/login")
    public String login() {
        return "/account/login";
    }

    @GetMapping("/individual")
    @ResponseBody
    public void individual(HttpServletRequest request, HttpServletResponse response) throws IOException {
        @SuppressWarnings("rawtypes")
        KeycloakPrincipal principal = (KeycloakPrincipal) request.getUserPrincipal();
        if (principal != null) {
            KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
            Cookie cookie = new Cookie("token", keycloakSecurityContext.getTokenString());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }

        response.sendRedirect(String.format("%s/index", request.getContextPath()));
    }

    @GetMapping("/getUserInfo")
    @ResponseBody
    public ResponseDTO<UserInfoDTO> getUserInfo(HttpServletRequest request, Model model) {
        UserInfoDTO userInfoDTO = UserInfoDTO.builder()
                .token(TokenUtil.parseTokenFromRequest(request))
                .build();
        return ResponseDTO.<UserInfoDTO>builder()
                .data(userInfoDTO).build();
    }

    @Operation(summary = "企业注册", method = "POST")
    @PostMapping("/enterpriseRegister")
    @ResponseBody
    public ResponseDTO<String> enterpriseRegister(@RequestBody EnterpriseRegisterRequestDTO param) {

        EnterpriseRegister item = enterpriseRegisterService.query().ge(true, "email", param.getEmail()).one();
        if (item != null) {
            return ResponseDTO.<String>builder()
                    .code(HttpStatus.BAD_REQUEST.value()).message("email already exists!").build();
        }

        String realm = generateRealm(param.getEmail());

        Tenant maxTenant = tenantService.query().select("MAX(id) AS id").one();
        if (maxTenant == null) {
            maxTenant = new Tenant();
            maxTenant.setId(0L);
        }
        Tenant tenant = new Tenant();
        tenant.setId(maxTenant.getId() + 1);
        tenant.setName(realm);
        tenantService.save(tenant);

        EnterpriseRegister enterpriseRegister = EnterpriseRegisterConvertor.INSTANCE.toEnterpriseRegister(param);
        enterpriseRegister.setTenantId(maxTenant.getId().intValue() + 1);
        enterpriseRegisterService.save(enterpriseRegister);
        return ResponseDTO.<String>builder().data(realm).build();
    }

    @Operation(summary = "邮箱验证", method = "POST")
    @PostMapping("/emailValidate")
    @ResponseBody
    public ResponseDTO<Boolean> emailValidate(@RequestBody EmailValidateRequestDTO param) {

        EnterpriseRegister item = enterpriseRegisterService.getOne(
                enterpriseRegisterService.query().ge(true, "email", param.getEmail())
        );
        if (item != null) {
            return ResponseDTO.<Boolean>builder()
                    .code(HttpStatus.BAD_REQUEST.value()).message("email already exists!").data(false).build();
        }

        return ResponseDTO.<Boolean>builder().data(true).build();
    }

    private String generateRealm(String email) {
        return email.substring(0, email.indexOf("@"));
    }

    @GetMapping(path = "/logout")
    @ResponseBody
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        @SuppressWarnings("rawtypes")
        KeycloakPrincipal userPrincipal = (KeycloakPrincipal) request.getUserPrincipal();
        RefreshableKeycloakSecurityContext keycloakSecurityContext =
                (RefreshableKeycloakSecurityContext) userPrincipal.getKeycloakSecurityContext();

//        keycloakSecurityContext.logout(keycloakSecurityContext.getDeployment());
//        request.logout();
        keycloakSecurityContext.setAuthorizationContext(null);
        keycloakSecurityContext.setCurrentRequestInfo(null, null);


        AuthClientMeta authClientMeta = AuthClientMeta.builder()
                .authServerUrl(authServerUrl)
                .realmName(realmName)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .refreshToken(keycloakSecurityContext.getRefreshToken()).build();
        userService.logout(authClientMeta, request, response);
    }
}
