package com.eccom.starter.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.eccom.starter.controller..*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void beforeLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印url
        log.info("url={}", request.getRequestURL());
        // 打印请求方式
        log.info("method={}", request.getMethod());
        // 打印ip
        log.info("ip={}", request.getRemoteAddr());
        // 类方法
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName());
        // 参数信息
        log.info("args={}", joinPoint.getArgs());
    }

    @After("pointcut()")
    public void afterLog() {

    }

}
