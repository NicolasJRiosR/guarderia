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

import com.guarderia.guarderia.dto.ResponsableNinoDTO;
import com.guarderia.guarderia.entity.ResponsableNinoId;
import com.guarderia.guarderia.service.ResponsableNinoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/responsables-ninos")
@RequiredArgsConstructor
public class ResponsableNinoController {

    private final ResponsableNinoService responsableNinoService;

    @GetMapping
    public List<ResponsableNinoDTO> getAll() {
        return responsableNinoService.findAll();
    }

    @GetMapping("/{responsableId}/{ninoId}")
    public ResponseEntity<ResponsableNinoDTO> getById(
            @PathVariable Long responsableId,
            @PathVariable Long ninoId) {
        ResponsableNinoId id = new ResponsableNinoId(responsableId, ninoId);
        return responsableNinoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponsableNinoDTO create(@RequestBody ResponsableNinoDTO dto) {
        return responsableNinoService.save(dto);
    }

    @DeleteMapping("/{responsableId}/{ninoId}")
    public ResponseEntity<Void> delete(
            @PathVariable Long responsableId,
            @PathVariable Long ninoId) {
        responsableNinoService.deleteById(new ResponsableNinoId(responsableId, ninoId));
        return ResponseEntity.noContent().build();
    }
}
