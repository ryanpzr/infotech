package com.example.infotech.infra.service;

import com.example.infotech.dtos.carro.CarroDTO;
import com.example.infotech.dtos.carro.CarroEspecificacaoDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private ConsomeApi consomeApi = new ConsomeApi();

    private ConverteDados converte = new ConverteDados();
    private String ENDERECO = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

    public List<CarroDTO> listarMarcas() {

        try {
            String json = consomeApi.obterApi(ENDERECO);
            List<CarroDTO> listaMarcas = converte.obterDadosListas(json, CarroDTO.class);
            return listaMarcas;

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public List<CarroDTO> listarModelos(String codigo) {
        try {
            String json = consomeApi.obterApi(ENDERECO + "/" + codigo + "/" + "modelos");
            String modelo = "modelos";
            String cotacao = converte.obterJson(json, modelo);
            List<CarroDTO> dados = converte.obterDadosListas(cotacao, CarroDTO.class);
            return dados;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    public List<CarroDTO> listarAnos(String codigo, String codigoModelo) {
        try {
            String json = consomeApi.obterApi(ENDERECO + "/" + codigo + "/modelos/" + codigoModelo + "/anos/");
            List<CarroDTO> listAnos = converte.obterDadosListas(json, CarroDTO.class);
            return listAnos;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public CarroEspecificacaoDTO listarEspecificacoes(String codigo, String codigoModelo, String codigoAno) {
        try {
            String json = consomeApi.obterApi(ENDERECO + "/" + codigo + "/modelos/" + codigoModelo + "/anos/" + codigoAno);
            CarroEspecificacaoDTO dados = converte.obterDados(json, CarroEspecificacaoDTO.class);
            return dados;

        } catch (Exception ex) {
            throw new EntityNotFoundException("Json não encontrado" + ex);
        }
    }
}
