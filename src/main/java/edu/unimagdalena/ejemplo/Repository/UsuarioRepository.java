package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface    UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario>  findByNombreAndApellido(String nombre, String apellido);
    List<Usuario> findByUsernameOrEmail(String username, String email);

    @Query("select u from Usuario u where u.nombre = ?1 and u.apellido = ?2")
    List<Usuario> buscarPorNombreYApellido(String nombre, String apellido);

    List<Usuario> findByNombreLike(String nombre);

    Usuario findByUsername(String username);

    Optional<Usuario> findById(Long id);

    Usuario findByEmail(String email);

}
