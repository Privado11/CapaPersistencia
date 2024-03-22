package edu.unimagdalena.ejemplo.dto.partidas;

import edu.unimagdalena.ejemplo.Entities.Partida;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T22:44:27-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class PartidaMapperImpl implements PartidaMapper {

    @Override
    public Partida toEntity(PartidaDto partidaDto) {
        if ( partidaDto == null ) {
            return null;
        }

        Partida.PartidaBuilder partida = Partida.builder();

        partida.id( partidaDto.id() );
        partida.creador( partidaDto.creador() );
        partida.deporte( partidaDto.deporte() );
        partida.ciudad( partidaDto.ciudad() );
        partida.provincia( partidaDto.provincia() );
        partida.participantes( partidaDto.participantes() );
        partida.suplentes( partidaDto.suplentes() );
        partida.comentarios( partidaDto.comentarios() );

        return partida.build();
    }

    @Override
    public PartidaDto toDto(Partida partida) {
        if ( partida == null ) {
            return null;
        }

        Long id = null;
        String creador = null;
        String deporte = null;
        String ciudad = null;
        String provincia = null;
        Integer participantes = null;
        Integer suplentes = null;
        String comentarios = null;

        id = partida.getId();
        creador = partida.getCreador();
        deporte = partida.getDeporte();
        ciudad = partida.getCiudad();
        provincia = partida.getProvincia();
        participantes = partida.getParticipantes();
        suplentes = partida.getSuplentes();
        comentarios = partida.getComentarios();

        PartidaDto partidaDto = new PartidaDto( id, creador, deporte, ciudad, provincia, participantes, suplentes, comentarios );

        return partidaDto;
    }
}
