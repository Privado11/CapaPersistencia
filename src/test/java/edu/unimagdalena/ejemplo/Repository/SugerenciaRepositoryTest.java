package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Partida;
import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SugerenciaRepositoryTest extends AbstractIntegrationDBTest {
    SugerenciaRepository sugerenciaRepository;

    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository) {
        this.sugerenciaRepository = sugerenciaRepository;
    }

    @BeforeEach
    void setUp() {
        sugerenciaRepository.deleteAll();
    }

    @Test
    void givenAnSugerencia_whenSave_thenSugerenciawithId(){
        //given
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("nueva sugerencia")
                    .usuario(createUser("Andres","Licona",20))
                    .build();
        //when
        Sugerencia sugerenciaSaved = sugerenciaRepository.save(sugerencia);

        //then
        assertThat(sugerenciaSaved.getId()).isNotNull();
    }

    @Test
    void getAllSugerencia(){
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("nueva sugerencia")
                .usuario(createUser("Andres","Licona",20))
                .build();
        //when
        sugerenciaRepository.save(sugerencia);
        Sugerencia sugerencia2 = Sugerencia.builder()
                .descripcion("nueva sugerencia")
                .usuario(createUser("Walter","Jimenez",20))
                .build();
        //when
        sugerenciaRepository.save(sugerencia);;
        sugerenciaRepository.flush();

        List<Sugerencia> sugerencias = sugerenciaRepository.findAll();

        assertThat(sugerencias).hasSize(2);
    }
}