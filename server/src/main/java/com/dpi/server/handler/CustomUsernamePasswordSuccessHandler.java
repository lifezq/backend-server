package com.dpi.server.handler;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dpi.server.dto.ResponseDto;
import com.dpi.server.enums.CommonEnum;
import com.dpi.server.enums.JwtAuthorizationEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.dpi.server.filter
 * @ClassName CustomUsernamePasswordFilter
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
public class CustomUsernamePasswordSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger log = LogManager.getLogger(CustomUsernamePasswordSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        User user = (User) authentication.getPrincipal();

        String[] roles = new String[user.getAuthorities().size()];
        for (int i = 0; i < user.getAuthorities().size(); i++) {
            roles[i] = user.getAuthorities().iterator().next().getAuthority();
        }

        Algorithm algorithm = Algorithm.HMAC256(JwtAuthorizationEnum.SECRET_KEY.getName().
                getBytes(StandardCharsets.UTF_8));
        String token = JWT.create()
                .withArrayClaim(JwtAuthorizationEnum.AUTHORIZATION_ROLES.getName(), roles)
                .withClaim(JwtAuthorizationEnum.AUTHORIZATION_USERNAME.getName(), user.getUsername())
                .withIssuer(JwtAuthorizationEnum.ISSURE.getName())
                .withIssuedAt(new Date())
                .withExpiresAt(Instant.now().plusSeconds(60 * 60 * 24 * 15))
                .sign(algorithm);

//        Cookie cookie = new Cookie(JwtAuthorizationEnum.AUTHORIZATION_KEY.getName(), token);
//        cookie.setPath("/");
//        cookie.setMaxAge(60 * 60 * 24 * 15);
//        cookie.setHttpOnly(false);
//        response.addCookie(cookie);
//        response.setHeader(JwtAuthorizationEnum.AUTHORIZATION_KEY.getName(), token);


        log.info("System user[{}] login success, and generate token:{}", user.getUsername(), token);


        response.setStatus(HttpStatus.OK.value());

        Map<String, String> data = new HashMap<>();
        data.put("token", token);
        ResponseDto responseDto = ResponseDto.builder()
                .userMessage("登录成功")
                .data(data).build();
        response.setHeader(CommonEnum.MEDIA_TYPE_APPLICATION_JSON.getName(),
                CommonEnum.MEDIA_TYPE_APPLICATION_JSON.getValue());
        response.getWriter().write(JSON.toJSONString(responseDto));

//        super.onAuthenticationSuccess(request, response, authentication);
    }
}
