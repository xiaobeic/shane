package com.info.shane.exception;

import com.info.shane.constant.ErrorCodes;
import com.info.shane.vo.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@RestController
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(CustomizedException.class)
    public ResponseEntity handleCustomException(HttpServletRequest request, CustomizedException ex) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(ex.getErrorCode());
        responseEntity.setErrorMsg(ex.getMessage());
        return responseEntity;
    }



    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleMethodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(ErrorCodes.INVALID_PARAM_TYPE);
        responseEntity.setErrorMsg("Invalid parameter type");
        return responseEntity;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleHttpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException ex) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(ErrorCodes.INVALID_REQUEST_BODY);
        responseEntity.setErrorMsg("Invalid request body");
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleUncaughtException(HttpServletRequest request, Exception ex) {
        logger.error(ex.getMessage(), ex);
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(-1);
        responseEntity.setErrorMsg("Uncaught exception");
        return responseEntity;
    }

}
