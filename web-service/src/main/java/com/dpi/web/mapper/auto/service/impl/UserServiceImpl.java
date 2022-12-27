package com.dpi.web.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.web.mapper.auto.entity.User;
import com.dpi.web.mapper.auto.service.UserService;
import com.dpi.web.mapper.auto.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_user】的数据库操作Service实现
* @createDate 2022-12-27 11:28:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




