package com.github.controller;

//import com.github.annotation.CustomExceptionHandler;
import com.github.exception.BusinessException;
import com.github.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
//@ControllerAdvice(annotations = CustomExceptionHandler.class)
public class DefaultAdvice {

  @ExceptionHandler(BusinessException.class)
//  @ExceptionHandler({BusinessException.class, ServiceException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<Response> handleException(BusinessException e) {
    Response response = new Response(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
