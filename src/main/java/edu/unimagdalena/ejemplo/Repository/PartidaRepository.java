package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PartidaRepository extends JpaRepository<Partida,Long> {
    List<Partida> findByCiudadLike(String ciudad);
    Optional<Partida> findById(Long id);
    List<Partida> findByFecha(LocalDateTime fecha);
    List<Partida> findByDeporteLike(String deporte);
}
