package com.dpi.webapi.convert;

import com.dpi.database.mapper.auto.entity.PushMessageConfiguration;
import com.dpi.webapi.dto.PushMessageConfigurationDTO;
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
