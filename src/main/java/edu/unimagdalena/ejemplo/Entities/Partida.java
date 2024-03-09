package edu.unimagdalena.ejemplo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "partidas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String creador;
    private String deporte;
    private String ciudad;
    private String provincia;
    private Integer participantes;
    private Integer suplentes;
    private String comentarios;

    @ManyToMany(mappedBy = "partidas")
    private List<Usuario> usuarios;
}