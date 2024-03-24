package edu.unimagdalena.ejemplo.dto.sugerencia;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;

@Mapper(componentModel = "spring")
public interface SugerenciaMapper {

    SugerenciaMapper INSTANCE = Mappers.getMapper(SugerenciaMapper.class);

    Sugerencia toEntity(SugerenciaDto sugerenciaDto);
    SugerenciaDto toDto(Sugerencia sugerencia);
    Sugerencia sugerenciaToSaveDtoToEntity(SugerenciaToSaveDto sugerenciaToSaveDto);
} 

