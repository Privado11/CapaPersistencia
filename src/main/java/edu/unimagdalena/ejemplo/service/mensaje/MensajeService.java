package edu.unimagdalena.ejemplo.service.mensaje;

import java.util.List;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeDto;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

public interface MensajeService {
    MensajeDto guardarMensaje(MensajeToSaveDto mensajeToSaveDto);
    List<MensajeDto> getAllMensajes();
    List<MensajeDto> buscarMensajesPorUsuario(Usuario usuario);
    MensajeDto buscarMensajePorId(Long id) throws UsuarioNotFoundException;
}
