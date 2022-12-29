package com.eccom.starter.controller;

import com.eccom.starter.common.JsonData;
import com.eccom.starter.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @param bindingResult 校验出错信息
     * @return 添加结果
     */
    @RequestMapping("/add")
    public JsonData addUser(@Valid User user, BindingResult bindingResult) {
        // 数据校验出错
        if (bindingResult.hasErrors()) {
            // 存储错误信息
            Map<String, String> map = new HashMap<>();
            // 校验失败
            bindingResult.getFieldErrors().forEach(new Consumer<FieldError>() {
                @Override
                public void accept(FieldError fieldError) {
                    // 打印校验出错信息
                    System.out.println(fieldError.getDefaultMessage());
                    // 存储在map
                    map.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            });
            return JsonData.error(map);
        }
        return JsonData.ok();
    }

}
