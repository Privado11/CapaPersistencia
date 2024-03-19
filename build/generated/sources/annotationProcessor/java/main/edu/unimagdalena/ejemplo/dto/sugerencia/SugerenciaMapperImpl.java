package edu.unimagdalena.ejemplo.dto.sugerencia;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-15T18:21:14-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class SugerenciaMapperImpl implements SugerenciaMapper {

    @Override
    public Sugerencia toEntity(SugerenciaDto sugerenciaDto) {
        if ( sugerenciaDto == null ) {
            return null;
        }

        Sugerencia.SugerenciaBuilder sugerencia = Sugerencia.builder();

        sugerencia.id( sugerenciaDto.id() );
        sugerencia.descripcion( sugerenciaDto.descripcion() );

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

        SugerenciaDto sugerenciaDto = new SugerenciaDto( id, descripcion );

        return sugerenciaDto;
    }
}
