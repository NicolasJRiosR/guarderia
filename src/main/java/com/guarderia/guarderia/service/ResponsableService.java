package com.guarderia.guarderia.service;

import java.util.List;
import java.util.Optional;

import com.guarderia.guarderia.dto.ResponsableDTO;
import com.guarderia.guarderia.entity.Responsable;
import com.guarderia.guarderia.repository.ResponsableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponsableService {

    private final ResponsableRepository responsableRepository;

    public List<ResponsableDTO> findAll() {
        return responsableRepository.findAll()
                .stream()
                .map(responsable -> ResponsableDTO.builder()
                        .id(responsable.getId())
                        .nombre(responsable.getNombre())
                        .apellido(responsable.getApellido())
                        .documento(responsable.getDocumento())
                        .telefono(responsable.getTelefono())
                        .correo(responsable.getCorreo())
                        .direccion(responsable.getDireccion())
                        .build())
                .toList();
    }

    public Optional<ResponsableDTO> findById(Long id) {
        return responsableRepository.findById(id)
                .map(responsable -> ResponsableDTO.builder()
                        .id(responsable.getId())
                        .nombre(responsable.getNombre())
                        .apellido(responsable.getApellido())
                        .documento(responsable.getDocumento())
                        .telefono(responsable.getTelefono())
                        .correo(responsable.getCorreo())
                        .direccion(responsable.getDireccion())
                        .build());
    }

    public ResponsableDTO save(ResponsableDTO dto) {

        Responsable responsable = Responsable.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .documento(dto.getDocumento())
                .telefono(dto.getTelefono())
                .correo(dto.getCorreo())
                .direccion(dto.getDireccion())
                .build();

        Responsable guardado = responsableRepository.save(responsable);

        return ResponsableDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .apellido(guardado.getApellido())
                .documento(guardado.getDocumento())
                .telefono(guardado.getTelefono())
                .correo(guardado.getCorreo())
                .direccion(guardado.getDireccion())
                .build();
    }

    public void deleteById(Long id) {
        responsableRepository.deleteById(id);
    }
}