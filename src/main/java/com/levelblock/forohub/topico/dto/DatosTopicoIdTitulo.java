package com.levelblock.forohub.topico.dto;


import com.levelblock.forohub.topico.entity.Topico;

public record DatosTopicoIdTitulo(Long id, String titulo) {
    public DatosTopicoIdTitulo(Topico topico) {
        this(topico.getId(), topico.getTitulo());
    }
}
