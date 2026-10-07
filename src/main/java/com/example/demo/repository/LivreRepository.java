package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {

}

