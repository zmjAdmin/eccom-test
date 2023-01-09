package com.eccom.demo.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.eccom.demo.domain.User;
import com.eccom.demo.domain.UserDetailsDTO;
import com.eccom.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DbUserDetailsManager implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 从数据库中根据用户名查询用户信息
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName, username));
        if (Objects.isNull(user)) {
            // 用户不存在 --> 抛出异常
            System.out.println("=============数据库中未查询到数据============");
            throw new RuntimeException("用户名或密码错误");
        }
        // TODO 查询用户权限信息

        return new UserDetailsDTO(user);
    }

}
