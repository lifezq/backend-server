package com.dpi.server.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dpi.server.enums.JwtAuthorizationEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Package com.dpi.server.handler
 * @ClassName CustomLogoutHandler
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
@Component
public class CustomLogoutHandler implements LogoutHandler {
    private static final Logger log = LogManager.getLogger(CustomLogoutHandler.class);
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Cookie cookie = new Cookie(JwtAuthorizationEnum.AUTHORIZATION_KEY.getName(), "");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);

        String token = JwtAuthorizationEnum.getTokenFromRequest(request);
        if (token != null) {

            Algorithm algorithm = Algorithm.HMAC256(JwtAuthorizationEnum.SECRET_KEY.
                    getName().getBytes(StandardCharsets.UTF_8));

            DecodedJWT decodedJwt = JWT.require(algorithm).withIssuer(
                    JwtAuthorizationEnum.ISSURE.getName()).build().verify(token);

            log.info("System user[{}] has logged out",
                    decodedJwt.getClaim(JwtAuthorizationEnum.AUTHORIZATION_USERNAME.getName()).asString());

            redisTemplate.opsForValue().set(JwtAuthorizationEnum.JWT_INVALID_TOKEN_KEY_PREFIX.getName() + token,
                    new Date().toString(), 60 * 60 * 24 * 7, TimeUnit.SECONDS);
        }
    }
}
