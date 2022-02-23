package com.example.demo.controller;

import com.example.demo.api.GetApiDelegate;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.model.UtenteDTO;
import com.example.demo.repo.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUtenteController implements GetApiDelegate {

    private final UtenteMapper utenteMapper;
    private final UtenteRepo utenteRepo;

    @Override
    public ResponseEntity<UtenteDTO> getUtente(Long id) {
        return ResponseEntity.ok().body(utenteMapper.utenteToUtenteDTO(utenteRepo.findByIdutente(id)));
    }
}
