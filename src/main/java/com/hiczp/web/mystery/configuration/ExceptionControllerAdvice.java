package com.hiczp.web.mystery.configuration;

import com.hiczp.web.mystery.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Created by czp on 17-7-13.
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = {IllegalStateException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ResponseDto> illegalArgumentHandler() {
        return new ResponseEntity<>(new ResponseDto(-400, "IllegalArgument"), HttpStatus.BAD_REQUEST);
    }
}
