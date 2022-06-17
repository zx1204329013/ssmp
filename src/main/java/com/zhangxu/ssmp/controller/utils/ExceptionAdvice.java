package com.zhangxu.ssmp.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public AxiosResult doException(Exception exception){
        exception.printStackTrace();
        return new AxiosResult(false , false , null);
    }
}
