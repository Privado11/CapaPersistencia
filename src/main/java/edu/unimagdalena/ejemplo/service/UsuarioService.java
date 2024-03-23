package edu.unimagdalena.ejemplo.service;


import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

import java.util.List;

public interface UsuarioService {
    UsuarioDto guardarUsuario(UsuarioToSaveDto usuario);
    UsuarioDto actualizarUsuario(Long id, UsuarioToSaveDto usuario) throws UsuarioNotFoundException;
    UsuarioDto buscarUsuarioPorId(Long id) throws UsuarioNotFoundException;
    UsuarioDto buscarUsuarioPorEmail(String email) throws UsuarioNotFoundException;
    void removerUsuario(Long id);

    List<UsuarioDto> getAllUser();
}
