package example.hellosecurity.common.filter;

import example.hellosecurity.common.util.JwtUtil;
import example.hellosecurity.common.util.RedisCache;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 验证token
        String userId = null;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            // TODO 有多种异常
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        // 获取redis中的token
        token = redisCache.getCacheObject("login:" + userId);
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("登录过期，请重新登录");
        }
        //TODO 获取权限信息封装到Authentication中
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(Long.parseLong(userId), null, null));
        filterChain.doFilter(request, response);
    }

}
