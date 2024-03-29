package edu.unimagdalena.ejemplo.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String password;
    private String repPassword;
    private Boolean enabled;
    private String foto;
    private String rol;
    @Temporal(TemporalType.DATE)
    private LocalDateTime fechaCreacion;


    @OneToMany(mappedBy = "usuario")
    private List<Sugerencia> sugerencias;

    @OneToMany(mappedBy = "usuario")
    private List<Mensaje> mensajes;


    @ManyToMany
    @JoinTable(
            name = "usuario_partida", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_partida", referencedColumnName = "id")
    )
    private List<Partida> partidas;
}
