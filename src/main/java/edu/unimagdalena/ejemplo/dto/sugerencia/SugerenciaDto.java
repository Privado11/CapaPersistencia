package edu.unimagdalena.ejemplo.dto.sugerencia;

import java.time.LocalDateTime;


public record SugerenciaDto(Long id, String descripcion, LocalDateTime createAt) {
}
