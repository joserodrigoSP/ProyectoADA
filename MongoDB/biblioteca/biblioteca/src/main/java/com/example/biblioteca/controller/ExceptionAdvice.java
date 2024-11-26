package com.example.biblioteca.controller;

import com.example.biblioteca.exception.BibliotecaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ExceptionAdvice {


    Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
    @ResponseBody
    @ExceptionHandler(BibliotecaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public String resourseNotFoundException(BibliotecaNotFoundException e) {
        return e.getMessage();
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

    public String exception(Exception e) {
        logger.error("ERROR", e);
        return "Ha ocurrido un error, contacta con el servicio tecnico";
    }

}
