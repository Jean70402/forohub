package com.levelblock.forohub.respuesta.dto;


import com.levelblock.forohub.topico.dto.DatosTopicoIdTitulo;
import com.levelblock.forohub.usuario.dto.DatosUsuarioIdNombre;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public record DatosRespuestaCliente(@NotNull Long id,
                                    String mensaje,
                                    LocalDateTime fechaDeCreacion,
                                    DatosUsuarioIdNombre usuario,
                                    DatosTopicoIdTitulo topico,
                                    boolean solucion
) {
}
