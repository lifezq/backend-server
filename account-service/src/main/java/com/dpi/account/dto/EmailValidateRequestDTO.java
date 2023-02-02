package com.dpi.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(title = "邮箱", example = "abc@gmail.com")
    private String email;
}
