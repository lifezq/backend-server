package com.dpi.common.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.dpi.common.bo
 * @ClassName AuthClientMeta
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/19
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthClientMeta {
    private String authServerUrl;
    private String realmName;
    private String clientId;
    private String clientSecret;
    private String refreshToken;
}
