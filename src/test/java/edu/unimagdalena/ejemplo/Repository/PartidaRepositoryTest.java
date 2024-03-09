package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Partida;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PartidaRepositoryTest extends AbstractIntegrationDBTest {
    PartidaRepository partidaRepository;

    @Autowired
    public PartidaRepositoryTest(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    void initMockPartida(){
        Partida partida = Partida.builder()
                .creador("Andres")
                .deporte("Lucha Libre")
                .build();
        partidaRepository.save(partida);

        Partida partida2 = Partida.builder()
                .creador("Walter")
                .deporte("Futbol")
                .build();
        partidaRepository.save(partida2);
        partidaRepository.save(partida2);
        partidaRepository.flush();
    }

    @BeforeEach
    void setUp() {
        partidaRepository.deleteAll();
    }

    @Test
    void givenAnPartida_whenSave_thenPartidawithId(){
        //given
        Partida partida = Partida.builder()
                .creador("Andres")
                .deporte("Lucha Libre")
                .usuarios(createUserList())
                .build();

        //when
        Partida partidaSaved = partidaRepository.save(partida);

        //then
        assertThat(partidaSaved.getId()).isNotNull();

    }

    @Test
    void getAllPartidas(){
        Partida partida1 = Partida.builder()
                .creador("Andres")
                .deporte("Lucha")
                .ciudad("Santa Marta")
                .comentarios("Primera competencia")
                .usuarios(createUserList())
                .build();
        partidaRepository.save(partida1);
        Partida partida2 = Partida.builder()
                .creador("Walter")
                .deporte("Futbol")
                .ciudad("Santa Marta")
                .comentarios("Primer partido")
                .usuarios(createUserList())
                .build();
        partidaRepository.save(partida2);
        partidaRepository.flush();

        List<Partida> partidas = partidaRepository.findAll();

        assertThat(partidas).hasSize(2);
    }

    @Test
    void givenpartidas_whenBuscarPorDeporte_thenObtienesUnaListaDePartidas(){
        Partida partida1 = Partida.builder()
                .creador("Andres")
                .deporte("Lucha")
                .ciudad("Santa Marta")
                .comentarios("Primera competencia")
                .usuarios(createUserList())
                .build();
        partidaRepository.save(partida1);
        Partida partida2 = Partida.builder()
                .creador("Walter")
                .deporte("Futbol")
                .ciudad("Santa Marta")
                .comentarios("Primer partido")
                .usuarios(createUserList())
                .build();
        partidaRepository.save(partida2);

        List<Partida> partidas = partidaRepository.buscarPorDeporte("Futbol");

        assertThat(partidas).isNotEmpty();
        assertThat(partidas).first().hasFieldOrPropertyWithValue("deporte","Futbol");
    }
}