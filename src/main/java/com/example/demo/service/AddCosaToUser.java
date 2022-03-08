package com.example.demo.service;

import com.example.demo.api.AddcosatouserApiDelegate;
import com.example.demo.repo.CosaRepo;
import com.example.demo.repo.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddCosaToUser implements AddcosatouserApiDelegate {

    private final UtenteRepo utenteRepo;
    private final CosaRepo cosaRepo;

    @Override
    public ResponseEntity<Void> addCosaToUser(Long utenteid, Long cosaid) {
        utenteRepo.findByIdutente(utenteid).getCosa().add(cosaRepo.findByIdcosa(cosaid));
        utenteRepo.save(utenteRepo.findByIdutente(utenteid));
        return ResponseEntity.ok().build();
    }
}
