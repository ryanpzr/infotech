package com.example.infotech.repositories;

import com.example.infotech.models.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CepRepository extends JpaRepository<Cep, Long> {
    Optional<Cep> findByRua(String rua);
}
