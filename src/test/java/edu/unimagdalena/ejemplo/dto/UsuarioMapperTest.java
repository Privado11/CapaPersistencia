package edu.unimagdalena.ejemplo.dto;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import edu.unimagdalena.ejemplo.Entities.Partida;
import org.junit.jupiter.api.Test;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioMapper;

public class UsuarioMapperTest {

    Sugerencia sugerencia = Sugerencia.builder()
    .descripcion("Prueba")
    .build();

    List<Sugerencia> sugerencias = List.of(sugerencia);

    Mensaje mensaje = Mensaje.builder()
    .contenido("Prueba")
    .build();

    List<Mensaje> mensajes = List.of(mensaje);

    Partida partida = Partida.builder()
            .creador("Walter")
            .ciudad("Santa Marta")
            .participantes(4)
            .build();

    List<Partida> partidas = List.of(partida);

    Usuario usuario = Usuario.builder()
            .nombre("Walter")
            .apellido("Jiménez")
            .username("privado")
            .email("privado@privado.com")
            .sugerencias(sugerencias)
            .mensajes(mensajes)
            .partidas(partidas)
            .build();

    UsuarioDto usuarioDto = UsuarioMapper.INSTANCE.toDto(usuario);
    
    @Test
    public void usuarioToDto(){
        //given
        Usuario usuario = Usuario.builder()
            .nombre("Walter")
            .apellido("Jiménez")
            .username("privado")
            .email("privado@privado.com")
            .build();

        //When
        UsuarioDto usuarioDto = UsuarioMapper.INSTANCE.toDto(usuario);

        //Then
        assertThat(usuarioDto).isNotNull();
        assertThat(usuarioDto.nombre()).isEqualTo("Walter");
        assertThat(usuarioDto.apellido()).isEqualTo("Jiménez");
        assertThat(usuarioDto.username()).isEqualTo("privado");
        assertThat(usuarioDto.email()).isEqualTo("privado@privado.com");
    }
    @Test
    public void dtoToEntity(){
        //When
        Usuario usuario = UsuarioMapper.INSTANCE.toEntity(usuarioDto);

        //Then
        assertThat(usuario).isNotNull();
        assertThat(usuario.getNombre()).isEqualTo("Walter");
        assertThat(usuario.getApellido()).isEqualTo("Jiménez");
        assertThat(usuario.getUsername()).isEqualTo("privado");
        assertThat(usuario.getEmail()).isEqualTo("privado@privado.com");

    }

}
