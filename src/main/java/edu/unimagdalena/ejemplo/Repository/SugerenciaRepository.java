package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import edu.unimagdalena.ejemplo.Entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SugerenciaRepository extends JpaRepository<Sugerencia,Long> {
    List<Sugerencia> findByDescripcionLike(String descripcion);
    Optional<Sugerencia> findById(Long id);
    List<Sugerencia> findByUsuario(Usuario usuario);
}
