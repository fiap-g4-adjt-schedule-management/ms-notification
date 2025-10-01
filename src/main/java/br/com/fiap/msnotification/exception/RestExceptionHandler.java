package br.com.fiap.msnotification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
/*
    private ResponseEntity<Object> buildResponseEntity(HttpStatus status, String message, Object body) {
        return null;
    }
*/
}
