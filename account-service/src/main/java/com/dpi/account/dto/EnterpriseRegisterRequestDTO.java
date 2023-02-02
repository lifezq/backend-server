package com.dpi.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package com.dpi.account.dto
 * @ClassName EnterpriseRegisterRequestDTO
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseRegisterRequestDTO {
    @Schema(title = "邮箱", example = "abc@gmail.com")
    private String email;

    @Schema(title = "企业统一社会信用代码", example = "000000000000001")
    private String unifiedCorporateSocialCreditCode;

    @Schema(title = "中文名", example = "中文")
    private String nameCh;

    @Schema(title = "英文名", example = "english")
    private String nameEn;
}
