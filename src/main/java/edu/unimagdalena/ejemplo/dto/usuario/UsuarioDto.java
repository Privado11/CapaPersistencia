package edu.unimagdalena.ejemplo.dto.usuario;

import java.util.Collections;
import java.util.List;

import edu.unimagdalena.ejemplo.dto.mensaje.MensajeDto;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaDto;

public record UsuarioDto(
    Long id,
    String nombre,
    String apellido,
    String username,
    String email,
    List<SugerenciaDto> sugerencias,
    List<MensajeDto> mensajes
    ) {

        public List<SugerenciaDto> sugerencias(){
            return Collections.unmodifiableList(sugerencias);
        }
        public List<MensajeDto> mensajes(){
            return Collections.unmodifiableList(mensajes);
        }
}
