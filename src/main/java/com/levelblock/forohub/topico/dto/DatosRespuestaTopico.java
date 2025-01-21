package com.levelblock.forohub.topico.dto;


import com.levelblock.forohub.usuario.dto.DatosRespuestaUsuario;

import java.time.LocalDateTime;


public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   LocalDateTime fechaDeCreacion,
                                   String nombreCurso,
                                   DatosRespuestaUsuario autor) {
}
