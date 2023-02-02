package com.dpi.account.advice;

import org.jetbrains.annotations.NotNull;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Package com.dpi.account.advice
 * @ClassName ControllerAdvice
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/17
 */
@RestControllerAdvice
public class ControllerAdvice {
    @Autowired
    Environment environment;

    @ModelAttribute
    public void addAttributes(@NotNull HttpServletRequest request, Model model) throws UnknownHostException {
        @SuppressWarnings("rawtypes")
        KeycloakPrincipal principal = (KeycloakPrincipal) request.getUserPrincipal();
        if (principal != null) {
            KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
            model.addAttribute("tenant", keycloakSecurityContext.getRealm());
            model.addAttribute("username", keycloakSecurityContext.getIdToken().getPreferredUsername());
            model.addAttribute("nodeHost", Inet4Address.getLocalHost().getHostAddress());
            model.addAttribute("nodePort", environment.getProperty("server.port"));
        }

        model.addAttribute("request", request);
        model.addAttribute("base", request.getContextPath());
        model.addAttribute("today", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd E")));
    }
}
