package com.example.infotech.dtos.carro;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeloDTO {
        private List<CarroDTO> modelos;

        public List<CarroDTO> getModelos() {
                return modelos;
        }

}
