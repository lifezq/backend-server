package com.dpi.webapi.convert;

import com.dpi.database.mapper.auto.entity.Notice;
import com.dpi.webapi.dto.NoticeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.dpi.webapi.convert
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
