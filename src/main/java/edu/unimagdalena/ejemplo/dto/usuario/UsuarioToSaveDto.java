package edu.unimagdalena.ejemplo.dto.usuario;

public record UsuarioToSaveDto(
    Long id,
    String nombre,
    String apellido,
    String username,
    String email,
    String password
) {
    
}
