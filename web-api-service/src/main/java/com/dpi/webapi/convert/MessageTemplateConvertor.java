package com.dpi.webapi.convert;

import com.dpi.webapi.dto.MessageTemplateDTO;
import com.dpi.webapi.mapper.auto.entity.MessageTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.webapi.convert
 * @ClassName MessageTemplateConvertor
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/27
 */
@Mapper
public interface MessageTemplateConvertor {
    MessageTemplateConvertor INSTANCE = Mappers.getMapper(MessageTemplateConvertor.class);

    @Mappings(value = {})
    MessageTemplateDTO toMessageTemplateDTO(MessageTemplate messageTemplate);

    @Mappings(value = {})
    MessageTemplate toMessageTemplate(MessageTemplateDTO messageTemplateDTO);
}
