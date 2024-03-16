package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida,Long> {
    @Query("select u from Partida u where u.deporte = ?1")
    List<Partida> buscarPorDeporte(String deporte);
}
