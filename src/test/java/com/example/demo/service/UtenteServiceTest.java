package com.example.demo.service;

import com.example.demo.mapper.CosaMapper;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.model.Utente;
import com.example.demo.model.UtenteDTO;
import com.example.demo.repo.CosaRepo;
import com.example.demo.repo.UtenteRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UtenteServiceTest {

    @Mock
    private UtenteRepo utenteRepo;
    @Mock
    private UtenteMapper utenteMapper;
    @Mock
    private CosaRepo cosaRepo;
    @Mock
    private CosaMapper cosaMapper;
    private UtenteService utenteService;

    @BeforeEach
    void setUp() {
        utenteService = new UtenteService(utenteRepo, utenteMapper, cosaRepo, cosaMapper);
    }

    @Test
    void getUtenteProva1() {
        //given
        Long id = 1L;
        given(utenteRepo.findByIdutente(id)).willReturn(new Utente(null,"Mario", "Pontillo",
                "Chukiao", "hola123", "chukiao@gmail.com", null));

        //when
        UtenteDTO expected = utenteService.getUtente(id).getBody();
        //then
        assertThat(expected).isEqualTo(utenteMapper.utenteToUtenteDTO(utenteRepo.findByIdutente(id)));
    }
    @Test
    void getUtenteProva2() {
        //given
        Long id = 1L;
        //when
        utenteService.getUtente(id);
        //then
        ArgumentCaptor<Long> idargumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(utenteMapper).utenteToUtenteDTO(utenteRepo.findByIdutente(idargumentCaptor.capture()));
    }

}