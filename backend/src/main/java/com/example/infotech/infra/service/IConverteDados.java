package com.example.infotech.infra.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
