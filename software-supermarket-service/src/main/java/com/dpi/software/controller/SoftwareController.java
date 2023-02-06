package com.dpi.software.controller;

import com.dpi.common.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
 * @Package com.dpi.software.controller
 * @ClassName SoftwareController
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@Tag(name = "软件应用接口")
@RequestMapping("/software")
@RestController
public class SoftwareController {
    @Autowired
    Environment environment;

    @Operation(summary = "获取应用列表", method = "GET")
    @GetMapping("/soft/{id}")
    public ResponseDTO<Integer> get(@PathVariable Integer id) {
        return ResponseDTO.<Integer>builder().data(0).build();
    }

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
            return String.format("欢迎租户[%s]->用户<%s>来到软件超市应用中心,\n当前节点:%s:%s",
                    keycloakSecurityContext.getRealm(), keycloakSecurityContext.getIdToken().getPreferredUsername(),
                    Inet4Address.getLocalHost().getHostAddress(),
                    environment.getProperty("server.port"));
        }

        return "尚未登录...";
    }
}

