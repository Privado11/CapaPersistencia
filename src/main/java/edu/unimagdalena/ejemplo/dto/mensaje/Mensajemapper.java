package edu.unimagdalena.ejemplo.dto.mensaje;

import org.mapstruct.Mapper;

import edu.unimagdalena.ejemplo.Entities.Mensaje;

@Mapper
public interface Mensajemapper {
    
    Mensaje toEntity(MensajeDto mensajeDto);
    MensajeDto toDto(Mensaje mensaje);
    Mensaje mensajeToSaveDtoToEntity(MensajeToSaveDto mensajeDto);
}
