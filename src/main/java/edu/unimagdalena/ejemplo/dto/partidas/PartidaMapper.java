package edu.unimagdalena.ejemplo.dto.partidas;

import edu.unimagdalena.ejemplo.Entities.Partida;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PartidaMapper {

    PartidaMapper INSTANCE = Mappers.getMapper(PartidaMapper.class);
    Partida toEntity(PartidaDto partidaDto);

    PartidaDto toDto(Partida partida);

    Partida PartidaToSaveDtoToEntity(PartidaToSaveDto partidaToSaveDto);
}
