package com.example.infotech.repositories;

import com.example.infotech.models.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotacaoRepository extends JpaRepository<Cotacao, Long> {
}
