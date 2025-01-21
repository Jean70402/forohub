package com.levelblock.forohub.usuario.dto;


import com.levelblock.forohub.usuario.Usuario;

public record DatosUsuarioIdNombre(Long id, String nombre) {
    public DatosUsuarioIdNombre(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());
    }
}
