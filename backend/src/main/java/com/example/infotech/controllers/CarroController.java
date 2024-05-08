package com.example.infotech.controllers;

import com.example.infotech.dtos.carro.CarroDTO;
import com.example.infotech.dtos.carro.CarroEspecificacaoDTO;
import com.example.infotech.infra.service.CarroService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    CarroService service = new CarroService();

    @GetMapping
    public ResponseEntity<List<CarroDTO>> listarMarcas() {
        List<CarroDTO> dados = service.listarMarcas();
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping("/modelo")
    public ResponseEntity<List<CarroDTO>> listarModelos(@RequestParam String codigo, HttpSession session) {
        session.setAttribute("codigo", codigo);
        List<CarroDTO> dados = service.listarModelos(codigo);
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping("/anos")
    public ResponseEntity<List<CarroDTO>> listarAnos(@SessionAttribute String codigo, String codigoModelo, HttpSession session) {
        session.setAttribute("codigoModelo", codigoModelo);
        List<CarroDTO> dados = service.listarAnos(codigo, codigoModelo);
        return ResponseEntity.ok().body(dados);
    }

    @GetMapping("/especificacao")
    public ResponseEntity<CarroEspecificacaoDTO> listarEspecificacoes(@SessionAttribute String codigo, @SessionAttribute String codigoModelo, @RequestParam String codigoAno) {
        CarroEspecificacaoDTO dados = service.listarEspecificacoes(codigo, codigoModelo, codigoAno);
        return ResponseEntity.ok().body(dados);
    }
}
