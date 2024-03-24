package edu.unimagdalena.ejemplo.service.sugerencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.Repository.SugerenciaRepository;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaDto;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaMapper;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaToSaveDto;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;

@Service
public class SugerenciaServiceImpl implements SugerenciaService{

    private final SugerenciaRepository sugerenciaRepository;
    private SugerenciaMapper sugerenciaMapper;

    @Autowired
    public SugerenciaServiceImpl(SugerenciaRepository sugerenciaRepository, SugerenciaMapper sugerenciaMapper) {
        this.sugerenciaRepository = sugerenciaRepository;
        this.sugerenciaMapper = sugerenciaMapper;
    }

    @Override
    public SugerenciaDto guardarSugerencia(SugerenciaToSaveDto sugerenciaDto) {
        Sugerencia sugerencia = sugerenciaMapper.sugerenciaToSaveDtoToEntity(sugerenciaDto);
        return sugerenciaMapper.toDto(sugerenciaRepository.save(sugerencia));
    }

    @Override
    public SugerenciaDto buscarSugerenciaPorId(Long id) throws UsuarioNotFoundException {
        Sugerencia sugerencia = sugerenciaRepository.findById(id)
        .orElseThrow(() -> new UsuarioNotFoundException("Sugerencia no encontrada"));

        return sugerenciaMapper.toDto(sugerencia);

    }

    @Override
    public List<SugerenciaDto> buscarSugerenciasPorUsuario(Usuario usuario) {
        List<Sugerencia> sugerenciasDelCreador = sugerenciaRepository.findByUsuario(usuario);

        return sugerenciasDelCreador.stream()
        .map(sugerencia -> sugerenciaMapper.toDto(sugerencia)).toList();
    }

    @Override
    public List<SugerenciaDto> getAllSugerencias() {
        List<Sugerencia> sugerencias = sugerenciaRepository.findAll();

        return sugerencias.stream()
        .map(sugerencia -> sugerenciaMapper.toDto(sugerencia)).toList();
    }
}
