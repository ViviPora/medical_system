package it.school.com.medical_system;

import it.school.com.medical_system.exception.AlreadyExistsException;
import it.school.com.medical_system.exception.NotEditableException;
import it.school.com.medical_system.responses.ErrorResponse;
import it.school.com.medical_system.exception.InexistentResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.MessagingException;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

@ControllerAdvice
public class MedicalSystemGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotEditableException.class)
    public  ResponseEntity<ErrorResponse> handleNotEditableException(NotEditableException e){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ErrorResponse> handleMessagingException(MessagingException e){
        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(InexistentResourceException.class)
    public ResponseEntity<ErrorResponse> handleInexistentResourceException(InexistentResourceException ex){

        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(AlreadyExistsException ex){

        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex){
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleConstrainViolation(ConstraintViolationException e) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
