package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SugerenciaRepository extends JpaRepository<Sugerencia,Long> {
    List<Sugerencia> findByDescripcionLike(String descripcion);

}
