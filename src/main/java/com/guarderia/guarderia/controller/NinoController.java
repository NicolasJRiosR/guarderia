package com.guarderia.guarderia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guarderia.guarderia.dto.NinoDTO;
import com.guarderia.guarderia.service.NinoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ninos")
@RequiredArgsConstructor
public class NinoController {

    private final NinoService ninoService;

    @GetMapping
    public List<NinoDTO> getAll() {
        return ninoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinoDTO> getById(@PathVariable Long id) {
        return ninoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NinoDTO create(@RequestBody NinoDTO dto) {
        return ninoService.save(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ninoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
