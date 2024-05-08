package com.example.infotech.controllers;

import com.example.infotech.dtos.moeda.CotacaoBD;
import com.example.infotech.dtos.moeda.CotacaoDTO;
import com.example.infotech.infra.service.CotacaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cotacao")
public class CotacaoController {

    private final CotacaoService service;

    @GetMapping("/moedas")
    public ResponseEntity<List<CotacaoBD>> listarMoedas() {
        List<CotacaoBD> dados = service.listarMoedas();
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping
    public ResponseEntity<CotacaoDTO> listarCotacao(@RequestParam String init) throws JsonProcessingException {
        CotacaoDTO dados = service.listarCotacao(init);
        return ResponseEntity.ok().body(dados);
    }

}
