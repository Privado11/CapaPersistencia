package edu.unimagdalena.ejemplo.dto.usuario;

import edu.unimagdalena.ejemplo.Entities.Mensaje;
import edu.unimagdalena.ejemplo.Entities.Partida;
import edu.unimagdalena.ejemplo.Entities.Sugerencia;
import edu.unimagdalena.ejemplo.Entities.Usuario;
import edu.unimagdalena.ejemplo.dto.mensaje.MensajeDto;
import edu.unimagdalena.ejemplo.dto.partidas.PartidaDto;
import edu.unimagdalena.ejemplo.dto.sugerencia.SugerenciaDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-20T22:35:49-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.apellido( usuarioDto.apellido() );
        usuario.email( usuarioDto.email() );
        usuario.id( usuarioDto.id() );
        usuario.mensajes( mensajeDtoListToMensajeList( usuarioDto.mensajes() ) );
        usuario.nombre( usuarioDto.nombre() );
        usuario.partidas( partidaDtoListToPartidaList( usuarioDto.partidas() ) );
        usuario.sugerencias( sugerenciaDtoListToSugerenciaList( usuarioDto.sugerencias() ) );
        usuario.username( usuarioDto.username() );

        return usuario.build();
    }

    @Override
    public Usuario UsuarioToSaveDtoToEntity(UsuarioToSaveDto usuarioToSaveDto) {
        if ( usuarioToSaveDto == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.apellido( usuarioToSaveDto.apellido() );
        usuario.email( usuarioToSaveDto.email() );
        usuario.id( usuarioToSaveDto.id() );
        usuario.nombre( usuarioToSaveDto.nombre() );
        usuario.username( usuarioToSaveDto.username() );

        return usuario.build();
    }

    @Override
    public UsuarioDto toDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        String apellido = null;
        String username = null;
        String email = null;
        List<SugerenciaDto> sugerencias = null;
        List<MensajeDto> mensajes = null;
        List<PartidaDto> partidas = null;

        id = usuario.getId();
        nombre = usuario.getNombre();
        apellido = usuario.getApellido();
        username = usuario.getUsername();
        email = usuario.getEmail();
        sugerencias = sugerenciaListToSugerenciaDtoList( usuario.getSugerencias() );
        mensajes = mensajeListToMensajeDtoList( usuario.getMensajes() );
        partidas = partidaListToPartidaDtoList( usuario.getPartidas() );

        UsuarioDto usuarioDto = new UsuarioDto( id, nombre, apellido, username, email, sugerencias, mensajes, partidas );

        return usuarioDto;
    }

    protected Mensaje mensajeDtoToMensaje(MensajeDto mensajeDto) {
        if ( mensajeDto == null ) {
            return null;
        }

        Mensaje.MensajeBuilder mensaje = Mensaje.builder();

        mensaje.contenido( mensajeDto.contenido() );
        mensaje.destinatario( mensajeDto.destinatario() );
        mensaje.id( mensajeDto.id() );

        return mensaje.build();
    }

    protected List<Mensaje> mensajeDtoListToMensajeList(List<MensajeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Mensaje> list1 = new ArrayList<Mensaje>( list.size() );
        for ( MensajeDto mensajeDto : list ) {
            list1.add( mensajeDtoToMensaje( mensajeDto ) );
        }

        return list1;
    }

    protected Partida partidaDtoToPartida(PartidaDto partidaDto) {
        if ( partidaDto == null ) {
            return null;
        }

        Partida.PartidaBuilder partida = Partida.builder();

        partida.ciudad( partidaDto.ciudad() );
        partida.comentarios( partidaDto.comentarios() );
        partida.creador( partidaDto.creador() );
        partida.deporte( partidaDto.deporte() );
        partida.id( partidaDto.id() );
        partida.participantes( partidaDto.participantes() );
        partida.provincia( partidaDto.provincia() );
        partida.suplentes( partidaDto.suplentes() );

        return partida.build();
    }

    protected List<Partida> partidaDtoListToPartidaList(List<PartidaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Partida> list1 = new ArrayList<Partida>( list.size() );
        for ( PartidaDto partidaDto : list ) {
            list1.add( partidaDtoToPartida( partidaDto ) );
        }

        return list1;
    }

    protected Sugerencia sugerenciaDtoToSugerencia(SugerenciaDto sugerenciaDto) {
        if ( sugerenciaDto == null ) {
            return null;
        }

        Sugerencia.SugerenciaBuilder sugerencia = Sugerencia.builder();

        sugerencia.descripcion( sugerenciaDto.descripcion() );
        sugerencia.id( sugerenciaDto.id() );

        return sugerencia.build();
    }

    protected List<Sugerencia> sugerenciaDtoListToSugerenciaList(List<SugerenciaDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Sugerencia> list1 = new ArrayList<Sugerencia>( list.size() );
        for ( SugerenciaDto sugerenciaDto : list ) {
            list1.add( sugerenciaDtoToSugerencia( sugerenciaDto ) );
        }

        return list1;
    }

    protected SugerenciaDto sugerenciaToSugerenciaDto(Sugerencia sugerencia) {
        if ( sugerencia == null ) {
            return null;
        }

        Long id = null;
        String descripcion = null;

        id = sugerencia.getId();
        descripcion = sugerencia.getDescripcion();

        SugerenciaDto sugerenciaDto = new SugerenciaDto( id, descripcion );

        return sugerenciaDto;
    }

    protected List<SugerenciaDto> sugerenciaListToSugerenciaDtoList(List<Sugerencia> list) {
        if ( list == null ) {
            return null;
        }

        List<SugerenciaDto> list1 = new ArrayList<SugerenciaDto>( list.size() );
        for ( Sugerencia sugerencia : list ) {
            list1.add( sugerenciaToSugerenciaDto( sugerencia ) );
        }

        return list1;
    }

    protected MensajeDto mensajeToMensajeDto(Mensaje mensaje) {
        if ( mensaje == null ) {
            return null;
        }

        Long id = null;
        String destinatario = null;
        String contenido = null;

        id = mensaje.getId();
        destinatario = mensaje.getDestinatario();
        contenido = mensaje.getContenido();

        MensajeDto mensajeDto = new MensajeDto( id, destinatario, contenido );

        return mensajeDto;
    }

    protected List<MensajeDto> mensajeListToMensajeDtoList(List<Mensaje> list) {
        if ( list == null ) {
            return null;
        }

        List<MensajeDto> list1 = new ArrayList<MensajeDto>( list.size() );
        for ( Mensaje mensaje : list ) {
            list1.add( mensajeToMensajeDto( mensaje ) );
        }

        return list1;
    }

    protected PartidaDto partidaToPartidaDto(Partida partida) {
        if ( partida == null ) {
            return null;
        }

        Long id = null;
        String creador = null;
        String deporte = null;
        String ciudad = null;
        String provincia = null;
        Integer participantes = null;
        Integer suplentes = null;
        String comentarios = null;

        id = partida.getId();
        creador = partida.getCreador();
        deporte = partida.getDeporte();
        ciudad = partida.getCiudad();
        provincia = partida.getProvincia();
        participantes = partida.getParticipantes();
        suplentes = partida.getSuplentes();
        comentarios = partida.getComentarios();

        PartidaDto partidaDto = new PartidaDto( id, creador, deporte, ciudad, provincia, participantes, suplentes, comentarios );

        return partidaDto;
    }

    protected List<PartidaDto> partidaListToPartidaDtoList(List<Partida> list) {
        if ( list == null ) {
            return null;
        }

        List<PartidaDto> list1 = new ArrayList<PartidaDto>( list.size() );
        for ( Partida partida : list ) {
            list1.add( partidaToPartidaDto( partida ) );
        }

        return list1;
    }
}
