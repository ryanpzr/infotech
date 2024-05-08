package com.example.infotech.models;

import com.example.infotech.dtos.moeda.CotacaoBD;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cotacao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Cotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valor;

    public Cotacao(CotacaoBD cotacaoBD) {
        this.id = cotacaoBD.id();
        this.valor = cotacaoBD.valor();
    }

}
