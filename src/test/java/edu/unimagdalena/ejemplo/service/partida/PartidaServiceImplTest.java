package edu.unimagdalena.ejemplo.service.partida;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.unimagdalena.ejemplo.Entities.Partida;
import edu.unimagdalena.ejemplo.Repository.PartidaRepository;
import edu.unimagdalena.ejemplo.dto.partidas.PartidaDto;
import edu.unimagdalena.ejemplo.dto.partidas.PartidaMapper;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

@ExtendWith(MockitoExtension.class)
public class PartidaServiceImplTest {

    @Mock
    private PartidaRepository partidaRepository;

    @Mock
    private PartidaMapper partidaMapper;

    @InjectMocks
    private PartidaServiceImpl partidaService;

    Partida partida, partida2, partida3;
    PartidaDto partidaDto, partidaDto2, partidaDto3;

     @BeforeEach
    void setUp() {
        partida = Partida.builder()
        .id(1l)
        .creador("Walter")
        .ciudad("Santa Marta")
        .comentarios("Semifinal")
        .deporte("Fútbol")
        .fecha(LocalDateTime.now())
        .build();

        partida2 = Partida.builder()
        .id(2l)
        .creador("Andrés")
        .ciudad("Santa Marta")
        .comentarios("Semifinal")
        .deporte("Fútbol")
        .fecha(LocalDateTime.now())
        .build();

        partida3 = Partida.builder()
        .id(3l)
        .creador("Walter")
        .ciudad("Barranquilla")
        .comentarios("Final")
        .deporte("Fútbol")
        .fecha(LocalDateTime.of(2024, 4, 25, 4, 0, 0))
        .build();

        partidaDto = PartidaMapper.INSTANCE.toDto(partida);
        partidaDto2 = PartidaMapper.INSTANCE.toDto(partida2);
        partidaDto3 = PartidaMapper.INSTANCE.toDto(partida3);
        
    }

    @Test
    void testBuscarPartidasPorCiudad() {
        String ciudad = "Santa Marta";
        List<Partida> partidas = List.of(partida, partida2, partida3);

        when(partidaRepository.findByCiudadLike(ciudad)).thenReturn(partidas
                                                                    .stream()
                                                                    .filter(partida -> 
                                                                    partida.getCiudad().equals(ciudad))
                                                                    .toList());

        when(partidaMapper.toDto(any())).thenReturn(partidaDto, partidaDto2);                                     
        List<PartidaDto> partidasDto = partidaService.buscarPartidasPorCiudad(ciudad);

        assertThat(partidasDto).hasSize(2);

        assertThat(partidasDto.get(0).creador()).isEqualTo("Walter");
    }

    @Test
    void testBuscarPartidasPorFecha() {
        LocalDateTime fecha = LocalDateTime.now();
        List<Partida> partidas = List.of(partida, partida2, partida3);

        when(partidaRepository.findByFecha(fecha)).thenReturn(partidas
                                                                    .stream()
                                                                    .filter(partida -> 
                                                                    partida.getFecha().isBefore(fecha))
                                                                    .toList());

        when(partidaMapper.toDto(any())).thenReturn(partidaDto, partidaDto2);                                     
        List<PartidaDto> partidasDto = partidaService.buscarPartidasPorFecha(fecha);

        assertThat(partidasDto).hasSize(2);

        assertThat(partidasDto.get(0).creador()).isEqualTo("Walter");
    }

    @Test
    void testBuscarPoId() throws UsuarioNotFoundException {
        Long id = 1l;
        when(partidaRepository.findById(any())).thenReturn(Optional.of(partida));

        when(partidaMapper.toDto(any())).thenReturn(partidaDto);

        PartidaDto partidaDto3 = partidaService.buscarPoId(id);

        assertThat(partidaDto3.id()).isEqualTo(1l);
        

    }

    @Test
    void testGetAllPartidas() {
        List<Partida> partidas = List.of(partida, partida2, partida3);

        when(partidaRepository.findAll()).thenReturn(partidas);

                                      
        List<PartidaDto> partidasDto = partidaService.getAllPartidas();

        assertThat(partidasDto).hasSize(3);

    }

    @Test
    void testGuardarPartida() {

    }
}
