package com.eccom.demo.manager;

import com.eccom.demo.pojo.dto.UserDetailsDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsManager implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息 （以下数据应该由数据库得到）
        String dbUsername = "admin";
        String dbPassword = "{noop}123456";

        // TODO 判断用户信息，抛出对应异常

        // TODO 查询权限信息


        return new UserDetailsDTO(dbUsername, dbPassword);
    }

}
