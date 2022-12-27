package com.dpi.web.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.web.mapper.auto.entity.PushMessageConfiguration;
import com.dpi.web.mapper.auto.service.PushMessageConfigurationService;
import com.dpi.web.mapper.auto.mapper.PushMessageConfigurationMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_push_message_configuration(平台消息推送任务配置表)】的数据库操作Service实现
* @createDate 2022-12-27 14:37:06
*/
@Service
public class PushMessageConfigurationServiceImpl extends ServiceImpl<PushMessageConfigurationMapper, PushMessageConfiguration>
    implements PushMessageConfigurationService{

}




