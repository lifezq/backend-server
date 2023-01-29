package com.dpi.common.service;

import com.dpi.common.bo.AuthClientMeta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package com.dpi.common.service
 * @ClassName UserService
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/19
 */
@Slf4j
@Service
public class CommonUserService {
    public void logout(AuthClientMeta authClientMeta, HttpServletResponse response) throws IOException {
        try {
            String url = authClientMeta.getAuthServerUrl() + "/realms/" + authClientMeta.getRealmName() +
                    "/protocol/openid-connect/logout?" +
                    "client_id=" + authClientMeta.getClientId() + "&" +
                    "client_secret=" + authClientMeta.getClientSecret() + "&" +
                    "refresh_token=" + authClientMeta.getRefreshToken();

            Cookie cookie = new Cookie("JSESSIONID", "");
            cookie.setPath("/");
            cookie.setHttpOnly(false);
            cookie.setMaxAge(-1);
            response.addCookie(cookie);

            response.sendRedirect(url);
        } catch (IOException e) {
            log.info(e.getMessage(), e);
            throw e;
        }
    }
}
