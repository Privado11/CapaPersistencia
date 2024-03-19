package edu.unimagdalena.ejemplo.service;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.Repository.UsuarioRepository;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioMapper;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;


    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioToSaveDto usuarioDto) {
        Usuario usuario = usuarioMapper.UsuarioToSaveDtoToEntity(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto actualizarUsuario(UsuarioToSaveDto usuarioDto) throws UsuarioNotFoundException {
        Usuario usuarioEncontrado = usuarioRepository.findByEmail(usuarioDto.email());
        if(Objects.isNull(usuarioEncontrado)){
            throw  new UsuarioNotFoundException("Usuario no encontrado.");
        }
        usuarioRepository.delete(usuarioEncontrado);
        Usuario usuario = usuarioMapper.UsuarioToSaveDtoToEntity(usuarioDto);
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return  usuarioMapper.toDto(usuarioActualizado);
    }

    @Override
    public UsuarioDto buscarUsuarioPorId(Long id) throws UsuarioNotFoundException{
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(UsuarioNotFoundException::new);
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto buscarUsuarioPorEmail(String email) throws UsuarioNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if(Objects.isNull(usuario)){
            throw  new UsuarioNotFoundException("Usuario no encontrado.");
        }
        return usuarioMapper.toDto(usuario);
    }
}
