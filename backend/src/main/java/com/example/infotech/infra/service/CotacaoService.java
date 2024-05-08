package com.example.infotech.infra.service;

import com.example.infotech.dtos.moeda.CotacaoBD;
import com.example.infotech.dtos.moeda.CotacaoDTO;
import com.example.infotech.models.Cotacao;
import com.example.infotech.repositories.CotacaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CotacaoService {

    private String ENDERECO = "https://economia.awesomeapi.com.br/last/";

    ConsomeApi consomeApi = new ConsomeApi();

    ConverteDados converte = new ConverteDados();

    @Autowired
    private CotacaoRepository repository;

    private List<CotacaoBD> converteDados(List<Cotacao> cotacao) {
        return cotacao.stream()
                .map(c -> new CotacaoBD(c.getId(), c.getValor()))
                .collect(Collectors.toList());
    }
    public List<CotacaoBD> listarMoedas() {
        return converteDados(repository.findAll());

    }

    public CotacaoDTO listarCotacao(String init) throws JsonProcessingException {
        String json = consomeApi.obterApi(ENDERECO + init + "-BRL");
        String modelo = init + "BRL";
        String cotacao = converte.obterJson(json, modelo);
        CotacaoDTO dados = converte.obterDados(cotacao, CotacaoDTO.class);
        return dados;

    }
}
