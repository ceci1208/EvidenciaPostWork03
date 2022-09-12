package org.bedu.java.backend.postwork03.controllers.handlers;


import org.bedu.java.backend.postwork03.model.RespuestaError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


//Annotation that indicates the use of exceptions.
@RestControllerAdvice

public class ManejadorGlobalErrores {

    //Annotation that indicates an action will be taken in case of an exception.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex, WebRequest request) {

        return RespuestaError.builder()
                .exception(ex)
                .mensaje("An error occurred while validating the request information.")
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }

    //Annotation that indicates an action will be taken in case of an exception.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejaException(Exception ex, WebRequest request) {
        return RespuestaError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .mensaje("An error occurred while processing the request")
                .ruta(request.getDescription(false).substring(4))
                .entidad();
    }
}