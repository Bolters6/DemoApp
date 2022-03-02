package com.example.demo.controller;



import com.example.demo.api.RegisterApiDelegate;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.model.UtenteDTO;
import com.example.demo.repo.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterUtenteController implements RegisterApiDelegate {

    private final UtenteMapper utenteMapper;
    private final UtenteRepo utenteRepo;

    @Override
    public ResponseEntity<Void> addUtente(UtenteDTO utenteDTO) {
        utenteRepo.save(utenteMapper.utenteDTOToUtente(utenteDTO));
        return ResponseEntity.ok().build();
    }

}
