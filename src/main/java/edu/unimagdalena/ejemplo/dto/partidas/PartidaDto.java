package edu.unimagdalena.ejemplo.dto.partidas;

public record PartidaDto(
        Long id,
        String creador,
        String deporte,
        String ciudad,
        String provincia,
        Integer participantes,
        Integer suplentes,
        String comentarios) {
}
