package com.dpi.account.convert;

import com.dpi.account.dto.EnterpriseRegisterRequestDTO;
import com.dpi.database.mapper.auto.entity.EnterpriseRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.account.convert
 * @ClassName EnterpriseRegisterConvertor
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/31
 */
@Mapper
public interface EnterpriseRegisterConvertor {
    EnterpriseRegisterConvertor INSTANCE = Mappers.getMapper(EnterpriseRegisterConvertor.class);

    @Mappings(value = {
            @Mapping(source = "ucscc", target = "unifiedCorporateSocialCreditCode")
    })
    EnterpriseRegisterRequestDTO toEnterpriseRegisterRequestDTO(EnterpriseRegister enterpriseRegister);

    @Mappings(value = {
            @Mapping(source = "unifiedCorporateSocialCreditCode", target = "ucscc")
    })
    EnterpriseRegister toEnterpriseRegister(EnterpriseRegisterRequestDTO enterpriseRegisterRequestDTO);
}
