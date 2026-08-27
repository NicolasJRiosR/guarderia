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

import com.guarderia.guarderia.dto.ProfesorDTO;
import com.guarderia.guarderia.service.ProfesorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @GetMapping
    public List<ProfesorDTO> getAll() {
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> getById(@PathVariable Long id) {
        return profesorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProfesorDTO create(@RequestBody ProfesorDTO dto) {
        return profesorService.save(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profesorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
