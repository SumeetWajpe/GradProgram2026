package com.demo.FinDemy.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //global exception handler method for course not found exception
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> handleCourseNotFoundException(CourseNotFoundException ex){
        System.out.println("Inside Global Exception course notFound Handler");
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
