package com.dpi.server.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dpi.server.enums.RoleAuthenticateEnum;
import com.dpi.server.mapper.auto.entity.PtUser;
import com.dpi.server.mapper.auto.entity.PtUserRole;
import com.dpi.server.mapper.auto.service.impl.PtUserRoleServiceImpl;
import com.dpi.server.mapper.auto.service.impl.PtUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Package com.dpi.server.service
 * @ClassName CustomUserDetailsService
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/23
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PtUserServiceImpl userService;
    @Autowired
    private PtUserRoleServiceImpl userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<PtUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.or().eq("phone_number", username);
        wrapper.or().eq("email", username);
     
        PtUser account = userService.getBaseMapper().selectOne(wrapper);
        if (account == null) {
            throw new UsernameNotFoundException(String.format("username:%s not found", username));
        }

        Map<String, Object> selectMap = new HashMap<>();
        selectMap.put("uid", account.getId());
        List<PtUserRole> userRoles = userRoleService.getBaseMapper().selectByMap(selectMap);
        Collection<GrantedAuthority> grantedAuthorities = new ConcurrentLinkedQueue<>();
        userRoles.stream().forEach(x -> grantedAuthorities.add(
                new SimpleGrantedAuthority(RoleAuthenticateEnum.ROLE_PREFIX.getName() + x.getRid())));
        return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
    }
}
