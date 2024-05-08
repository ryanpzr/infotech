package com.example.infotech.controllers;

import com.example.infotech.dtos.endereco.CadastrarCepDTO;
import com.example.infotech.dtos.endereco.CepDTO;
import com.example.infotech.exception.EntityConflictException;
import com.example.infotech.models.Cep;
import com.example.infotech.infra.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cep/endereco")
public class CepController {

    private final CepService service;

    @GetMapping
    public ResponseEntity<List<CepDTO>> listarEndereco() {
        List<CepDTO> dados = service.listarEndereco();
        return ResponseEntity.ok().body(dados);
    }

    @PostMapping
    public ResponseEntity<Cep> cadastrarEndereco(@RequestBody CadastrarCepDTO cep, UriComponentsBuilder uriBuilder) throws EntityConflictException {
            Cep cep1 = service.cadastrarEndereco(cep);
            URI uri = uriBuilder.path("/api/cep/endereco/{id}").buildAndExpand(cep1.getId()).toUri();
            return ResponseEntity.created(uri).body(cep1);
    }
}
