package edu.unimagdalena.ejemplo.dto.mensaje;

import java.time.LocalDateTime;


public record MensajeDto(
        Long id,
        String destinatario,
        String contenido,
        LocalDateTime createAt
) {

}
