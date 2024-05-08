package com.example.infotech.models;

import com.example.infotech.dtos.carro.CarroEspecificacaoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Carro {

    private Integer tipoVeiculo;
    private String valor;
    private String marca;
    private String modelo;
    private Integer anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private String siglaCombustivel;

    public Carro(CarroEspecificacaoDTO carroDTO) {
        this.tipoVeiculo = carroDTO.tipoVeiculo();
        this.valor = carroDTO.valor();
        this.marca = carroDTO.marca();
        this.modelo = carroDTO.modelo();
        this.anoModelo = carroDTO.anoModelo();
        this.combustivel = carroDTO.combustivel();
        this.codigoFipe = carroDTO.codigoFipe();
        this.mesReferencia = carroDTO.mesReferencia();
        this.siglaCombustivel = carroDTO.siglaCombustivel();
    }
}
