package com.eccom.demo.controller;

import com.eccom.demo.pojo.entity.User;
import com.eccom.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        return loginService.login(user);
    }

}
