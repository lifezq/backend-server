package com.dpi.web.convert;

import com.dpi.web.dto.FunctionModelDTO;
import com.dpi.web.mapper.auto.entity.FunctionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.web.convert
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
