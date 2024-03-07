package edu.unimagdalena.ejemplo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mensajes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String creador;
    private String destinatario;
    private String contenido;

    @Temporal(TemporalType.DATE)
    private LocalDateTime fecha;


    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
