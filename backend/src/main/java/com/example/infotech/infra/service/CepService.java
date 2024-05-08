package com.example.infotech.infra.service;

import com.example.infotech.dtos.endereco.CadastrarCepDTO;
import com.example.infotech.dtos.endereco.CepDTO;
import com.example.infotech.exception.EntityConflictException;
import com.example.infotech.models.Cep;
import com.example.infotech.repositories.CepRepository;
import com.example.infotech.validacoes.Cep.ValidarInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class CepService {

    Scanner leitura = new Scanner(System.in);
    ConsomeApi consome = new ConsomeApi();
    ConverteDados converte = new ConverteDados();
    private final String ENDERECO = "https://viacep.com.br/ws/";
    private final String API_KEY = "/json/";

    @Autowired
    private CepRepository repository;

    @Autowired
    private ValidarInterface validarInterface;

    private List<CepDTO> converteDados(List<Cep> ceps) {
        return ceps.stream()
                .map(c -> new CepDTO(c.getId(), c.getCep(), c.getRua(), c.getBairro(), c.getUf()))
                .collect(Collectors.toList());
    }

    public List<CepDTO> listarEndereco() {
        return converteDados(repository.findAll());

    }

    public Cep cadastrarEndereco(CadastrarCepDTO cadastrarCepDTO) throws EntityConflictException {
        try {
            var json = consome.obterApi(ENDERECO + cadastrarCepDTO.cep() + API_KEY);
            CepDTO dados = converte.obterDados(json, CepDTO.class);
            Cep cep1 = new Cep(dados);

            validarInterface.validar(cep1);

            return repository.save(cep1);

        } catch (Exception ex) {
            throw new EntityNotFoundException("Cep digitado incorretamente, tente novamente!");
        }

    }
}
