package com.levelblock.forohub.topico.dto;


import com.levelblock.forohub.topico.entity.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 LocalDateTime fechaDeCreacion,
                                 String curso,
                                 String autor){
public DatosListadoTopico(Topico topico){
    this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaDeCreacion(), topico.getCurso(), topico.getAutor().getNombre());
}
}
