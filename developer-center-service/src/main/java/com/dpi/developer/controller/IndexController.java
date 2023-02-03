package com.dpi.developer.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @Package com.dpi.developer.controller
 * @ClassName IndexController
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/19
 */
@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    Environment environment;

    @GetMapping(value = "/{tenant}", produces = "text/plain;charset=UTF-8")
    public String index(@PathVariable String tenant, HttpServletRequest request,
                        HttpServletResponse response) throws UnknownHostException {

        @SuppressWarnings("rawtypes")
        KeycloakPrincipal principal = (KeycloakPrincipal) request.getUserPrincipal();
        if (principal != null) {
            KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
            Cookie cookie = new Cookie("token", keycloakSecurityContext.getTokenString());
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return String.format("欢迎租户[%s]->用户<%s>来到开发者中心,\n当前节点:%s:%s",
                    tenant, getUsernameFromRequest(request), Inet4Address.getLocalHost().getHostAddress(),
                    environment.getProperty("server.port"));
        }

        return "尚未登录...";
    }

    public String getUsernameFromRequest(HttpServletRequest request) {
        @SuppressWarnings("rawtypes")
        KeycloakPrincipal principal = (KeycloakPrincipal) request.getUserPrincipal();
        KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
        return keycloakSecurityContext.getIdToken().getPreferredUsername();
    }
}
