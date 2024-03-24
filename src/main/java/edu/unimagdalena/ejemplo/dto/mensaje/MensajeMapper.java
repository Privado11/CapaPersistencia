package edu.unimagdalena.ejemplo.dto.mensaje;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.ejemplo.Entities.Mensaje;

@Mapper(componentModel = "spring")
public interface MensajeMapper {

    MensajeMapper INSTANCE = Mappers.getMapper(MensajeMapper.class);
    
    Mensaje toEntity(MensajeDto mensajeDto);
    MensajeDto toDto(Mensaje mensaje);
    Mensaje mensajeToSaveDtoToEntity(MensajeToSaveDto mensajeDto);
}
