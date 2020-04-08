package com.example.validdemo.config;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author chenheng
 * @time 2020/4/8 9:40
 */
@RestControllerAdvice
public class GlobalExceptionAdviceHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuilder sb = new StringBuilder();
        allErrors.forEach(item -> {
            String defaultMessage = item.getDefaultMessage();
            sb.append(defaultMessage).append(".");
        });
        return sb.deleteCharAt(sb.lastIndexOf(".")).toString();
    }
}
