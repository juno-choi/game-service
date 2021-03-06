package com.juno.game.advice;

import com.juno.game.api.dto.ErrorApi;
import com.juno.game.controller.exception.CommonException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CommonAdvice {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity commonExceptionAdvice(CommonException ce){
        ErrorApi error = new ErrorApi(ce.getCode(), ce.getMsg());
        return ResponseEntity.status(ce.getStatus()).body(error);
    }
}
