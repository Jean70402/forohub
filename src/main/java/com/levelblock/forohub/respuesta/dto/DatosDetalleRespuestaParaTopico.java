package com.levelblock.forohub.respuesta.dto;

import com.levelblock.forohub.usuario.dto.DatosUsuarioIdNombre;

import java.time.LocalDateTime;

public record DatosDetalleRespuestaParaTopico(Long id,
                                              String mensaje,
                                              LocalDateTime fechaDeCreacion,
                                              DatosUsuarioIdNombre autor) {
}
