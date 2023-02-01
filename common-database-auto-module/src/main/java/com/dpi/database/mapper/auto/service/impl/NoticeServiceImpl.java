package com.dpi.database.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.database.mapper.auto.entity.Notice;
import com.dpi.database.mapper.auto.service.NoticeService;
import com.dpi.database.mapper.auto.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_notice(公告信息表)】的数据库操作Service实现
* @createDate 2023-01-31 11:46:36
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




