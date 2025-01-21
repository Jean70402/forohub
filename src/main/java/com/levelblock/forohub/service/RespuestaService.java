package com.levelblock.forohub.service;


import com.levelblock.forohub.respuesta.IRespuestaRepository;
import com.levelblock.forohub.respuesta.Respuesta;
import com.levelblock.forohub.respuesta.dto.DatosActualizarRespuesta;
import com.levelblock.forohub.respuesta.dto.DatosRespuestaCliente;
import com.levelblock.forohub.respuesta.dto.DatosRegistroRespuesta;
import com.levelblock.forohub.topico.dto.DatosTopico;
import com.levelblock.forohub.topico.dto.DatosTopicoIdTitulo;
import com.levelblock.forohub.topico.entity.Topico;
import com.levelblock.forohub.topico.repository.ITopicoRepository;
import com.levelblock.forohub.usuario.IUsuarioRepository;
import com.levelblock.forohub.usuario.Usuario;
import com.levelblock.forohub.usuario.dto.DatosUsuario;
import com.levelblock.forohub.usuario.dto.DatosUsuarioIdNombre;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    private final IRespuestaRepository respuestaRepository;
    private final IUsuarioRepository usuarioRepository;
    private final ITopicoRepository topicoRepository;

    public RespuestaService(IRespuestaRepository respuestaRepository, IUsuarioRepository usuarioRepository, ITopicoRepository topicoRepository) {
        this.respuestaRepository = respuestaRepository;
        this.usuarioRepository = usuarioRepository;
        this.topicoRepository = topicoRepository;
    }


    //post
    public DatosRespuestaCliente crearRespuesta(DatosRegistroRespuesta datosRegistroRespuesta) {
        Usuario autor = usuarioRepository.findById(datosRegistroRespuesta.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado"));

        Topico topico = topicoRepository.findById(datosRegistroRespuesta.topicoId())
                .orElseThrow(() -> new EntityNotFoundException("Tópico no encontrado"));

        Respuesta respuesta = new Respuesta(datosRegistroRespuesta, new DatosTopico(topico), new DatosUsuario(autor));
        respuestaRepository.save(respuesta);

        return new DatosRespuestaCliente(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaDeCreacion(), new DatosUsuarioIdNombre(autor), new DatosTopicoIdTitulo(topico), respuesta.isSolucion());
    }

    //get
    public DatosRespuestaCliente obtenerRespuestaPorId(Long id) {
        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrada"));
        return new DatosRespuestaCliente(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaDeCreacion(),
                new DatosUsuarioIdNombre(respuesta.getAutor()),
                new DatosTopicoIdTitulo(respuesta.getTopico()),
                respuesta.isSolucion());
    }

    //put
    @Transactional
    public DatosRespuestaCliente actualizarRespuesta(Long id, DatosActualizarRespuesta datosActualizarRespuesta) {
        Respuesta respuesta = respuestaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Respuesta no encontrada"));
        respuesta.actualizarInformacion(datosActualizarRespuesta);
        return new DatosRespuestaCliente(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaDeCreacion(),
                new DatosUsuarioIdNombre(respuesta.getAutor()),
                new DatosTopicoIdTitulo(respuesta.getTopico()),
                respuesta.isSolucion());
    }

    //delete
    @Transactional
    public void eliminarRespuesta(Long id) {
        if (!respuestaRepository.existsById(id)) {
            throw new EntityNotFoundException("Respuesta no encontrada");
        }
        respuestaRepository.deleteById(id);
    }



}
