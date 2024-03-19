package edu.unimagdalena.ejemplo.dto.mensaje;

import edu.unimagdalena.ejemplo.Entities.Usuario;

public record MensajeDto(
        Long id,
        String destinatario,
        String contenido
) {

}
