package com.levelblock.forohub.topico.validaciones;


import com.levelblock.forohub.infra.errores.ValidacionException;
import com.levelblock.forohub.topico.dto.DatosRegistroTopico;
import com.levelblock.forohub.topico.repository.ITopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDeLimiteDeTopicosPorUsuario implements IValidacionTopico{

    private final ITopicoRepository topicoRepository;
    private final int LIMITE_TOPICOS = 10;

    public ValidadorDeLimiteDeTopicosPorUsuario(ITopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }


    @Override
    public void validar(DatosRegistroTopico datos) {
        long cantidadTopicos = topicoRepository.countByAutorId(datos.autorId());
        if (cantidadTopicos >= LIMITE_TOPICOS) {
            throw new ValidacionException("Un autor no puede tener más de " + LIMITE_TOPICOS + " tópicos.");
        }
    }
}
