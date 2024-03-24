package edu.unimagdalena.ejemplo.controller;

import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.exception.NotAbleToDeleteException;
import edu.unimagdalena.ejemplo.exception.UsuarioNotFoundException;
import edu.unimagdalena.ejemplo.service.usuario.UsuarioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> getUsuarios(){
        List<UsuarioDto> usuarioDtos = usuarioService.getAllUser();
        return ResponseEntity.ok().body(usuarioDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable("id") Long idUsuario){
        try {
            UsuarioDto usuarioDto = usuarioService.buscarUsuarioPorId(idUsuario);
            return ResponseEntity.ok().body(usuarioDto);
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long idUsuario){
        try {
            usuarioService.removerUsuario(idUsuario);
            return ResponseEntity.ok().body("Usuario eliminado correctamente.");
        } catch (NotAbleToDeleteException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
