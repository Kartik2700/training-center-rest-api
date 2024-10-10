package com.kartik.traini8.GlobalExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //Indicates that this class will handle exceptions globally for all the controller
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        // Map to hold field names as keys and their respective error messages as values
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();//Get name of field with error
            String message = error.getDefaultMessage();//Get default error message

            // Check if the field is 'contactEmail'
            if ("contactEmail".equals(fieldName)) {
                String rejectedValue = ((FieldError) error).getRejectedValue().toString();//Get the value which got rejected
                if (!rejectedValue.isEmpty()) {  // Only add email error if it's not empty
                    errors.put(fieldName, message);
                }
            } else {
                errors.put(fieldName, message); // Add other field errors normally
            }
        });
    //Return Response entity with error message and status code As Bad Request
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
