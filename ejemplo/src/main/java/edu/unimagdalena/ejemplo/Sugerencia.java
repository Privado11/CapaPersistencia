package edu.unimagdalena.ejemplo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime fechaCreacion;
    @ManyToMany
    @JoinTable(name = "usuarios", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private Usuario usuario;
}
