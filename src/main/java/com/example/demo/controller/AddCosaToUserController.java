package com.example.demo.controller;

import com.example.demo.api.AddcosatouserApiDelegate;
import com.example.demo.mapper.CosaMapper;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.repo.CosaRepo;
import com.example.demo.repo.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddCosaToUserController implements AddcosatouserApiDelegate {

    private final UtenteRepo utenteRepo;
    private final CosaRepo cosaRepo;

    @Override
    public ResponseEntity<Void> addCosaToUser(Long utenteid, Long cosaid) {
        utenteRepo.findByIdutente(utenteid).setCosa(cosaRepo.findByIdcosa(cosaid));
        utenteRepo.save(utenteRepo.findByIdutente(utenteid));
        return ResponseEntity.ok().build();
    }
}
