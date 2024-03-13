package edu.unimagdalena.ejemplo.dto.usuario;

import edu.unimagdalena.ejemplo.dto.mensaje.MensajeDto;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaDto;

import java.util.Collections;
import java.util.List;

public class UsuarioToSaveDto {
    Long id;
    String nombre;
    String apellido;
    String username;
    String email;
    List<SugerenciaDto> sugerencias;
    List<MensajeDto> mensajes;

    public List<SugerenciaDto> getSugerencias() {
        return Collections.unmodifiableList(sugerencias);
    }
    public List<MensajeDto> getMensaje() {
        return Collections.unmodifiableList(mensajes);
    }
}
