package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

}
