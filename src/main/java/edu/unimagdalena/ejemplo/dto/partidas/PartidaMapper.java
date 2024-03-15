package edu.unimagdalena.ejemplo.dto.partidas;

import edu.unimagdalena.ejemplo.Entities.Partida;
import org.mapstruct.Mapper;

@Mapper
public interface PartidaMapper {
    Partida toEntity(PartidaDto partidaDto);

    PartidaDto toDto(Partida partida);
}
