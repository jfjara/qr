package com.jfjara.qr.application.usecase;

import com.jfjara.qr.domain.model.exception.GenerateQRException;
import com.jfjara.qr.domain.port.repository.QRRepository;
import com.jfjara.qr.domain.port.usecase.GenerateQR;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class GenerateQRUseCase implements GenerateQR {

    private final QRRepository qrRepository;

    @Override
    public byte[] execute() {
        log.debug(":: Generate QR code for user id {} ::");
        return Optional.of(qrRepository.generate())
                .map(this::writeImageInStream)
                .map(ByteArrayOutputStream::toByteArray)
                .orElseThrow(() -> GenerateQRException.builder()
                        .message("Unknown error creating QR code")
                        .build());
    }

    private ByteArrayOutputStream writeImageInStream(final BufferedImage image) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image , "png", byteArrayOutputStream);
            return byteArrayOutputStream;
        } catch (IOException exception) {
            throw GenerateQRException.builder()
                    .message("Error writing QR image in stream")
                    .error(exception.getMessage())
                    .build();
        }
    }
}
