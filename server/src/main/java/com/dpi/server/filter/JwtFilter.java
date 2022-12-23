package com.dpi.server.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dpi.server.enums.JwtAuthorizationEnum;
import com.dpi.server.service.CustomUserDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Package com.dpi.server.filter
 * @ClassName JwtFilter
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
@Component
public class JwtFilter extends OncePerRequestFilter {
    private static final Logger log = LogManager.getLogger(JwtFilter.class);

    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = JwtAuthorizationEnum.getTokenFromRequest(request);


        if (token != null) {

            String invalidToken = redisTemplate.opsForValue().get(JwtAuthorizationEnum.JWT_INVALID_TOKEN_KEY_PREFIX.getName() + token);
            if (invalidToken != null) {
                if (SecurityContextHolder.getContext().getAuthentication() != null) {
                    SecurityContextHolder.getContext().setAuthentication(null);
                }
            } else {

                try {
                    Algorithm algorithm = Algorithm.HMAC256(JwtAuthorizationEnum.SECRET_KEY.getName().getBytes(StandardCharsets.UTF_8));


                    DecodedJWT decodedJwt = JWT.require(algorithm).withIssuer(JwtAuthorizationEnum.ISSURE.getName()).build().verify(token);

                    String username = decodedJwt.getClaim(JwtAuthorizationEnum.AUTHORIZATION_USERNAME.getName()).asString();

                    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                        User user = (User) userDetailsService.loadUserByUsername(username);
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                                UsernamePasswordAuthenticationToken(username, user.getPassword(), user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                } catch (Exception e) {
                    SecurityContextHolder.getContext().setAuthentication(null);
                    log.error("JWT Decode Exception:{}", e);
                }
            }
        }


        filterChain.doFilter(request, response);
    }
}
