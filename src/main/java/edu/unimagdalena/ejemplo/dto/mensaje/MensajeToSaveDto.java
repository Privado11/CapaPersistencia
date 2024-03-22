package edu.unimagdalena.ejemplo.dto.mensaje;

import java.time.LocalDateTime;

import edu.unimagdalena.ejemplo.Entities.Usuario;

public record MensajeToSaveDto(
        Long id,
        String destinatario,
        String contenido,
        LocalDateTime createAt,
        Usuario usuario
) {
}
