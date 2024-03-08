package edu.unimagdalena.ejemplo.Repository;

import Repository.UsuarioRepository;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.junit.jupiter.api.Test;

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