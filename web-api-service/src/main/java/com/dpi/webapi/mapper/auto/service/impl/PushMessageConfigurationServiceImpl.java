package com.dpi.webapi.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.webapi.mapper.auto.entity.PushMessageConfiguration;
import com.dpi.webapi.mapper.auto.service.PushMessageConfigurationService;
import com.dpi.webapi.mapper.auto.mapper.PushMessageConfigurationMapper;
import org.springframework.stereotype.Service;

/**
* @author lifez
* @description 针对表【pt_push_message_configuration(平台消息推送任务配置表)】的数据库操作Service实现
* @createDate 2022-12-31 21:16:55
*/
@Service
public class PushMessageConfigurationServiceImpl extends ServiceImpl<PushMessageConfigurationMapper, PushMessageConfiguration>
    implements PushMessageConfigurationService{

}




