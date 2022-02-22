package com.example.demo.repo;

import com.example.demo.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Utente findByIdutente(Long id);
}
