package edu.unimagdalena.ejemplo.service.partida;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.ejemplo.Entities.Partida;
import edu.unimagdalena.ejemplo.Repository.PartidaRepository;
import edu.unimagdalena.ejemplo.dto.partidas.PartidaDto;
import edu.unimagdalena.ejemplo.dto.partidas.PartidaMapper;
import edu.unimagdalena.ejemplo.dto.partidas.PartidaToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

@Service
public class PartidaServiceImpl  implements PartidaService{

    private final PartidaRepository partidaRepository;
    private PartidaMapper partidaMapper;

    @Autowired
    public PartidaServiceImpl(PartidaRepository partidaRepository, PartidaMapper partidaMapper) {
        this.partidaRepository = partidaRepository;
        this.partidaMapper = partidaMapper;
    }

    @Override
    public PartidaDto buscarPoId(Long id) throws UsuarioNotFoundException {
        Partida partida = partidaRepository.findById(id).
        orElseThrow(() -> new UsuarioNotFoundException("Partdida no encontrada"));

        return partidaMapper.toDto(partida);
    }

    @Override
    public List<PartidaDto> buscarPartidasPorFecha(LocalDateTime fecha) {
        List<Partida> partidas = partidaRepository.findByFecha(fecha);

        return partidas.stream()
        .map(partida -> partidaMapper.toDto(partida))
        .toList();
    }

    @Override
    public List<PartidaDto> buscarPartidasPorCiudad(String ciudad) {
        List<Partida> partidas = partidaRepository.findByCiudadLike(ciudad);

        return partidas.stream()
        .map(partida -> partidaMapper.toDto(partida))
        .toList();
    }

    @Override
    public PartidaDto guardarPartida(PartidaToSaveDto partidaDto) {
        Partida partida = partidaMapper.PartidaToSaveDtoToEntity(partidaDto);
        return partidaMapper.toDto(partidaRepository.save(partida));
    }

    @Override
    public List<PartidaDto> getAllPartidas() {
        List<Partida> partidas = partidaRepository.findAll();

        return partidas.stream()
        .map(partida -> partidaMapper.toDto(partida))
        .toList();
    }

    
}
