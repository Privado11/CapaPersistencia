package edu.unimagdalena.ejemplo.controller.usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.service.usuario.UsuarioService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;                                 

import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;
    @Autowired
    private ObjectMapper objectMapper;

    private Usuario usuario;
    private UsuarioDto usuarioDto;


    @BeforeEach
    void setUp() {
        usuarioDto = new UsuarioDto(1l, 
        "Walter", 
        "Jiménez", 
        "privado", 
        "privado@privado.com", 
        Collections.emptyList(), 
        Collections.emptyList(), 
        Collections.emptyList());
    }

    @Test
    void getUsuarios() throws Exception {
        List<UsuarioDto> usuarioDtos = List.of(new UsuarioDto(1l, "Walter", "Jiménez", "privado", "privado@privado.com", Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
                new UsuarioDto(2l, "Walter", "Jiménez", "privado2", "privado2@privado.com", Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));

        when(usuarioService.getAllUser()).thenReturn(usuarioDtos);

        mockMvc.perform(get("/api/v1/usuarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[1].username",is("privado2")));
    }

    @Test
    void getUsuarioById() throws Exception{

        when(usuarioService.buscarUsuarioPorId(any())).thenReturn(usuarioDto);

        mockMvc.perform(get("/api/v1/usuarios/{id}", 4l)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",is(1)))
                .andExpect(jsonPath("$.username",is("privado")));
    }

    @Test
    void deleteUsuario() throws Exception{
        Long idUsuario = 58l;
        doNothing().when(usuarioService).removerUsuario(any());

        mockMvc.perform(delete("/api/v1/usuarios/{id}", idUsuario))
                .andExpect(status().isOk())
                .andExpect(content().string("Usuario eliminado correctamente."));

        verify(usuarioService, times(1)).removerUsuario(any());         
    }

}       