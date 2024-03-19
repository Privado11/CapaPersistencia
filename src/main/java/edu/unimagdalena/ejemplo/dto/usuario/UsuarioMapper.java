package edu.unimagdalena.ejemplo.dto.usuario;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);  
    
    Usuario toEntity(UsuarioDto usuarioDto);

    Usuario UsuarioToSaveDtoToEntity(UsuarioToSaveDto usuarioToSaveDto);


    UsuarioDto toDto(Usuario usuario);

}
