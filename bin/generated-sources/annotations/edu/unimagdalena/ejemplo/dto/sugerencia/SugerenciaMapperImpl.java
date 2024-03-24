package edu.unimagdalena.ejemplo.dto.sugerencia;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-23T18:54:26-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class SugerenciaMapperImpl implements SugerenciaMapper {

    @Override
    public Sugerencia toEntity(SugerenciaDto sugerenciaDto) {
        if ( sugerenciaDto == null ) {
            return null;
        }

        Sugerencia.SugerenciaBuilder sugerencia = Sugerencia.builder();

        sugerencia.descripcion( sugerenciaDto.descripcion() );
        sugerencia.id( sugerenciaDto.id() );

        return sugerencia.build();
    }

    @Override
    public SugerenciaDto toDto(Sugerencia sugerencia) {
        if ( sugerencia == null ) {
            return null;
        }

        Long id = null;
        String descripcion = null;

        id = sugerencia.getId();
        descripcion = sugerencia.getDescripcion();

        LocalDateTime createAt = null;

        SugerenciaDto sugerenciaDto = new SugerenciaDto( id, descripcion, createAt );

        return sugerenciaDto;
    }
}
