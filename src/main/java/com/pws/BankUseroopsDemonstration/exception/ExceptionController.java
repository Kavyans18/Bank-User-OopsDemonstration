package com.pws.BankUseroopsDemonstration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

    @ExceptionHandler({IdNotFoundException.class})
    public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoDataAvailableException.class)
    public ResponseEntity<String> handleNoDataAvailableExcepiton(NoDataAvailableException exception) {
        exception.getMessage();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
