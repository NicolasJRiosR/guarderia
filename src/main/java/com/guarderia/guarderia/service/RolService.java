package com.guarderia.guarderia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guarderia.guarderia.dto.RolDTO;
import com.guarderia.guarderia.entity.Rol;
import com.guarderia.guarderia.repository.RolRepository;

@Service
public class RolService {

    private final RolRepository rolRepository;


     public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<RolDTO> findAll() {
        return rolRepository.findAll()
                .stream()
                .map(rol -> RolDTO.builder()
                        .id(rol.getId())
                        .nombre(rol.getNombre())
                        .build())
                .toList();
    }

    public Optional<RolDTO> findById(Long id) {
        return rolRepository.findById(id)
                .map(rol -> RolDTO.builder()
                        .id(rol.getId())
                        .nombre(rol.getNombre())
                        .build());
    }

    public RolDTO save(RolDTO dto) {

        Rol rol = Rol.builder()
                .nombre(dto.getNombre())
                .build();

        Rol guardado = rolRepository.save(rol);

        return RolDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .build();
    }

    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }
}
