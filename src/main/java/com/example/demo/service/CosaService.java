package com.example.demo.service;

import com.example.demo.api.CosaApiDelegate;
import com.example.demo.mapper.CosaMapper;
import com.example.demo.model.CosaDTO;
import com.example.demo.repo.CosaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CosaService implements CosaApiDelegate {

    private final CosaRepo cosaRepo;
    private final CosaMapper cosaMapper;

    @Override
    public ResponseEntity<Void> addCosa(CosaDTO cosaDTO) {
        cosaRepo.save(cosaMapper.cosaDTOToCosa(cosaDTO));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CosaDTO> getCosa(Long id) {
        return ResponseEntity.ok().body(cosaMapper.cosaToCosaDTO(cosaRepo.findByIdcosa(id)));
    }

    @Override
    public ResponseEntity<Void> deleteCosa(Long cosaid) {
        cosaRepo.deleteById(cosaid);
       return ResponseEntity.ok().build();
    }
}
