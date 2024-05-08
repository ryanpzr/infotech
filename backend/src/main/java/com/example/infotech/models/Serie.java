package com.example.infotech.models;

import com.example.infotech.dtos.serie.SerieDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "serie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private String poster;

    public Serie(SerieDTO dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = Double.valueOf(dadosSerie.avaliacao());
        this.poster = dadosSerie.poster();
    }

}
