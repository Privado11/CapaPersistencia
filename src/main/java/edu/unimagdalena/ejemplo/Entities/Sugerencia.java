package edu.unimagdalena.ejemplo.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "sugerencias")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sugerencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
