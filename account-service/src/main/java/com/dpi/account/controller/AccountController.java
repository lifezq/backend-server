package com.dpi.account.controller;

import com.dpi.common.bo.AuthClientMeta;
import com.dpi.common.service.CommonUserService;
import lombok.extern.log4j.Log4j2;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Package com.dpi.account.controller
 * @ClassName AccountController
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/16
 */
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

    @GetMapping("/login")
    public String login() {
        return "/account/login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public String doLogin() {
        return "do login process...";
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
