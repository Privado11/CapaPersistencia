package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SugerenciaRepositoryTest extends AbstractIntegrationDBTest {
    SugerenciaRepository sugerenciaRepository;

    @Autowired
    public SugerenciaRepositoryTest(SugerenciaRepository sugerenciaRepository, UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
        this.sugerenciaRepository = sugerenciaRepository;
    }

    void initMockSugerencia(){
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("Sugerencia de prueba.")
                .build();
        sugerenciaRepository.save(sugerencia);

        Sugerencia sugerencia2 = Sugerencia.builder()
                .descripcion("Sugerencia de prueba 2.")
                .build();
        sugerenciaRepository.save(sugerencia2);
        sugerenciaRepository.flush();
    }

    @BeforeEach
    void setUp() {
        sugerenciaRepository.deleteAll();
    }

    @Test
    void givenAnSugerencia_whenSave_thenSugerenciawithId(){
        //given
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("Sugerencia de prueba.")
                    .usuario(createUser())
                    .build();
        //when
        Sugerencia sugerenciaSaved = sugerenciaRepository.save(sugerencia);

        //then
        assertThat(sugerenciaSaved.getId()).isNotNull();
    }

    @Test
    @DisplayName("dado un conjunto de sugerencias al buscarlo todos obtenemos la lista de las sugerencias en la base de datos")
    void getAllSugerencia(){
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("Sugerencia de prueba.")
                .usuario(createUser())
                .build();
        //when
        sugerenciaRepository.save(sugerencia);

        Sugerencia sugerencia2 = Sugerencia.builder()
                .descripcion("Sugerencia de prueba 2.")
                .usuario(createUser())
                .build();
        //when
        sugerenciaRepository.save(sugerencia2);
        sugerenciaRepository.flush();

        List<Sugerencia> sugerencias = sugerenciaRepository.findAll();

        assertThat(sugerencias).hasSize(2);
    }
    @Test
    void givenSugerencia_whenBuscarDescripcion_thenObtienesUnaListaDeSugerencias(){
        Sugerencia sugerencia = Sugerencia.builder()
                .descripcion("Sugerencia de prueba.")
                .usuario(createUser())
                .build();
        //when
        sugerenciaRepository.save(sugerencia);

        Sugerencia sugerencia2 = Sugerencia.builder()
                .descripcion("Sugerencia de prueba 2.")
                .usuario(createUser())
                .build();
        //When
        sugerenciaRepository.save(sugerencia2);

        List<Sugerencia> sugerencias = sugerenciaRepository.findByDescripcionLike("Sugerencia de prueba.");

        assertThat(sugerencias).isNotEmpty();
        assertThat(sugerencias).first().hasFieldOrPropertyWithValue("descripcion","Sugerencia de prueba.");
    }
}