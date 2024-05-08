package com.example.infotech.controllers;

import com.example.infotech.dtos.authentication.AuthenticationDTO;
import com.example.infotech.dtos.authentication.LoginResponseDTO;
import com.example.infotech.dtos.authentication.RegisterDTO;
import com.example.infotech.infra.security.TokenService;
import com.example.infotech.models.User;
import com.example.infotech.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dados){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dados) {
        if (this.repository.findByLogin(dados.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.password());
        User newUser = new User(dados.login(), encryptedPassword, dados.role());
        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
