package edu.unimagdalena.ejemplo.dto.sugerencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;

public class SugerenciaMapperTest {
    Sugerencia sugerencia = Sugerencia.builder()
    .descripcion("Cambiar hora")
    .build();

    SugerenciaDto sugerenciaDto = SugerenciaMapper.INSTANCE.toDto(sugerencia);
    @Test
    void testSugerenciaToSaveDtoToEntity() {

    }

    @Test
    void testToDto() {
        assertThat(sugerenciaDto.descripcion()).isEqualTo("Cambiar hora");
    }

    @Test
    void testToEntity() {
        sugerencia.setDescripcion("Prueba");
        sugerenciaDto = SugerenciaMapper.INSTANCE.toDto(sugerencia);
        Sugerencia sugerencia2 = SugerenciaMapper.INSTANCE.toEntity(sugerenciaDto);

        assertThat(sugerencia2.getDescripcion()).isEqualTo("Prueba");


    }
}
