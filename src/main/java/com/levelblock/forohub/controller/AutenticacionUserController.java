package com.levelblock.forohub.controller;



import com.levelblock.forohub.infra.segurity.DatosJWTToken;
import com.levelblock.forohub.infra.segurity.TokenService;
import com.levelblock.forohub.service.UsuarioService;
import com.levelblock.forohub.usuario.Usuario;
import com.levelblock.forohub.usuario.dto.DatosAutenticacionUsuario;
import com.levelblock.forohub.usuario.dto.DatosRegistroUsuario;
import com.levelblock.forohub.usuario.dto.DatosRespuestaUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class AutenticacionUserController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    @Autowired
    public AutenticacionUserController(AuthenticationManager authenticationManager,
                                       TokenService tokenService,UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@Valid @RequestBody DatosRegistroUsuario datos,
                                                                  UriComponentsBuilder uriBuilder) {
        DatosRespuestaUsuario respuesta = usuarioService.registrarUsuario(datos);
        URI location = uriBuilder.path("/usuario/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(location).body(respuesta);
    }

    @PostMapping("/login")
    public ResponseEntity<DatosJWTToken> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                datosAutenticacionUsuario.correoElectronico(),
                datosAutenticacionUsuario.contrasenia()
        );
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }

}
