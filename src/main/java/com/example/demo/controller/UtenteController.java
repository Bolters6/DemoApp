package com.example.demo.controller;

import DTO.UtenteDTO;
import com.example.demo.mapper.CosaMapper;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.model.Utente;
import com.example.demo.repo.CosaRepo;
import com.example.demo.repo.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/utente")
@RequiredArgsConstructor
public class UtenteController {

    private final UtenteRepo utenteRepo;
    private final UtenteMapper utenteMapper;
    private final CosaRepo cosaRepo;

    @PostMapping(path ="/register")
    public ResponseEntity<Utente> registerUtente(@RequestBody Utente utente){
        return ResponseEntity.ok().body(utenteRepo.save(utente));
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<UtenteDTO> getUtente(@PathVariable Long id){
        return ResponseEntity.ok().body(utenteMapper.utenteToUtenteDTO(utenteRepo.findByIdutente(id)));
}
    @PostMapping(path = "/addcosatouser")
    public ResponseEntity<?> addCosaToUser(@RequestParam Long utenteid, @RequestParam Long cosaid){
        utenteRepo.findByIdutente(utenteid).setCosa(cosaRepo.findByIdcosa(cosaid));
        utenteRepo.save(utenteRepo.findByIdutente(utenteid));
        return ResponseEntity.ok().build();
    }
}
