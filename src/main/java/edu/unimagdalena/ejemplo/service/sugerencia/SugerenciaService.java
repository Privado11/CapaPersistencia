package edu.unimagdalena.ejemplo.service.sugerencia;

import java.util.List;

import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaDto;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

public interface SugerenciaService {
    SugerenciaDto guardarSugerencia(SugerenciaToSaveDto sugerenciaToSaveDto);
    SugerenciaDto buscarSugerenciaPorId(Long id) throws UsuarioNotFoundException;
    List<SugerenciaDto> buscarSugerenciasPorUsuario(Usuario usuario);
    List<SugerenciaDto> getAllSugerencias();
}
