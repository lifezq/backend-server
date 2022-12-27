package com.dpi.web.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.web.mapper.auto.entity.Tenant;
import com.dpi.web.mapper.auto.service.TenantService;
import com.dpi.web.mapper.auto.mapper.TenantMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_tenant(租户表)】的数据库操作Service实现
* @createDate 2022-12-27 11:28:40
*/
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant>
    implements TenantService{

}




