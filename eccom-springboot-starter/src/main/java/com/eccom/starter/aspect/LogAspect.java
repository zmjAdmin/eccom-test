package com.eccom.starter.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class LogAspect {

    // private final static Logger logger = (Logger) LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.eccom.starter.controller.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void beforeLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印url
        System.out.println("url=" + request.getRequestURL());
        // 打印请求方式
        System.out.println("method=" + request.getMethod());
        // 打印ip
        System.out.println("ip=" + request.getRemoteAddr());
        // 类方法
        System.out.println("class_method=" + joinPoint.getSignature().getDeclaringTypeName());
        // 参数信息
        System.out.println("args=" + joinPoint.getArgs());
    }

    @After("pointcut()")
    public void afterLog() {

    }

}
