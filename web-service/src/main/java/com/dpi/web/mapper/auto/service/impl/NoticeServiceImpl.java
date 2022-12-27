package com.dpi.web.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.web.mapper.auto.entity.Notice;
import com.dpi.web.mapper.auto.service.NoticeService;
import com.dpi.web.mapper.auto.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_notice(公告信息表)】的数据库操作Service实现
* @createDate 2022-12-27 13:56:44
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




