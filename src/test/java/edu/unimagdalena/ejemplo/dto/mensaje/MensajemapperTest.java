package edu.unimagdalena.ejemplo.dto.mensaje;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.unimagdalena.ejemplo.Entities.Mensaje;

public class MensajemapperTest {

    private Mensaje mensaje = Mensaje.builder()
    .destinatario("Walter")
    .contenido("Mensaje de prueba.")
    .createAt(LocalDateTime.now())
    .build();

    MensajeDto mensajeDto = MensajeMapper.INSTANCE.toDto(mensaje);

    @Test
    void testMensajeToSaveDtoToEntity() {

    }

    @Test
    void testToDto() {
        assertThat(mensajeDto).isNotNull();
        assertThat(mensajeDto.destinatario()).isEqualTo("Walter");
    }

    @Test
    void testToEntity() {
        mensaje.setDestinatario("Walter2");
        MensajeDto mensajeDto = MensajeMapper.INSTANCE.toDto(mensaje);
        Mensaje mensaje2 = MensajeMapper.INSTANCE.toEntity(mensajeDto); 

        assertThat(mensaje2).isNotNull();
        assertThat(mensaje2.getDestinatario()).isEqualTo("Walter2");
    }
}
