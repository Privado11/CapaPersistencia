package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class UsuarioRepositoryTest extends AbstractIntegrationDBTest {
    UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
        this.usuarioRepository = usuarioRepository;
    }

    void initMockUsuarios(){
        Usuario usuario = Usuario.builder()
                .nombre("Andrés")
                .apellido("Licona")
                .username("licona")
                .password("123")
                .build();
        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder()
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("123")
                .build();
        usuarioRepository.save(usuario2);
        usuarioRepository.flush();
    }

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();

    }
    @Test
    void givenAnUser_whenSave_thenUserwithId(){
        //given
        Usuario usuario = Usuario.builder()
                .nombre("Andrés")
                .apellido("Licona")
                .username("licona")
                .password("123")
                .build();
        //when
        Usuario userSaved = usuarioRepository.save(usuario);
        //then
        assertThat(userSaved.getId()).isNotNull();

    }
    @Test
    @DisplayName("dado un conjunto de usuarios al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers(){
        //GIVEN
        Usuario usuario = Usuario.builder()
                .nombre("Andrés")
                .apellido("Licona")
                .username("licona")
                .password("123")
                .build();
        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder()
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("123")
                .build();
        usuarioRepository.save(usuario2);
        usuarioRepository.flush();
        //WHEN
        List<Usuario> usuarios = usuarioRepository.findAll();

        //THEN
        assertThat(usuarios).hasSize(2);
    }
    @Test
    void givenUsuarios_whenBuscarPorNombreyApellido_thenObtienesUnaListaDeUsuarios(){
        Usuario usuario = Usuario.builder()
                .nombre("Andrés")
                .apellido("Licona")
                .username("licona")
                .password("123")
                .build();
        usuarioRepository.save(usuario);
        Usuario usuario2 = Usuario.builder()
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("123")
                .build();
        usuarioRepository.save(usuario2);

        List<Usuario> usuarios = usuarioRepository.findByNombreAndApellido("Andrés", "Licona");

        assertThat(usuarios).isNotEmpty();
        assertThat(usuarios).first().hasFieldOrPropertyWithValue("nombre","Andrés");
    }
    @Test
    void givenUsuario_whenActualizarUsuario_thenObtenerUsuarioActualizado(){
        //GIVEN
        Usuario usuario = Usuario.builder()
                .nombre("Walter")
                .apellido("Jimenez")
                .username("privado")
                .password("privado11")
                .build();
        

        //WHEN
        Usuario usuarioParaActualizar = usuarioRepository.save(usuario);
        usuarioParaActualizar.setApellido("Jiménez");
        

        //THEN
        Usuario usuarioActualizado = usuarioRepository.save(usuarioParaActualizar);;
        assertThat(usuarioActualizado.getApellido()).isEqualTo("Jiménez");
    }

    @Test
    void buscarPorId(){
        Usuario usuario = Usuario.builder()
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("123")
                .build();
        usuarioRepository.save(usuario);

        Usuario usuario2 = Usuario.builder()
                .nombre("Walter2")
                .apellido("Jiménez")
                .username("privado2")
                .password("123")
                .build();
        usuarioRepository.save(usuario2);

        Usuario usuarioEncontrado = usuarioRepository.findById(1l).orElse(null);
        assertThat(usuarioEncontrado).isNotNull();
        assertThat(usuarioEncontrado.getNombre()).isEqualTo("Walter");
    }
}