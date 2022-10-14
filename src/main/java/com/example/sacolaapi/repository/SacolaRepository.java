package com.example.sacolaapi.repository;

import com.example.sacolaapi.model.Sacola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SacolaRepository extends JpaRepository<Sacola, Long> {
}
