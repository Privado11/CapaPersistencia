package edu.unimagdalena.ejemplo.service.partida;

import java.time.LocalDateTime;
import java.util.List;

import edu.unimagdalena.ejemplo.dto.partidas.PartidaDto;
import edu.unimagdalena.ejemplo.dto.partidas.PartidaToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

public interface PartidaService {
    PartidaDto buscarPoId(Long id) throws UsuarioNotFoundException;
    List<PartidaDto> buscarPartidasPorFecha(LocalDateTime fecha);
    List<PartidaDto> buscarPartidasPorCiudad(String ciudad);
    PartidaDto guardarPartida(PartidaToSaveDto partidaDto);
    List<PartidaDto> getAllPartidas();

}
