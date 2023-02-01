package com.dpi.database.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.database.mapper.auto.entity.Tenant;
import com.dpi.database.mapper.auto.service.TenantService;
import com.dpi.database.mapper.auto.mapper.TenantMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_tenant(租户表)】的数据库操作Service实现
* @createDate 2023-01-31 11:46:36
*/
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant>
    implements TenantService{

}




