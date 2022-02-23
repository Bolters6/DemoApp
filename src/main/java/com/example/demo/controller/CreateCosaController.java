package com.example.demo.controller;

import com.example.demo.api.CreateApiDelegate;
import com.example.demo.mapper.CosaMapper;
import com.example.demo.model.CosaDTO;
import com.example.demo.repo.CosaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateCosaController implements CreateApiDelegate {

    private final CosaRepo cosaRepo;
    private final CosaMapper cosaMapper;

    @Override
    public ResponseEntity<Void> addCosa(CosaDTO cosaDTO) {
        cosaRepo.save(cosaMapper.cosaDTOToCosa(cosaDTO));
        return ResponseEntity.ok().build();
    }
}
