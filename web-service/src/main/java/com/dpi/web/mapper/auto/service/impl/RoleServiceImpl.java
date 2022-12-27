package com.dpi.web.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.web.mapper.auto.entity.Role;
import com.dpi.web.mapper.auto.service.RoleService;
import com.dpi.web.mapper.auto.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_role(角色表)】的数据库操作Service实现
* @createDate 2022-12-27 11:28:40
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




