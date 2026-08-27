package com.guarderia.guarderia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guarderia.guarderia.dto.ProfesorDTO;
import com.guarderia.guarderia.entity.Profesor;
import com.guarderia.guarderia.repository.ProfesorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfesorService {
    private final ProfesorRepository profesorRepository;

    public List<ProfesorDTO> findAll() {
        return profesorRepository.findAll()
                .stream()
                .map(profesor -> ProfesorDTO.builder()
                        .id(profesor.getId())
                        .nombre(profesor.getNombre())
                        .apellido(profesor.getApellido())
                        .documento(profesor.getDocumento())
                        .telefono(profesor.getTelefono())
                        .correo(profesor.getCorreo())
                        .especialidad(profesor.getEspecialidad())
                        .activo(profesor.getActivo())
                        .build())
                .toList();
    }

    public Optional<ProfesorDTO> findById(Long id) {
        return profesorRepository.findById(id)
                .map(profesor -> ProfesorDTO.builder()
                        .id(profesor.getId())
                        .nombre(profesor.getNombre())
                        .apellido(profesor.getApellido())
                        .documento(profesor.getDocumento())
                        .telefono(profesor.getTelefono())
                        .correo(profesor.getCorreo())
                        .especialidad(profesor.getEspecialidad())
                        .activo(profesor.getActivo())
                        .build());
    }

    public ProfesorDTO save(ProfesorDTO dto) {

        Profesor profesor = Profesor.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .documento(dto.getDocumento())
                .telefono(dto.getTelefono())
                .correo(dto.getCorreo())
                .especialidad(dto.getEspecialidad())
                .activo(dto.getActivo())
                .build();

        Profesor guardado = profesorRepository.save(profesor);

        return ProfesorDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .apellido(guardado.getApellido())
                .documento(guardado.getDocumento())
                .telefono(guardado.getTelefono())
                .correo(guardado.getCorreo())
                .especialidad(guardado.getEspecialidad())
                .activo(guardado.getActivo())
                .build();
    }

    public void deleteById(Long id) {
        profesorRepository.deleteById(id);
    }
}
