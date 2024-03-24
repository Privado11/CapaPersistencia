package edu.unimagdalena.ejemplo.service.mensaje;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.Repository.MensajeRepository;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeDto;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeToSaveDto;
import edu.unimagdalena.ejemplo.dto.mensaje.Mensajemapper;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

@ExtendWith(MockitoExtension.class)
public class MensajeServiceImplTest {

    @Mock
    private MensajeRepository mensajeRepository;

    @Mock
    private Mensajemapper mensajemapper;

    @InjectMocks
    MensajeServiceImpl mensajeService;

    Mensaje mensaje, mensaje2;
    MensajeDto mensajeDto;

    @BeforeEach
    void setUp() {
        mensaje =  mensaje.builder()
                .id(1l)
                .contenido("Mensaje de prueba.")
                .destinatario("Walter Jiménez")
                .createAt(LocalDateTime.now())
                .build();
        
        mensaje2 =  mensaje.builder()
                .id(2l)
                .contenido("Mensaje de prueba2.")
                .destinatario("Walter Jiménez2")
                .createAt(LocalDateTime.now())
                .build();

        mensajeDto = new MensajeDto(3l, 
                "Walter", 
                "Prueba", 
                LocalDateTime.now());
    }

    @Test
    void testBuscarMensajePorId() throws UsuarioNotFoundException {
        Long idMensaje = 1l;

        given(mensajeRepository.findById(idMensaje)).willReturn(Optional.of(mensaje));

        given(mensajemapper.toDto(any())).willReturn(mensajeDto);

        MensajeDto mensajeDto = mensajeService.buscarMensajePorId(idMensaje);

        assertThat(mensajeDto).isNotNull();
        assertThat(mensajeDto.destinatario()).isEqualTo("Walter");

    }

    @Test
    void testGetAllMensajes() {
        List<Mensaje> mensajes = List.of(mensaje, mensaje2);
        given(mensajeRepository.findAll()).willReturn(mensajes);

        List<MensajeDto> mensajeDtos = mensajeService.getAllMensajes();

        assertThat(mensajeDtos).hasSize(2);
    }

    @Test
    void testGuardarMensaje() {
        given(mensajeRepository.save(any())).willReturn(mensaje);

        MensajeToSaveDto mensajeToSaveDto = new MensajeToSaveDto(null, 
                                                                "Walter Jiménez", 
                                                                "Mensaje de Prueba", 
                                                                LocalDateTime.now(), 
                                                                null);


        given(mensajemapper.toDto(any())).willReturn(mensajeDto);

        MensajeDto mensajeAGuardar = mensajeService.guardarMensaje(mensajeToSaveDto);

        assertThat(mensajeAGuardar).isNotNull();
        assertThat(mensajeAGuardar.destinatario()).isEqualTo("Walter");
        

    }
}
