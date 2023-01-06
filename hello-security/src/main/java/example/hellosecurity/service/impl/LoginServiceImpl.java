package example.hellosecurity.service.impl;

import example.hellosecurity.common.util.RedisCache;
import example.hellosecurity.domain.User;
import example.hellosecurity.domain.UserDetailsDTO;
import example.hellosecurity.common.util.JwtUtil;
import example.hellosecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;

    @Override
    public String login(User user) {
        // System.out.println(user);
        // 调用AuthenticationManager进行认证
        Authentication authenticate = null;
        try {
            authenticate =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(), new ArrayList<>())
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        // System.out.println(user);
        // 认证失败 --> 抛出异常
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登录失败");
        }
        // 认证通过 --> 生成token，并将token存入redis中
        UserDetailsDTO userDetailsDTO = (UserDetailsDTO) authenticate.getPrincipal();
        String userId = userDetailsDTO.getUser().getId().toString();
        String token = JwtUtil.createJWT(userId);
        redisCache.setCacheObject("login:" + userId, token, 2, TimeUnit.MINUTES);
        return token;
    }

}
