package edu.unimagdalena.ejemplo.dto.partidas;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.unimagdalena.ejemplo.Entities.Partida;

public class PartidaMapperTest {
    Partida partida = Partida.builder()
    .creador("Walter")
    .ciudad("Santa Marta")
    .comentarios("Partida fianl.")
    .deporte("Fútbol")
    .fecha(LocalDateTime.now())
    .build();

    PartidaDto partidaDto = PartidaMapper.INSTANCE.toDto(partida);


    @Test
    void testPartidaToSaveDtoToEntity() {

    }

    @Test
    void testToDto() {
        assertThat(partidaDto).isNotNull();
        assertThat(partidaDto.creador()).isEqualTo("Walter");

    }

    @Test
    void testToEntity() {
        partida.setCiudad("Pivijay");
        partidaDto = PartidaMapper.INSTANCE.toDto(partida);
        Partida partida2 = PartidaMapper.INSTANCE.toEntity(partidaDto);

        assertThat(partida2.getCiudad()).isEqualTo("Pivijay");

    }
}
