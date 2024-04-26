package com.hcl.hackathon.demo.configuration.exceptionHandler;


import com.hcl.hackathon.demo.constants.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * CustomGlobalExceptionHandler.
 *
 * @author Chinthana.
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        log.error("Exception Caught" + "at handleAllException {} {}", ex, request);
        CustomErrorDetails customErrorDetails = CustomErrorDetails.
                of(StatusCode.INTERNAL_SERVER_ERROR.getCode(), StatusCode.INTERNAL_SERVER_ERROR.getDesc());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
