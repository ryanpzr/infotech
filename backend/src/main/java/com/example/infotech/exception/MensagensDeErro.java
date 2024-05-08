package com.example.infotech.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
public class MensagensDeErro {

    private HttpStatus status;
    private String mensagem;

}
