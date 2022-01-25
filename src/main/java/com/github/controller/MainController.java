package com.github.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//import com.github.annotation.CustomExceptionHandler;
import com.github.exception.BusinessException;
import com.github.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//@CustomExceptionHandler
@RestController
public class MainController {

  @GetMapping(value = "/testDefaultControllerAdvice", produces = APPLICATION_JSON_VALUE)
  public Response testExceptionHandler(
      @RequestParam(required = false, defaultValue = "false") boolean exception)
      throws BusinessException {
    if (exception) {
      throw new BusinessException("BusinessException in testExceptionHandler");
    }
    return new Response("OK");
  }

//  простая реализация, но отсутствует тело запроса
  @GetMapping(value = "/testResponseStatusException", produces = APPLICATION_JSON_VALUE)
  public Response testResponseStatusException(
      @RequestParam(required = false, defaultValue = "false") boolean exception) {
    if (exception) {
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR,
          "ResponseStatusException in testResponseStatusException");
    }
    return new Response("OK");
  }
}
