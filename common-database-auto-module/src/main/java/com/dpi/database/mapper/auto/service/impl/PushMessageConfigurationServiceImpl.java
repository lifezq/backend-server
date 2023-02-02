package com.dpi.database.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.database.mapper.auto.entity.PushMessageConfiguration;
import com.dpi.database.mapper.auto.service.PushMessageConfigurationService;
import com.dpi.database.mapper.auto.mapper.PushMessageConfigurationMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_push_message_configuration(平台消息推送任务配置表)】的数据库操作Service实现
* @createDate 2023-01-31 11:46:36
*/
@Service
public class PushMessageConfigurationServiceImpl extends ServiceImpl<PushMessageConfigurationMapper, PushMessageConfiguration>
    implements PushMessageConfigurationService{

}




