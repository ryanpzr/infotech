package com.example.infotech.validacoes.Cep;

import com.example.infotech.exception.EntityConflictException;
import com.example.infotech.models.Cep;
import org.springframework.stereotype.Component;

@Component
public interface ValidarInterface {

    void validar(Cep cep1);

}
