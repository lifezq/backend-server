package com.dpi.database.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.database.mapper.auto.entity.User;
import com.dpi.database.mapper.auto.service.UserService;
import com.dpi.database.mapper.auto.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_user(用户表)】的数据库操作Service实现
* @createDate 2023-01-31 11:46:36
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




