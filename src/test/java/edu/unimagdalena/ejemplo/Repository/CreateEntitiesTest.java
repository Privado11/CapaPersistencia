package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Usuario;

import java.util.List;

public abstract  class CreateEntitiesTest {
    Usuario createUser(String nombre, String apellido, Integer edad){
        return Usuario.builder()
                .nombre(nombre).apellido(apellido).edad(edad).build();
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
