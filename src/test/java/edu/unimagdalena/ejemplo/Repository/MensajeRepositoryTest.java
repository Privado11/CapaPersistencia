package edu.unimagdalena.ejemplo.Repository;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MensajeRepositoryTest extends AbstractIntegrationDBTest{

    MensajeRepository mensajeRepository;

    @Autowired
    public MensajeRepositoryTest(MensajeRepository mensajeRepository, UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
        this.mensajeRepository = mensajeRepository;
    }


    void initMockMensajes(){
        Mensaje mensaje = Mensaje.builder()
                .creador("Walter Jiménez")
                .destinatario("Andrés Licona")
                .contenido("Realizando pruebas...")
                .build();
        mensajeRepository.save(mensaje);

        Mensaje mensaje2 = Mensaje.builder()
                .creador("Walter Jiménez")
                .destinatario("Andrés Licona")
                .contenido("Realizando pruebas 2...")
                .build();
        mensajeRepository.save(mensaje2);
        mensajeRepository.flush();
    }

    @BeforeEach
    void setUp() {
        mensajeRepository.deleteAll();

    }
    @Test
    void givenAnMensaje_whenSave_thenMensajewithId(){
        //given
        Mensaje mensaje = Mensaje.builder()
                .creador("Walter Jiménez")
                .destinatario("Andrés Licona")
                .contenido("Realizando pruebas...")
                .usuario(createUser())
                .build();
        //when
        Mensaje userSaved = mensajeRepository.save(mensaje);
        //then
        assertThat(userSaved.getId()).isNotNull();

    }
    @Test
    @DisplayName("dado un conjunto de ceradores de mens al buscarlo todos obtenemos la lista de los usuarios en la base de datos")
    void shouldGetAllUsers(){
        //GIVEN
        Mensaje mensaje = Mensaje.builder()
                .creador("Walter Jiménez")
                .destinatario("Andrés Licona")
                .contenido("Realizando pruebas...")
                .usuario(createUser())
                .build();
        mensajeRepository.save(mensaje);

        Mensaje mensaje2 = Mensaje.builder()
                .creador("Walter Jiménez")
                .destinatario("Andrés Licona")
                .contenido("Realizando pruebas 2...")
                .usuario(createUser())
                .build();
        mensajeRepository.save(mensaje2);
        mensajeRepository.flush();
        //WHEN
        List<Mensaje> mensajes = mensajeRepository.findAll();

        //THEN
        assertThat(mensajes).hasSize(2);
    }
    @Test
    void givenMensaje_whenBuscarPorCreador_thenObtienesUnaListaDeMensajes(){
        Mensaje mensaje = Mensaje.builder()
                .creador("Walter Jiménez")
                .destinatario("Andrés Licona")
                .contenido("Realizando pruebas...")
                .usuario(createUser())
                .build();
        mensajeRepository.save(mensaje);

        Mensaje mensaje2 = Mensaje.builder()
                .creador("Walter Jiménez")
                .destinatario("Andrés Licona")
                .contenido("Realizando pruebas 2...")
                .usuario(createUser())
                .build();
        mensajeRepository.save(mensaje2);

        List<Mensaje> mensajes = mensajeRepository.findByCreadorLike("Walter Jiménez");

        assertThat(mensajes).isNotEmpty();
        assertThat(mensajes).first().hasFieldOrPropertyWithValue("creador","Walter Jiménez");
    }
}