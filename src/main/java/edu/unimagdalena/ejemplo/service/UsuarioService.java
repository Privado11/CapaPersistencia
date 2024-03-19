package edu.unimagdalena.ejemplo.service;


import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

public interface UsuarioService {
    UsuarioDto guardarUsuario(UsuarioToSaveDto usuario);
    UsuarioDto actualizarUsuario(UsuarioToSaveDto usuario) throws UsuarioNotFoundException;
    UsuarioDto buscarUsuarioPorId(Long id) throws UsuarioNotFoundException;
    UsuarioDto buscarUsuarioPorEmail(String email) throws UsuarioNotFoundException;
}
