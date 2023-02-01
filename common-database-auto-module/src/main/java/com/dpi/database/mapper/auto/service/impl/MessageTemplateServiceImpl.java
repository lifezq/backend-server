package com.dpi.database.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.database.mapper.auto.entity.MessageTemplate;
import com.dpi.database.mapper.auto.service.MessageTemplateService;
import com.dpi.database.mapper.auto.mapper.MessageTemplateMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_message_template(平台消息模板表)】的数据库操作Service实现
* @createDate 2023-01-31 11:46:36
*/
@Service
public class MessageTemplateServiceImpl extends ServiceImpl<MessageTemplateMapper, MessageTemplate>
    implements MessageTemplateService{

}




