package edu.unimagdalena.ejemplo.dto.partidas;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Collections;
import java.util.List;

import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;

public record PartidaDto(
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
        List<UsuarioDto> usuarios
        ) {

        public List<UsuarioDto> usuarioDtos(){
            return Collections.unmodifiableList(usuarios);
        }

}
