package com.dpi.server.mapper.auto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dpi.server.mapper.auto.entity.PtUser;
import com.dpi.server.mapper.auto.service.PtUserService;
import com.dpi.server.mapper.auto.mapper.PtUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Ryan
* @description 针对表【pt_user】的数据库操作Service实现
* @createDate 2022-12-23 13:34:25
*/
@Service
public class PtUserServiceImpl extends ServiceImpl<PtUserMapper, PtUser>
    implements PtUserService{

}




