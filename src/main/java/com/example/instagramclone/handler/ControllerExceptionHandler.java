package com.example.instagramclone.handler;

import com.example.instagramclone.handler.ex.CustomValidationException;
import com.example.instagramclone.utill.Script;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
        return Script.back(e.getErrorMap().toString());
    }
    
//    public new CMRespDto<?> validationException(CustomValidationException e) {
//        return new CMRespDto<Map<String, String>>(-1,e.getMessage(),e.getErrorMap());
//    }
}
