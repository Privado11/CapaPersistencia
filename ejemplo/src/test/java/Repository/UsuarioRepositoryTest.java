package Repository;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;



class UsuarioRepositoryTest extends AbstractIntegrationDBTest{

    UsuarioRepository usuarioRepository;

    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void givenAnUser_whenSave_thenUserWithId(){
        //given
        Usuario usuario = Usuario.builder()
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("Privado11")
                .build();

    }
}