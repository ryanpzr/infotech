package com.example.infotech.infra.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> obterDadosListas(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, classe));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON list: " + e.getMessage());
        }
    }

    public String obterJson(String json, String modelo) throws JsonProcessingException {
        JsonNode rootNode = mapper.readTree(json);
        JsonNode cotacaoNode = rootNode.get(modelo);
        String cotacaoJson = cotacaoNode.toString();
        return cotacaoJson;
    }


}
