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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(CustomizedException.class)
    public ModelAndView handleCustomException(HttpServletRequest request, CustomizedException ex) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(ex.getErrorCode());
        responseEntity.setErrorMsg(ex.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", responseEntity);
        modelAndView.setViewName("error");

        return modelAndView;
    }



    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handleMethodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(ErrorCodes.INVALID_PARAM_TYPE);
        responseEntity.setErrorMsg("Invalid parameter type");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", responseEntity);
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ModelAndView handleHttpMessageNotReadableException(HttpServletRequest request, HttpMessageNotReadableException ex) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(ErrorCodes.INVALID_REQUEST_BODY);
        responseEntity.setErrorMsg("Invalid request body");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", responseEntity);
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleUncaughtException(HttpServletRequest request, Exception ex) {
        logger.error(ex.getMessage(), ex);
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrorCode(-1);
        responseEntity.setErrorMsg("Uncaught exception");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", responseEntity);
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
