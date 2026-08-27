package com.guarderia.guarderia.service;

import java.util.List;
import java.util.Optional;

import com.guarderia.guarderia.dto.GrupoDTO;

import org.springframework.stereotype.Service;

import com.guarderia.guarderia.entity.Grupo;
import com.guarderia.guarderia.entity.Profesor;
import com.guarderia.guarderia.repository.GrupoRepository;
import com.guarderia.guarderia.repository.ProfesorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class GrupoService {

   private final GrupoRepository grupoRepository;
    private final ProfesorRepository profesorRepository;

    public List<GrupoDTO> findAll() {
        return grupoRepository.findAll()
                .stream()
                .map(grupo -> GrupoDTO.builder()
                        .id(grupo.getId())
                        .nombre(grupo.getNombre())
                        .edadMinima(grupo.getEdadMinima())
                        .edadMaxima(grupo.getEdadMaxima())
                        .capacidad(grupo.getCapacidad())
                        .profesorId(
                                grupo.getProfesor() != null
                                        ? grupo.getProfesor().getId()
                                        : null
                        )
                        .build())
                .toList();
    }

    public Optional<GrupoDTO> findById(Long id) {
        return grupoRepository.findById(id)
                .map(grupo -> GrupoDTO.builder()
                        .id(grupo.getId())
                        .nombre(grupo.getNombre())
                        .edadMinima(grupo.getEdadMinima())
                        .edadMaxima(grupo.getEdadMaxima())
                        .capacidad(grupo.getCapacidad())
                        .profesorId(
                                grupo.getProfesor() != null
                                        ? grupo.getProfesor().getId()
                                        : null
                        )
                        .build());
    }

    public GrupoDTO save(GrupoDTO dto) {

        Profesor profesor = null;

        if (dto.getProfesorId() != null) {
            profesor = profesorRepository.findById(dto.getProfesorId())
                    .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        }

        Grupo grupo = Grupo.builder()
                .nombre(dto.getNombre())
                .edadMinima(dto.getEdadMinima())
                .edadMaxima(dto.getEdadMaxima())
                .capacidad(dto.getCapacidad())
                .profesor(profesor)
                .build();

        Grupo guardado = grupoRepository.save(grupo);

        return GrupoDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .edadMinima(guardado.getEdadMinima())
                .edadMaxima(guardado.getEdadMaxima())
                .capacidad(guardado.getCapacidad())
                .profesorId(
                        guardado.getProfesor() != null
                                ? guardado.getProfesor().getId()
                                : null
                )
                .build();
    }

    public void deleteById(Long id) {
        grupoRepository.deleteById(id);
    }
}
