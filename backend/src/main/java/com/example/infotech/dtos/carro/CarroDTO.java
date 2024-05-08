package com.example.infotech.dtos.carro;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CarroDTO(@JsonAlias("codigo") String codigo,
                       @JsonAlias("nome") String nome){
}
