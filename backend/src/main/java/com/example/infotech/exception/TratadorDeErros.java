package com.example.infotech.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityConflictException.class)
    public ResponseEntity<MensagensDeErro> tratarErro409(EntityConflictException ex) {
        MensagensDeErro erroMensagem = new MensagensDeErro(HttpStatus.CONFLICT, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erroMensagem);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MensagensDeErro> tratarErro404(EntityNotFoundException ex) {
        MensagensDeErro erroMensagem = new MensagensDeErro(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroMensagem);
    }
}

