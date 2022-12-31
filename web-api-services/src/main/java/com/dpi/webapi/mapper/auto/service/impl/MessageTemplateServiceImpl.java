package com.dpi.webapi.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.webapi.mapper.auto.entity.MessageTemplate;
import com.dpi.webapi.mapper.auto.service.MessageTemplateService;
import com.dpi.webapi.mapper.auto.mapper.MessageTemplateMapper;
import org.springframework.stereotype.Service;

/**
* @author lifez
* @description 针对表【pt_message_template(平台消息模板表)】的数据库操作Service实现
* @createDate 2022-12-31 21:16:55
*/
@Service
public class MessageTemplateServiceImpl extends ServiceImpl<MessageTemplateMapper, MessageTemplate>
    implements MessageTemplateService{

}




