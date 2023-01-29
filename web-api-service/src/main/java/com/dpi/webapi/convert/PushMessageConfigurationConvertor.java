package com.dpi.webapi.convert;

import com.dpi.webapi.dto.PushMessageConfigurationDTO;
import com.dpi.webapi.mapper.auto.entity.PushMessageConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.webapi.convert
 * @ClassName PushMessageConfigurationConvertor
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/27
 */
@Mapper
public interface PushMessageConfigurationConvertor {
    PushMessageConfigurationConvertor INSTANCE = Mappers.getMapper(PushMessageConfigurationConvertor.class);

    @Mappings(value = {})
    PushMessageConfigurationDTO toMessageConfigurationDTO(PushMessageConfiguration pushMessageConfiguration);

    @Mappings(value = {})
    PushMessageConfiguration toMessageConfiguration(PushMessageConfigurationDTO pushMessageConfigurationDTO);
}
