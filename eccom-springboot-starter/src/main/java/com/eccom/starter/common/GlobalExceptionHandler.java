package com.eccom.starter.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public JsonData exceptionHandler(Exception e) {
        e.printStackTrace();
        return JsonData.error(e.getMessage());
    }

}
