package com.example.infotech.controllers;

import com.example.infotech.dtos.serie.CadastrarSerieDTO;
import com.example.infotech.dtos.serie.SerieDTO;
import com.example.infotech.exception.EntityConflictException;
import com.example.infotech.models.Serie;
import com.example.infotech.infra.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/series")
public class SerieController {

    private final SerieService service;

    @GetMapping("/top5")
    public ResponseEntity<List<SerieDTO>> obterTop5() {
        List<SerieDTO> dados = service.listarTop5Series();
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping
    public ResponseEntity<List<SerieDTO>> listarSerie() {
        List<SerieDTO> dados = service.listarSeries();
        return ResponseEntity.ok().body(dados);
    }

    @PostMapping
    public ResponseEntity<Serie> cadastrarSerie(@RequestBody CadastrarSerieDTO cadastrarSerieDTO, UriComponentsBuilder uriBuilder) throws EntityConflictException {
        Serie serie = service.cadastrarSerie(cadastrarSerieDTO);
        URI uri = uriBuilder.path("/api/series/{id}").buildAndExpand(serie.getId()).toUri();
        return ResponseEntity.created(uri).body(serie);
    }
}
