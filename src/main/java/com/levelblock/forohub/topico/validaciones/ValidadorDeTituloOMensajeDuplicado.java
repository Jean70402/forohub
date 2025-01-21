package com.levelblock.forohub.topico.validaciones;


import com.levelblock.forohub.infra.errores.ValidacionException;
import com.levelblock.forohub.topico.dto.DatosRegistroTopico;
import com.levelblock.forohub.topico.repository.ITopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDeTituloOMensajeDuplicado implements IValidacionTopico {

    private final ITopicoRepository topicoRepository;

    public ValidadorDeTituloOMensajeDuplicado(ITopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }


    @Override
    public void validar(DatosRegistroTopico datos) {
        if (topicoRepository.existsByTituloAndAutorId(datos.titulo(), datos.autorId())) {
            throw new ValidacionException("El usuario ya tiene un tópico con este título.");
        }

        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            throw new ValidacionException("Este título y mensaje ya existe.");
        }

        if (topicoRepository.existsByTitulo(datos.titulo())){
            throw new ValidacionException("Este título ya existe");
        }

        if (topicoRepository.existsByMensaje(datos.mensaje())){
            throw new ValidacionException("Este mensaje ya existe");
        }
    }
}
