package edu.unimagdalena.ejemplo.dto.mensaje;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-15T18:21:14-0500",
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

        id = mensaje.getId();
        destinatario = mensaje.getDestinatario();
        contenido = mensaje.getContenido();

        MensajeDto mensajeDto = new MensajeDto( id, destinatario, contenido );

        return mensajeDto;
    }
}
