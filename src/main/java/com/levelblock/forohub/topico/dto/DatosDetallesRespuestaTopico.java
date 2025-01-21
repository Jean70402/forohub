package com.levelblock.forohub.topico.dto;


import com.levelblock.forohub.respuesta.dto.DatosDetalleRespuestaParaTopico;
import com.levelblock.forohub.usuario.dto.DatosUsuarioIdNombre;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDetallesRespuestaTopico(Long id,
                                           String titulo,
                                           String mensaje,
                                           LocalDateTime fechaDeCreacion,
                                           String curso,
                                           DatosUsuarioIdNombre autor,
                                           List<DatosDetalleRespuestaParaTopico> respuestas) {
}
