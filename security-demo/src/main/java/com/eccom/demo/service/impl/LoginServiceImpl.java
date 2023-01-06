package com.eccom.demo.service.impl;

import com.eccom.demo.pojo.entity.User;
import com.eccom.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public boolean login(User user) {
        // 将用户名密码封装为UsernamePasswordAuthenticationToken对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        // 调用authenticationManager的认证方法
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        // 认证未通过
        if(Objects.isNull(authenticate)){
            // TODO 抛出异常，给用户提示
            throw new RuntimeException("用户名或密码错误");
        }

        // 认证通过 --> 使用JWT生成token并返回
        return true;
    }

}
