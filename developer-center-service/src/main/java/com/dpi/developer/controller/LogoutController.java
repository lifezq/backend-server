package com.dpi.developer.controller;

import com.dpi.common.bo.AuthClientMeta;
import com.dpi.common.service.CommonUserService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package com.dpi.developer.controller
 * @ClassName LogoutController
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/19
 */
@RequestMapping("/api")
@RestController
public class LogoutController {
    @Value("${keycloak.realm}")
    private String realmName;
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.credentials.secret}")
    private String clientSecret;
    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Autowired
    private CommonUserService userService;

    @GetMapping("/logout")
    public void ssoLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        @SuppressWarnings("rawtypes")
        KeycloakPrincipal userPrincipal = (KeycloakPrincipal) request.getUserPrincipal();
        RefreshableKeycloakSecurityContext keycloakSecurityContext =
                (RefreshableKeycloakSecurityContext) userPrincipal.getKeycloakSecurityContext();


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
