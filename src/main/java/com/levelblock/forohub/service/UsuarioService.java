package com.levelblock.forohub.service;


import com.levelblock.forohub.usuario.IUsuarioRepository;
import com.levelblock.forohub.usuario.Usuario;
import com.levelblock.forohub.usuario.dto.DatosRegistroUsuario;
import com.levelblock.forohub.usuario.dto.DatosRespuestaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DatosRespuestaUsuario registrarUsuario(DatosRegistroUsuario datos) {
        String hashedPassword = passwordEncoder.encode(datos.contrasenia());
        DatosRegistroUsuario datosConHashedPassword = new DatosRegistroUsuario(datos.nombre(), datos.correoElectronico(), hashedPassword);
        Usuario usuario = new Usuario(datosConHashedPassword);
        usuario = usuarioRepository.save(usuario);
        return new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico());
    }



}
