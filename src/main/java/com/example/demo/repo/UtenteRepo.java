package com.example.demo.repo;

import com.example.demo.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    Utente findByIdutente(Long id);
    Utente findByUsername(String username);
    boolean existsByUsername(String username);
}
