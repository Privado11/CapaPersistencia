package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SugerenciaRepository extends JpaRepository<Sugerencia,Long> {
}