package com.example.infotech.dtos.carro;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CarroEspecificacaoDTO(
        @JsonProperty("TipoVeiculo") Integer tipoVeiculo,
        @JsonProperty("Valor") String valor,
        @JsonProperty("Marca") String marca,
        @JsonProperty("Modelo") String modelo,
        @JsonProperty("AnoModelo") Integer anoModelo,
        @JsonProperty("Combustivel") String combustivel,
        @JsonProperty("CodigoFipe") String codigoFipe,
        @JsonProperty("MesReferencia") String mesReferencia,
        @JsonProperty("SiglaCombustivel") String siglaCombustivel) {
}
