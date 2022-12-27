package com.dpi.web.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.web.mapper.auto.entity.UserRole;
import com.dpi.web.mapper.auto.service.UserRoleService;
import com.dpi.web.mapper.auto.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_user_role(角色表)】的数据库操作Service实现
* @createDate 2022-12-27 11:28:40
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




