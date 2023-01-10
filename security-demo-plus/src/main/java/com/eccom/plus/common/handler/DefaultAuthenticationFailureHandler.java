package com.eccom.plus.common.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DefaultAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 返回数据
        Map<String, Object> resultMap = new HashMap<>();
        // 封装返回数据
        resultMap.put("code", 401);
        resultMap.put("msg", "用户名或密码错误");
        resultMap.put("data", exception);
        // 序列化返回对象
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(resultMap);
        // 写出数据
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(result);
    }

}
