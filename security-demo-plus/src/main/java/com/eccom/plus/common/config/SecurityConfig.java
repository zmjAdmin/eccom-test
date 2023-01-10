package com.eccom.plus.common.config;

import com.eccom.plus.common.handler.DefaultAuthenticationFailureHandler;
import com.eccom.plus.common.handler.DefaultAuthenticationSuccessHandler;
import com.eccom.plus.common.handler.DefaultLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * 配置AuthenticationManagerBuilder
     * 默认情况下，如果工程内有UserDetailsService实现对象，会加载改对象
     *
     * @param auth AuthenticationManager构建器
     * @throws Exception 异常
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()   // 除了上述url其他都需要认证
                .and()
                .formLogin()
                .loginProcessingUrl("/login")   // 指定登录请求的url 默认：/login
                .usernameParameter("username")  // 指定用户名的参数名称 默认：username
                .passwordParameter("password")  // 指定密码的参数名称 默认：password
                .successHandler(new DefaultAuthenticationSuccessHandler())  // 指定证求成功处理
                .failureHandler(new DefaultAuthenticationFailureHandler())  // 指定认证失败处理
                .and()
                .logout()
                .logoutUrl("/logout")           // 指定注销登录url 默认：/logout
                .logoutSuccessHandler(new DefaultLogoutSuccessHandler())    // 指定注销登录成功处理
                .and()
                .csrf().disable();
    }

}
