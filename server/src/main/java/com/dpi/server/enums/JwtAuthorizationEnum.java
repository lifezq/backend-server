package com.dpi.server.enums;

import javax.servlet.http.HttpServletRequest;

/**
 * @Package com.dpi.server.enums
 * @ClassName JwtConst
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
public enum JwtAuthorizationEnum {
    SECRET_KEY("dpi_jwt_secret_key", "jwt secret key"),
    ISSURE("dpi platform", "jwt Issuer"),
    AUTHORIZATION_BEARER("Bearer ", "authorization bearer"),
    AUTHORIZATION_KEY("Authorization", "authorization key"),
    AUTHORIZATION_USERNAME("username", "authorization username"),
    AUTHORIZATION_PASSWORD("password", "authorization password"),
    AUTHORIZATION_ROLES("roles", "authorization roles"),
    JWT_INVALID_TOKEN_KEY_PREFIX("dpi.token.invalid.", "jwt invalid token key prefix");

    private String name;
    private String desc;

    JwtAuthorizationEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static String getTokenFromRequest(HttpServletRequest request) {
        String authorization = request.getHeader(AUTHORIZATION_KEY.getName());
        String token = null;
        if (authorization != null && authorization.startsWith(AUTHORIZATION_BEARER.getName())) {
            token = authorization.substring(7);
        }
        
        if (token != null && token.length() < 1) {
            return null;
        }

        return token;
    }
}
