package edu.unimagdalena.ejemplo.dto.mensaje;

import edu.unimagdalena.ejemplo.Entities.Usuario;

public record MensajeToSaveDto(
        Long id,
        String destinatario,
        String contenido,
        Usuario usuario
) {
}
