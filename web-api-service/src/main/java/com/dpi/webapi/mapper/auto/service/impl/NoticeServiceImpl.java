package com.dpi.webapi.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.webapi.mapper.auto.entity.Notice;
import com.dpi.webapi.mapper.auto.service.NoticeService;
import com.dpi.webapi.mapper.auto.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
* @author lifez
* @description 针对表【pt_notice(公告信息表)】的数据库操作Service实现
* @createDate 2022-12-31 21:16:55
*/
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
    implements NoticeService{

}




