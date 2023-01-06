package example.hellosecurity.controller;

import example.hellosecurity.common.util.RedisCache;
import example.hellosecurity.domain.ResponseResult;
import example.hellosecurity.domain.User;
import example.hellosecurity.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisCache redisCache;

    /**
     * 用户登录
     *
     * @param user 用户登录信息
     * @return 登录结果，包括提示信息，token等
     */
    @PostMapping("/user/login")
    public ResponseResult<Map<String, String>> login(@RequestBody User user) {
        // 登录 --> 得到token
        String token = loginService.login(user);
        // 如果得到了token，登录成功；否则登录失败
        if (StringUtils.isNotBlank(token)) {
            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            return new ResponseResult<>(200, "登录成功", map);
        }
        return new ResponseResult<>(500, "登录失败");
    }

    @PostMapping("/user/logout")
    public ResponseResult<Object> logout() {
        // 通过SecurityContextHolder获得用户ID
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        System.out.println("退出登录" + userId);
        // 删除redis中的token
        redisCache.deleteObject("login:" + userId);
        return new ResponseResult(200, "注销成功", null);
    }

}
