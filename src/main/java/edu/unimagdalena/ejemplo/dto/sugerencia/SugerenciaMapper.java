package edu.unimagdalena.ejemplo.dto.sugerencia;

import org.mapstruct.Mapper;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;

@Mapper
public interface SugerenciaMapper {

    Sugerencia toEntity(SugerenciaDto sugerenciaDto);
    SugerenciaDto toDto(Sugerencia sugerencia);
} 

