package br.com.fiap.msnotification.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record NotificationDTO(
        String title,
        String pacientName,
        String doctorName,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime date,
        String type,
        String clientEmail,
        String clientPhone
) {
}
