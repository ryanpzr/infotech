package com.example.infotech.infra.service;

import com.example.infotech.dtos.serie.CadastrarSerieDTO;
import com.example.infotech.dtos.serie.SerieDTO;
import com.example.infotech.exception.EntityConflictException;
import com.example.infotech.models.Serie;
import com.example.infotech.repositories.SerieRepository;
import com.example.infotech.validacoes.Serie.ValidarInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private ConsomeApi consomeApi = new ConsomeApi();
    private ConverteDados converteDados = new ConverteDados();

    @Autowired
    private SerieRepository repository;

    @Autowired
    private ValidarInterface validarInterface;

    private List<SerieDTO> converteDados(List<Serie> series) {
        return series.stream()
                .map(s -> new SerieDTO(s.getId(), s.getTitulo(), s.getTotalTemporadas(), s.getAvaliacao(), s.getPoster()))
                .collect(Collectors.toList());
    }

    public List<SerieDTO> listarTop5Series() {
        return converteDados(repository.findTop5ByOrderByAvaliacaoDesc());

    }

    public List<SerieDTO> listarSeries() {
        return converteDados(repository.findAll());
    }

    public Serie cadastrarSerie(CadastrarSerieDTO cadastrarSerieDTO) throws EntityConflictException {
        String tituloFormatado = formatarTitulo(cadastrarSerieDTO.titulo());

        validarInterface.validar(tituloFormatado);

        try {
            String json = consomeApi.obterApi(ENDERECO + cadastrarSerieDTO.titulo().replace(" ", "+") + API_KEY);
            SerieDTO dados = converteDados.obterDados(json, SerieDTO.class);
            Serie serie = new Serie(dados);

            return repository.save(serie);

        } catch (Exception ex) {
            throw new EntityNotFoundException("Nome da série digitado incorretamente, tente novamente!");

        }

    }

    private String formatarTitulo(String titulo) {
        StringBuilder tituloFormatado = new StringBuilder();
        String[] palavras = titulo.split("\\s+");
        for (int i = 0; i < palavras.length; i++) {
            String palavra = palavras[i];
            if (i > 0) {
                tituloFormatado.append(" ");
            }
            tituloFormatado.append(Character.toUpperCase(palavra.charAt(0)));
            tituloFormatado.append(palavra.substring(1).toLowerCase());
        }
        return tituloFormatado.toString();
    }

}
