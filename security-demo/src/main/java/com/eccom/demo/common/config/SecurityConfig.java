package com.eccom.demo.common.config;

import com.eccom.demo.common.filter.TokenLoginFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /* @Autowired
     private JwtAuthenticationFilter jwtAuthenticationFilter;*/

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new NonPasswordEncoder();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf
                .csrf().disable()
                // 不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin();
                // 对于登录接口 允许匿名访问
                // .antMatchers("/user/login").anonymous()
                // 除上面外的所有请求全部需要鉴权认证
        // 把token校验过滤器添加到过滤器链中
        // http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // 替换UsernamePasswordAuthenticationFilter改为自定义
        http.addFilterAt(new TokenLoginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /*@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return new ProviderManager();
    }*/

}

