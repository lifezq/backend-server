package com.dpi.webapi.convert;

import com.dpi.database.mapper.auto.entity.FunctionModel;
import com.dpi.webapi.dto.FunctionModelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.webapi.convert
 * @ClassName FunctionModelConvert
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/26
 */
@Mapper
public interface FunctionModelConvertor {
    FunctionModelConvertor INSTANCE = Mappers.getMapper(FunctionModelConvertor.class);

    @Mappings(value = {})
    FunctionModelDTO toFunctionModelDTO(FunctionModel functionModel);

    @Mappings(value = {})
    FunctionModel toFunctionModel(FunctionModelDTO functionModelDTO);
}
