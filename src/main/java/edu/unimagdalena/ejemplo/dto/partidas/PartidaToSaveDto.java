package edu.unimagdalena.ejemplo.dto.partidas;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import edu.unimagdalena.ejemplo.Entities.Usuario;


public record PartidaToSaveDto(
    Long id,
    String creador,
    String deporte,
    String ciudad,
    String provincia,
    Integer participantes,
    Integer suplentes,
    String comentarios, 
    LocalDateTime fecha, 
    LocalTime horaComienzo,
    LocalTime horaFinal,
    List<Usuario> usuarios
    ) {

}
