package com.dpi.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.dpi.account.dto
 * @ClassName UserInfoDTO
 * @Description TODO
 * @Author Ryan
 * @Date 2023/2/2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private Object token;
}
