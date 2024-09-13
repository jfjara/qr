package com.jfjara.qr.infrastructure.spring.config;

import com.jfjara.qr.application.usecase.GenerateQRUseCase;
import com.jfjara.qr.application.usecase.customer.*;
import com.jfjara.qr.domain.port.repository.QRRepository;
import com.jfjara.qr.domain.port.usecase.GenerateQR;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public GenerateQR generateCustomerQR(final QRRepository qrRepository) {
        return new GenerateQRUseCase(qrRepository);
    }

}
