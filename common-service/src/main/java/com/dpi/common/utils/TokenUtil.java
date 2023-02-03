package com.dpi.common.utils;

import org.keycloak.TokenVerifier;
import org.keycloak.common.VerificationException;
import org.keycloak.representations.AccessToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Package com.dpi.account.utils
 * @ClassName TokenUtil
 * @Description TODO
 * @Author Ryan
 * @Date 2023/2/3
 */
public class TokenUtil {

    public static AccessToken parseTokenFromRequest(HttpServletRequest request) {
        String token;
        Cookie cookie = Arrays.stream(request.getCookies())
                .filter(x -> x.getName().equals("token"))
                .findFirst().orElse(null);
        if (cookie == null) {
            return null;
        }

        token = cookie.getValue();

        AccessToken accessToken;

        try {
            TokenVerifier<AccessToken> tokenVerifier = TokenVerifier
                    .create(token, AccessToken.class);

            accessToken = tokenVerifier.getToken();
            if (!accessToken.isActive()) {
                accessToken = null;
            }
        } catch (VerificationException e) {
//            e.printStackTrace();
            return null;
        }

        return accessToken;
    }
}
