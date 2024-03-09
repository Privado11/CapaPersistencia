package edu.unimagdalena.ejemplo.Entities;

import jakarta.persistence.*;
import lombok.*;

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



    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
