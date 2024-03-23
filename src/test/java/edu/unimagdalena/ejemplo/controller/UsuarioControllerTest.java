package edu.unimagdalena.ejemplo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.dto.usuario.UsuarioDto;
import edu.unimagdalena.ejemplo.service.UsuarioService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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
    }

    @Test
    void getUsuarios() {
        List<UsuarioDto> usuarioDtos = List.of(new UsuarioDto(1l, "Walter", "Jiménez", "privado", "privado@privado.com", Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
                new UsuarioDto(2l, "Walter", "Jiménez", "privado2", "privado2@privado.com", Collections.emptyList(), Collections.emptyList(), Collections.emptyList()));

        when(usuarioService.getAllUser()).thenReturn(usuarioDtos);

        ResultActions response = mockMvc.perform(get("/api/v1/usuarios")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[0].id"), is ("1l")));
    }

}