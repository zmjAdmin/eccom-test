package com.eccom.starter.controller;

import com.eccom.starter.common.JsonData;
import com.eccom.starter.common.Resources;
import com.eccom.starter.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private Resources resources;

    @GetMapping("/hello")
    public String hello() {
        return "hello springboot";
    }

    @GetMapping("/{id}")
    public JsonData getUserById(@PathVariable("id") Long id) {
        User user = new User(id, "eccom", "123456", new Date(), 18, "1234");
        return JsonData.ok(user);
    }

    @GetMapping("/res")
    public JsonData getResource() {
        System.out.println(resources);
        Resources bean = new Resources();
        BeanUtils.copyProperties(resources, bean);
        return JsonData.ok(bean);
    }

}
