package com.example.infotech.repositories;

import com.example.infotech.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    Optional<Serie> findByTitulo(String titulo);

}
