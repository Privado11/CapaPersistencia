package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida,Long> {
}
