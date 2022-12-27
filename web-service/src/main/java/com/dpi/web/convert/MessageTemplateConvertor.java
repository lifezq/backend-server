package com.dpi.web.convert;

import com.dpi.web.dto.MessageTemplateDTO;
import com.dpi.web.mapper.auto.entity.MessageTemplate;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.web.convert
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
