package com.levelblock.forohub.controller;


import com.levelblock.forohub.respuesta.dto.DatosRegistroRespuesta;
import com.levelblock.forohub.respuesta.dto.DatosRespuestaCliente;
import com.levelblock.forohub.respuesta.dto.DatosActualizarRespuesta;
import com.levelblock.forohub.service.RespuestaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    private final RespuestaService respuestaService;

    @Autowired
    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaCliente> registrarRespuesta(@Valid @RequestBody DatosRegistroRespuesta datosRegistroRespuesta, UriComponentsBuilder uriComponentsBuilder){
        DatosRespuestaCliente respuesta = respuestaService.crearRespuesta(datosRegistroRespuesta);
        URI uri = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.id()).toUri();
        return ResponseEntity.created(uri).body(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaCliente> obtenerRespuestaPorId(@PathVariable Long id) {
        DatosRespuestaCliente respuesta = respuestaService.obtenerRespuestaPorId(id);
        return ResponseEntity.ok(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaCliente> actualizarRespuesta(@PathVariable Long id,
                                                                     @Valid @RequestBody DatosActualizarRespuesta datosActualizarRespuesta) {
        DatosRespuestaCliente respuesta = respuestaService.actualizarRespuesta(id, datosActualizarRespuesta);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long id) {
        respuestaService.eliminarRespuesta(id);
        return ResponseEntity.noContent().build();
    }


}
