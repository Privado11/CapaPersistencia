package edu.unimagdalena.ejemplo.service.mensaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.Repository.MensajeRepository;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeDto;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeToSaveDto;
import edu.unimagdalena.ejemplo.dto.mensaje.Mensajemapper;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

@Service
public class MensajeServiceImpl implements MensajeService{

    private final MensajeRepository mensajeRepository;
    private Mensajemapper mensajemapper;
    

    @Autowired
    public MensajeServiceImpl(MensajeRepository mensajeRepository, Mensajemapper mensajemapper) {
        this.mensajeRepository = mensajeRepository;
        this.mensajemapper = mensajemapper;
    }
    

    @Override
    public MensajeDto guardarMensaje(MensajeToSaveDto mensajeToSaveDto) {
        Mensaje mensaje = mensajemapper.mensajeToSaveDtoToEntity(mensajeToSaveDto);
        return mensajemapper.toDto(mensajeRepository.save(mensaje));
    }

    @Override
    public List<MensajeDto> getAllMensajes() {
        List<Mensaje> mensajes = mensajeRepository.findAll();
        return mensajes.stream()
        .map(mensaje -> mensajemapper.toDto(mensaje))
        .toList();
    }

    @Override
    public List<MensajeDto> buscarMensajesPorUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarMensajesPorUsuario'");
    }

    @Override
    public MensajeDto buscarMensajePorId(Long id) throws UsuarioNotFoundException {
        Mensaje mensaje = mensajeRepository.findById(id).
        orElseThrow(() -> new UsuarioNotFoundException("Mensaje no encontrado"));
        return mensajemapper.toDto(mensaje);
    }

}
