package Repository;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class MensajeRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    MensajeRepository mensajeRepository;

    public MensajeRepositoryTest(MensajeRepository mensajeRepository){
        this.mensajeRepository = mensajeRepository;
    }

    @Test
    void mensajeNuevo(){
        Mensaje mensaje_Nuevo = Mensaje.builder()
                .creador("compa")
                .contenido("hola mucho gusto")
                .build();
        mensajeRepository.save(mensaje_Nuevo);
    }
}