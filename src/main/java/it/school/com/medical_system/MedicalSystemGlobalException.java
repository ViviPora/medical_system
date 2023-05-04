package it.school.com.medical_system;

import it.school.com.medical_system.Responses.ErrorResponse;
import it.school.com.medical_system.exception.InexistentResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MedicalSystemGlobalException {
    @ExceptionHandler(InexistentResourceException.class)
    public ResponseEntity<ErrorResponse> handleInexistentResource(InexistentResourceException e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
