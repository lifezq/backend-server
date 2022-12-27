package com.dpi.web.convert;

import com.dpi.web.dto.NoticeDTO;
import com.dpi.web.mapper.auto.entity.Notice;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.web.convert
 * @ClassName NoticeConvertor
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/27
 */
@Mapper
public interface NoticeConvertor {
    NoticeConvertor INSTANCE = Mappers.getMapper(NoticeConvertor.class);

    @Mappings(value = {})
    NoticeDTO toNoticeDTO(Notice notice);

    @Mappings(value = {})
    Notice toNotice(NoticeDTO noticeDTO);
}
