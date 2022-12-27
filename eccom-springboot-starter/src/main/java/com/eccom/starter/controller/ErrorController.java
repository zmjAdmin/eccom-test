package com.eccom.starter.controller;

import com.eccom.starter.common.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/err")
public class ErrorController {

    @GetMapping("/error")
    public JsonData error() {
        return JsonData.ok(1/0);
    }

}
