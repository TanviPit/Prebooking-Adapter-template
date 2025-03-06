package com.fastays.adapter_hotel_prebooking.handler;

import com.fastays.adapter_hotel_prebooking.exceptionMessage.ResourceNotFoundErrorMessage;
import com.fastays.adapter_hotel_prebooking.exceptionMessage.SessionExpiredErrorMessage;
import com.fastays.adapter_hotel_prebooking.exceptions.ResourceNotFoundException;
import com.fastays.adapter_hotel_prebooking.exceptions.SessionExpiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllUncaughtException(Exception e) {
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundErrorMessage> handleResourceNotFound(Exception e) {
        ResourceNotFoundErrorMessage apiError = new ResourceNotFoundErrorMessage();

        apiError.setMessage(e.getMessage());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setStatus(400);

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SessionExpiredException.class)
    public ResponseEntity<SessionExpiredErrorMessage> handleSessionExpired(SessionExpiredException e) {
        SessionExpiredErrorMessage errorMessage = new SessionExpiredErrorMessage();
        errorMessage.setMessage(e.getMessage());
        errorMessage.setTimestamp(LocalDateTime.now());
        errorMessage.setStatus(401);
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

}






