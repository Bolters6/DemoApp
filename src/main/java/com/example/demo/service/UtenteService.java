package com.example.demo.service;

import com.example.demo.api.UtenteApiDelegate;
import com.example.demo.mapper.CosaMapper;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.model.Cosa;
import com.example.demo.model.Utente;
import com.example.demo.model.UtenteDTO;
import com.example.demo.repo.CosaRepo;
import com.example.demo.repo.UtenteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UtenteService implements UtenteApiDelegate {

    private final UtenteRepo utenteRepo;
    private final UtenteMapper utenteMapper;
    /*private final CosaRepo cosaRepo;
    private final CosaMapper cosaMapper;*/

    @Override
    public ResponseEntity<Void> addUtente(UtenteDTO utenteDTO) {
       /* List<Cosa> cose = new ArrayList<>();
        utenteDTO.getCosaDTO().forEach(cosa -> {
            cose.add(cosaMapper.cosaDTOToCosa(cosa));
        });*/
        Utente utente = utenteMapper.utenteDTOToUtente(utenteDTO);
        //System.out.println(utente.toString());
        //utente.setCosa(cose);
        utenteRepo.save(utente);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UtenteDTO> getUtente(Long id) {
        return ResponseEntity.ok().body(utenteMapper.utenteToUtenteDTO(utenteRepo.findByIdutente(id)));
    }

    @Override
    public ResponseEntity<Void> deleteUtente(Long utenteid) {
        utenteRepo.deleteById(utenteid);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateUtente(UtenteDTO utenteDTO) {
        return ResponseEntity.ok().build();
    }
}
