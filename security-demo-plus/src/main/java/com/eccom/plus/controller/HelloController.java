package com.eccom.plus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @RequestMapping("/search")
    public String search() {
        return "search";
    }

    @RequestMapping("/edit")
    public String edit() {
        return "edit";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }

}
