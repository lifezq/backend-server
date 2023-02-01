package com.dpi.account.dto;

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
    private String email;
    private String unifiedCorporateSocialCreditCode;
    private String nameCh;
    private String nameEn;
}
