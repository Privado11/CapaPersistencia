package edu.unimagdalena.ejemplo.dto.usuario;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.unimagdalena.ejemplo.Entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);  
    
    Usuario toEntity(UsuarioDto usuarioDto);

    Usuario UsuarioToSaveDtoToEntity(UsuarioToSaveDto usuarioToSaveDto);
    
    UsuarioDto toDto(Usuario usuario);
}
