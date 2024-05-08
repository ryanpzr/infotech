package com.example.infotech.models;

import com.example.infotech.dtos.endereco.CepDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cep")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Cep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String rua;
    private String bairro;
    private String uf;

    public Cep(CepDTO dadosCep) {
        this.cep = dadosCep.cep();
        this.rua = dadosCep.rua();
        this.bairro = dadosCep.bairro();
        this.uf = dadosCep.uf();
    }
}
