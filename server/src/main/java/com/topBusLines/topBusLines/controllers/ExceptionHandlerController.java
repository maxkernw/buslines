package com.topBusLines.topBusLines.controllers;

import com.topBusLines.topBusLines.exceptions.TrafiklabRequestException;
import com.topBusLines.topBusLines.models.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TrafiklabRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResponse handleTrafiklabRequestException(TrafiklabRequestException ex) {
        return new JsonResponse(ex.getMessage(), 400);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JsonResponse handleException(Exception ex) {
        return new JsonResponse("Something went wrong", 404);
    }

}
