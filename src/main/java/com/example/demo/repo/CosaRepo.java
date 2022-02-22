package com.example.demo.repo;

import com.example.demo.model.Cosa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CosaRepo extends JpaRepository<Cosa, Long> {
    Cosa findByIdcosa(Long id);
}
