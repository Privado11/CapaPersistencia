package edu.unimagdalena.ejemplo.service;


import edu.unimagdalena.ejemplo.dto.mensaje.MensajeDto;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeToSaveDto;

public interface MensajeService {
    MensajeDto guardarMensaje(MensajeToSaveDto mensajeToSaveDto);
}
