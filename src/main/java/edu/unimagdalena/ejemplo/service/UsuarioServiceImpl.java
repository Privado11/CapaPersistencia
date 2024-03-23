package edu.unimagdalena.ejemplo.service;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.Repository.UsuarioRepository;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioMapper;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioToSaveDto;
import edu.unimagdalena.ejemplo.exception.NotAbleToDeleteException;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;
    

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioToSaveDto usuarioDto) {
        Usuario usuario = usuarioMapper.UsuarioToSaveDtoToEntity(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto actualizarUsuario(Long id,UsuarioToSaveDto usuarioDto) throws UsuarioNotFoundException {
        return usuarioRepository.findById(id).map(usuario ->{
            usuario.setNombre(usuarioDto.nombre());
            usuario.setApellido(usuarioDto.apellido());
            usuario.setEmail(usuarioDto.email());
            usuario.setPassword(usuarioDto.password());
            usuario.setUsername(usuarioDto.username());

            Usuario usuarioGuardado = usuarioRepository.save(usuario);

            return usuarioMapper.toDto(usuarioGuardado);
        }).orElseThrow(()->new UsuarioNotFoundException("Usuario no encontrado"));
    }

    @Override
    public UsuarioDto buscarUsuarioPorId(Long id) throws UsuarioNotFoundException{
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new UsuarioNotFoundException("Usuario no encontrado"));
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

    @Override
    public void removerUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new NotAbleToDeleteException("Usuario no encontrado") );
        usuarioRepository.delete(usuario);
    }

    @Override
    public List<UsuarioDto> getAllUser() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return  usuarios.stream()
                .map(usuario -> usuarioMapper.toDto(usuario))
                .toList();
    }
}
