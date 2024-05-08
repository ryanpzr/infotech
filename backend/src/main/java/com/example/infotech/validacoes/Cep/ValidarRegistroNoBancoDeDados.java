package com.example.infotech.validacoes.Cep;

import com.example.infotech.exception.EntityConflictException;
import com.example.infotech.models.Cep;
import com.example.infotech.repositories.CepRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidarRegistroNoBancoDeDados implements ValidarInterface {

    @Autowired
    private CepRepository repository;

    @SneakyThrows
    public void validar(Cep cep1) {

        Optional<Cep> cepExistente = repository.findByRua(cep1.getRua());
        if (cepExistente.isPresent()) {
            throw new EntityConflictException("Cep digitado já cadastrado no banco de dados, tente novamente.");
        }

    }

}
