package edu.unimagdalena.ejemplo.service.usuario;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.Repository.UsuarioRepository;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioMapper;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;
    
    Usuario usuario, usuario2;
    UsuarioDto usuarioDto;

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
        
        usuario2 =  Usuario.builder()
                .id(2l)
                .nombre("Walter2")
                .apellido("Jiménez2")
                .username("privado2")
                .password("123")
                .email("privado2@privado.com")
                .build();

        usuarioDto = new UsuarioDto(3l, 
        "Walter3", 
        "Jiménez3", 
        "privado3", 
        "privado3@privado3", 
        Collections.emptyList(), 
        Collections.emptyList(), 
        Collections.emptyList());

        
    }
    @Test
    void testActualizarUsuario() throws UsuarioNotFoundException {
        given(usuarioRepository.findById(any())).willReturn(Optional.of(usuario));

        UsuarioToSaveDto usuarioAEditar = new UsuarioToSaveDto(null,
                "Walter",
                "Jiménez",
                "privado",
                "123",
                "privado@privado.com");

        usuario.setEmail("editado@privado.com");
        given(usuarioRepository.save(any())).willReturn(usuario);

        given(usuarioMapper.toDto(any())).willReturn(usuarioDto);
        UsuarioDto usuarioDtoo = usuarioService.actualizarUsuario(1l, usuarioAEditar);

        assertThat(usuarioDtoo).isNotNull();

        

    }

    @Test
    void testBuscarUsuarioPorEmail() throws UsuarioNotFoundException {
        
        String emailUsuario = "privado@privado.com";

        given(usuarioRepository.findByEmail(emailUsuario))
                .willReturn(usuario);

        given(usuarioMapper.toDto(any())).willReturn(usuarioDto);
        UsuarioDto usuarioDto = usuarioService.buscarUsuarioPorEmail(emailUsuario);

        assertThat(usuarioDto).isNotNull();
    }

    @Test
    void testBuscarUsuarioPorId() throws UsuarioNotFoundException {
        Long idUsuario = 1l;

        given(usuarioRepository.findById(idUsuario))
                .willReturn(Optional.of(usuario));

        given(usuarioMapper.toDto(any())).willReturn(usuarioDto);

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

        given(usuarioMapper.toDto(any())).willReturn(usuarioDto);

        //WHEN
        UsuarioDto usuarioDto = usuarioService.guardarUsuario(usuarioAGuardar);
        //THEN
        assertThat(usuarioDto).isNotNull();
       assertThat(usuarioDto.id()).isEqualTo(3l);

    }

    @Test
    void testRemoverUsuario() {
        Long idUsuario = 1l;
        given(usuarioRepository.findById(any())).willReturn(Optional.of(usuario));

        

        usuarioService.removerUsuario(idUsuario);

        verify(usuarioRepository, times(1)).delete(any());
    }

    @Test
    void getAllUsuarios(){
        List<Usuario> usuarios = List.of(usuario, usuario2);

        given(usuarioRepository.findAll()).willReturn(usuarios);

        List<UsuarioDto> usuarioDtos = usuarioService.getAllUser();

        assertThat(usuarioDtos).hasSize(2);
    }
}
