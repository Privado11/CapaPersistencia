package edu.unimagdalena.ejemplo.dto.mensaje;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-13T20:32:36-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class MensajemapperImpl implements Mensajemapper {

    @Override
    public Mensaje toEntity(MensajeDto mensajeDto) {
        if ( mensajeDto == null ) {
            return null;
        }

        Mensaje.MensajeBuilder mensaje = Mensaje.builder();

        mensaje.contenido( mensajeDto.contenido() );
        mensaje.destinatario( mensajeDto.destinatario() );
        mensaje.id( mensajeDto.id() );

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
