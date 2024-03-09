package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract  class CreateUsuariosTest {

    UsuarioRepository usuarioRepository;

    @Autowired
    public CreateUsuariosTest(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    Usuario createUser() {
        Usuario usuario = Usuario.builder()
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("Privado.")
                .build();
        usuarioRepository.save(usuario);

        return usuario;
    }


    List<Usuario> createUserList(){
        Usuario usuario = Usuario.builder()
                .nombre("Andrés")
                .apellido("Licona")
                .username("licona")
                .password("123")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Walter")
                .apellido("Jiménez")
                .username("privado")
                .password("123")
                .build();

        //WHEN
        List<Usuario> usuarios = List.of(usuario,usuario2);
        return usuarios;
    }

}
