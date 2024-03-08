package Repository;

import Repository.AbstractIntegrationDBTest;
import Repository.UsuarioRepository;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRepositoryTest extends AbstractIntegrationDBTest {
     UsuarioRepository  usuarioRepository;

    public UsuarioRepositoryTest(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Test
    void musuarioNuevo(){
        Usuario usuario = usuarioRepository.build()
                .nombre("Jimenes")
                .build();
        usuarioRepository.save(usuario);
    }
}