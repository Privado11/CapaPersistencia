package edu.unimagdalena.ejemplo.dto.sugerencia;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import java.time.LocalDateTime;

public record SugerenciaToSaveDto(Long id, String descripcion, LocalDateTime createAt, Usuario usuario) {

}
