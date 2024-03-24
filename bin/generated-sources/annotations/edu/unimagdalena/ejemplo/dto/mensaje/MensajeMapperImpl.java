package edu.unimagdalena.ejemplo.dto.mensaje;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-24T12:08:37-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class MensajeMapperImpl implements MensajeMapper {

    @Override
    public Mensaje toEntity(MensajeDto mensajeDto) {
        if ( mensajeDto == null ) {
            return null;
        }

        Mensaje.MensajeBuilder mensaje = Mensaje.builder();

        mensaje.contenido( mensajeDto.contenido() );
        mensaje.createAt( mensajeDto.createAt() );
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
        LocalDateTime createAt = null;

        id = mensaje.getId();
        destinatario = mensaje.getDestinatario();
        contenido = mensaje.getContenido();
        createAt = mensaje.getCreateAt();

        MensajeDto mensajeDto = new MensajeDto( id, destinatario, contenido, createAt );

        return mensajeDto;
    }

    @Override
    public Mensaje mensajeToSaveDtoToEntity(MensajeToSaveDto mensajeDto) {
        if ( mensajeDto == null ) {
            return null;
        }

        Mensaje.MensajeBuilder mensaje = Mensaje.builder();

        mensaje.contenido( mensajeDto.contenido() );
        mensaje.createAt( mensajeDto.createAt() );
        mensaje.destinatario( mensajeDto.destinatario() );
        mensaje.id( mensajeDto.id() );
        mensaje.usuario( mensajeDto.usuario() );

        return mensaje.build();
    }
}
