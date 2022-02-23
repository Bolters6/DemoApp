package com.example.demo.controller;

import com.example.demo.api.GetcosaApiDelegate;
import com.example.demo.mapper.CosaMapper;
import com.example.demo.model.CosaDTO;
import com.example.demo.repo.CosaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetCosaController implements GetcosaApiDelegate {

    private final CosaRepo cosaRepo;
    private final CosaMapper cosaMapper;

    @Override
    public ResponseEntity<CosaDTO> getCosa(Long id) {
       return ResponseEntity.ok().body(cosaMapper.cosaToCosaDTO(cosaRepo.findByIdcosa(id)));
    }
}
