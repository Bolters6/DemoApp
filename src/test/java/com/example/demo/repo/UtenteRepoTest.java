package com.example.demo.repo;

import com.example.demo.model.Utente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UtenteRepoTest {

    @Autowired
    private UtenteRepo utenteRepo;

    @Test
    void existsByUsername() {
        //given
        Utente utente = new Utente(null,"Mario", "Pontillo",
                "Chukiao", "hola123", "chukiao@gmail.com", null);
        utenteRepo.save(utente);
        //when
        boolean expected = utenteRepo.existsByUsername("Chukiao");
        //then
        assertThat(expected).isTrue();
    }
}