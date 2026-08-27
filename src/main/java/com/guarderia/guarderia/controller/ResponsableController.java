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

import com.guarderia.guarderia.dto.ResponsableDTO;
import com.guarderia.guarderia.service.ResponsableService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/responsables")
@RequiredArgsConstructor
public class ResponsableController {

    private final ResponsableService responsableService;

    @GetMapping
    public List<ResponsableDTO> getAll() {
        return responsableService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsableDTO> getById(@PathVariable Long id) {
        return responsableService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponsableDTO create(@RequestBody ResponsableDTO dto) {
        return responsableService.save(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        responsableService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
