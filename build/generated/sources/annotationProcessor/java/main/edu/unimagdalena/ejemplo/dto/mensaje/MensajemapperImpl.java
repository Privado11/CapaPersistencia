package edu.unimagdalena.ejemplo.dto.mensaje;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-22T18:34:50-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class MensajemapperImpl implements Mensajemapper {

    @Override
    public Mensaje toEntity(MensajeDto mensajeDto) {
        if ( mensajeDto == null ) {
            return null;
        }

        Mensaje.MensajeBuilder mensaje = Mensaje.builder();

        mensaje.id( mensajeDto.id() );
        mensaje.destinatario( mensajeDto.destinatario() );
        mensaje.contenido( mensajeDto.contenido() );
        mensaje.createAt( mensajeDto.createAt() );

        return mensaje.build();
    }

    @Override
    public MensajeDto toDto(Mensaje mensaje) {
        if ( mensaje == null ) {
            return null;
        }

        Long id = null;
        String destinatario = null;
        String contenido = null;
        LocalDateTime createAt = null;

        id = mensaje.getId();
        destinatario = mensaje.getDestinatario();
        contenido = mensaje.getContenido();
        createAt = mensaje.getCreateAt();

        MensajeDto mensajeDto = new MensajeDto( id, destinatario, contenido, createAt );

        return mensajeDto;
    }
}
