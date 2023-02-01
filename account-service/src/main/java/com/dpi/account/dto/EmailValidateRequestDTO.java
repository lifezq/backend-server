package com.dpi.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.dpi.account.dto
 * @ClassName EmailValidateRequestDTO
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailValidateRequestDTO {
    private String email;
}
