package com.jfjara.qr.infrastructure.rest.controller;

import com.jfjara.qr.domain.port.usecase.GenerateQR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

    @Autowired
    private GenerateQR generateCustomerQR;

    @GetMapping(path = "v1/qr", produces = "image/png")
    public ResponseEntity<byte[]> generateQR() {
        return ResponseEntity.status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_DISPOSITION, "filename=\"qr.png\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(generateCustomerQR.execute());
    }

}
