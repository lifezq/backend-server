package com.dpi.account.advice;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
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

    @ModelAttribute
    public void addAttributes(HttpServletRequest request, Model model) {
        @SuppressWarnings("rawtypes")
        KeycloakPrincipal principal = (KeycloakPrincipal) request.getUserPrincipal();
        if (principal != null) {
            KeycloakSecurityContext keycloakSecurityContext = principal.getKeycloakSecurityContext();
            model.addAttribute("username", keycloakSecurityContext.getIdToken().getPreferredUsername());
        }

        model.addAttribute("request", request);
        model.addAttribute("base", request.getContextPath());
        model.addAttribute("today", LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd E")));
    }
}
