package com.dpi.database.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.database.mapper.auto.entity.UserRole;
import com.dpi.database.mapper.auto.service.UserRoleService;
import com.dpi.database.mapper.auto.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_user_role(角色表)】的数据库操作Service实现
* @createDate 2023-01-31 11:46:36
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




