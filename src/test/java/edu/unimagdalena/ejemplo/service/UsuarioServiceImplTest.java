package edu.unimagdalena.ejemplo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.willDoNothing;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.Repository.UsuarioRepository;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioMapper;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;
    Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario =  Usuario.builder()
                .id(1l)
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("123")
                .email("privado@privado.com")
                .build();
    }
    @Test
    void testActualizarUsuario() {
        

    }

    @Test
    void testBuscarUsuarioPorEmail() {

    }

    @Test
    void testBuscarUsuarioPorId() throws UsuarioNotFoundException {
        Long idUsuario = 1l;

        given(usuarioRepository.findById(idUsuario))
                .willReturn(Optional.of(usuario));

        UsuarioDto usuarioDto = usuarioService.buscarUsuarioPorId(idUsuario);

        assertThat(usuarioDto).isNotNull();

    }

    @Test
    void testUsuarioNoEncontradoPorId(){
        given(usuarioRepository.findById(any())).willReturn(Optional.ofNullable(null));

        assertThrows(UsuarioNotFoundException.class,()->{
            usuarioService.buscarUsuarioPorId(any());
        },"Usuario no encontrado");

    }

    @Test
    void testGuardarUsuario() {
        given(usuarioRepository.save(any())).willReturn(usuario);
        
        UsuarioToSaveDto usuarioAGuardar = new UsuarioToSaveDto(null,
                "Walter",
                "Jiménez",
                "privado",
                "123",
                "privado@privado.com");
        //WHEN
        UsuarioDto usuarioDto = usuarioService.guardarUsuario(usuarioAGuardar);
        //THEN
        assertThat(usuarioDto).isNotNull();
       // assertThat(usuarioDto.id()).isEqualTo(1l);

    }

    @Test
    void testRemoverUsuario() {
        Long idUsuario = 1l;
        willDoNothing().given(usuarioRepository).delete(any());
        usuarioService.removerUsuario(idUsuario);

        verify(usuarioRepository, times(1)).delete(any());
    }
}
