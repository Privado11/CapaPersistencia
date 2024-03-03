package edu.unimagdalena.ejemplo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @Temporal(TemporalType.DATE)
    private LocalDateTime fecha;

    @Temporal(TemporalType.TIME)
    private LocalDateTime horaComienzo;

    @Temporal(TemporalType.TIME)
    private LocalDateTime horaFinal;

    @ManyToMany(mappedBy = "partidas")
    private List<Usuario> usuarios;
}