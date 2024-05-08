package com.example.infotech.validacoes.Serie;

import com.example.infotech.exception.EntityConflictException;
import com.example.infotech.models.Serie;
import com.example.infotech.repositories.SerieRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarSerieJaCadastradoNoBancoDeDados implements ValidarInterface{

    @Autowired
    private SerieRepository repository;

    @SneakyThrows
    public void validar(String tituloFormatado) {
        Optional<Serie> serieExistente = repository.findByTitulo(tituloFormatado);
        if (serieExistente.isPresent()) {
            throw new EntityConflictException("Série digitada já cadastrada no banco de dados, tente novamente.");
        }
    }

}
