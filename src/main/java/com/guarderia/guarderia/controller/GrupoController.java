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

import com.guarderia.guarderia.dto.GrupoDTO;
import com.guarderia.guarderia.service.GrupoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
public class GrupoController {

    private final GrupoService grupoService;

    @GetMapping
    public List<GrupoDTO> getAll() {
        return grupoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoDTO> getById(@PathVariable Long id) {
        return grupoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GrupoDTO create(@RequestBody GrupoDTO dto) {
        return grupoService.save(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        grupoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
