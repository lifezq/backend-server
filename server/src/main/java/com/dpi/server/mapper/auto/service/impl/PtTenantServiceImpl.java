package com.dpi.server.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.server.mapper.auto.entity.PtTenant;
import com.dpi.server.mapper.auto.service.PtTenantService;
import com.dpi.server.mapper.auto.mapper.PtTenantMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_tenant(租户表)】的数据库操作Service实现
* @createDate 2022-12-23 13:34:25
*/
@Service
public class PtTenantServiceImpl extends ServiceImpl<PtTenantMapper, PtTenant>
    implements PtTenantService{

}




