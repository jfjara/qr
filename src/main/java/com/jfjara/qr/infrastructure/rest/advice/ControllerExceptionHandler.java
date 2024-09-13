package com.jfjara.qr.infrastructure.rest.advice;

import com.jfjara.qr.domain.model.exception.GenerateQRException;
import com.jfjara.qr.infrastructure.rest.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(GenerateQRException.class)
    public ResponseEntity<ErrorDTO> generateQRExceptionHandle(final GenerateQRException exception,
                                                           final WebRequest webRequest) {
        return new ResponseEntity(ErrorDTO.builder().code(580).message(exception.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
