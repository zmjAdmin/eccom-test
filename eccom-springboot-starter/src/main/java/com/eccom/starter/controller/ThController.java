package com.eccom.starter.controller;

import com.eccom.starter.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/th")
public class ThController {

    @RequestMapping("/center")
    public String center() {
        return "center";
    }

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "<i>index</i>");
        User user = new User(2L, "eccom", "123456", new Date(), 18, "1234");
        map.addAttribute("user", user);

        return "index";
    }

}
