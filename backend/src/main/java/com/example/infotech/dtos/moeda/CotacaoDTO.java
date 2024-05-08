package com.example.infotech.dtos.moeda;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CotacaoDTO(
        @JsonAlias("code") String code,
        @JsonAlias("codein") String codein,
        @JsonAlias("bid") Double valor) {
}
