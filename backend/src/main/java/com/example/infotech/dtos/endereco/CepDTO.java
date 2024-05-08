package com.example.infotech.dtos.endereco;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CepDTO(
        Long id,
        @JsonAlias("cep") String cep,
        @JsonAlias("logradouro") String rua,
        @JsonAlias("bairro") String bairro,
        @JsonAlias("uf") String uf) {
}
