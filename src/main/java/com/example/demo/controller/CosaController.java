package com.example.demo.controller;

import DTO.CosaDTO;
import com.example.demo.mapper.CosaMapper;
import com.example.demo.model.Cosa;
import com.example.demo.repo.CosaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/cosa")
@RequiredArgsConstructor
public class CosaController {

    private final CosaRepo cosaRepo;
    private final CosaMapper cosaMapper;

    @PostMapping(path = "/register")
    public ResponseEntity<Cosa> registerCosa(@RequestBody Cosa cosa){
        return ResponseEntity.ok().body(cosaRepo.save(cosa));
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<CosaDTO> getCosa(@PathVariable Long id){
        return ResponseEntity.ok().body(cosaMapper.cosaToCosaDTO(cosaRepo.findByIdcosa(id)));
    }
}
