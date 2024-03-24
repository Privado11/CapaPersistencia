package edu.unimagdalena.ejemplo.service.sugerencia;

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

import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import edu.unimagdalena.ejemplo.Repository.SugerenciaRepository;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaDto;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaMapper;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

@ExtendWith(MockitoExtension.class)
public class SugerenciaServiceImplTest {

    @Mock
    private SugerenciaRepository sugerenciaRepository;
    @Mock
    private SugerenciaMapper sugerenciaMapper;

    @InjectMocks
    private SugerenciaServiceImpl sugerenciaService;

    Sugerencia sugerencia, sugerencia2;
    SugerenciaDto sugerenciaDto;

    @BeforeEach
    void setUp() {
        sugerencia = Sugerencia.builder()
        .id(1l)
        .descripcion("Prueba")
        .createdAt(LocalDateTime.now())
        .build();

        sugerencia2 = Sugerencia.builder()
        .id(2l)
        .descripcion("Prueba2")
        .createdAt(LocalDateTime.now())
        .build();

        sugerenciaDto = SugerenciaMapper.INSTANCE.toDto(sugerencia);

    }


    @Test
    void testBuscarSugerenciaPorId() throws UsuarioNotFoundException {
        Long id = 1l;
        when(sugerenciaRepository.findById(any())).thenReturn(Optional.of(sugerencia));

        when(sugerenciaMapper.toDto(any())).thenReturn(sugerenciaDto);

        SugerenciaDto sugerenciaEncontrada = sugerenciaService.buscarSugerenciaPorId(id);

        assertThat(sugerenciaEncontrada.id()).isEqualTo(1l);

    }

    @Test
    void testGetAllSugerencias() {
        List<Sugerencia> sugerencias = List.of(sugerencia, sugerencia2);

        when(sugerenciaRepository.findAll()).thenReturn(sugerencias);

        List<SugerenciaDto> sugerenciaDtos = sugerenciaService.getAllSugerencias();

        assertThat(sugerenciaDtos).hasSize(2);

    }

    @Test
    void testGuardarSugerencia() {

    }
}
