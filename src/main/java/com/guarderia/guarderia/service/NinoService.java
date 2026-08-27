package com.guarderia.guarderia.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guarderia.guarderia.dto.NinoDTO;
import com.guarderia.guarderia.entity.Grupo;
import com.guarderia.guarderia.entity.Nino;
import com.guarderia.guarderia.repository.GrupoRepository;
import com.guarderia.guarderia.repository.NinoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NinoService {

    private final NinoRepository ninoRepository;
    private final GrupoRepository grupoRepository;

    public List<NinoDTO> findAll() {
        return ninoRepository.findAll()
                .stream()
                .map(nino -> NinoDTO.builder()
                        .id(nino.getId())
                        .nombre(nino.getNombre())
                        .apellido(nino.getApellido())
                        .fechaNacimiento(nino.getFechaNacimiento())
                        .sexo(nino.getSexo())
                        .direccion(nino.getDireccion())
                        .alergias(nino.getAlergias())
                        .observaciones(nino.getObservaciones())
                        .foto(nino.getFoto())
                        .activo(nino.getActivo())
                        .grupoId(
                                nino.getGrupo() != null
                                        ? nino.getGrupo().getId()
                                        : null
                        )
                        .grupoNombre(
                                nino.getGrupo() != null
                                        ? nino.getGrupo().getNombre()
                                        : null
                        )
                        .createdAt(nino.getCreatedAt())
                        .updatedAt(nino.getUpdatedAt())
                        .build())
                .toList();
    }

    public Optional<NinoDTO> findById(Long id) {
        return ninoRepository.findById(id)
                .map(nino -> NinoDTO.builder()
                        .id(nino.getId())
                        .nombre(nino.getNombre())
                        .apellido(nino.getApellido())
                        .fechaNacimiento(nino.getFechaNacimiento())
                        .sexo(nino.getSexo())
                        .direccion(nino.getDireccion())
                        .alergias(nino.getAlergias())
                        .observaciones(nino.getObservaciones())
                        .foto(nino.getFoto())
                        .activo(nino.getActivo())
                        .grupoId(
                                nino.getGrupo() != null
                                        ? nino.getGrupo().getId()
                                        : null
                        )
                        .grupoNombre(
                                nino.getGrupo() != null
                                        ? nino.getGrupo().getNombre()
                                        : null
                        )
                        .createdAt(nino.getCreatedAt())
                        .updatedAt(nino.getUpdatedAt())
                        .build());
    }

    public NinoDTO save(NinoDTO dto) {

        Grupo grupo = null;

        if (dto.getGrupoId() != null) {
            grupo = grupoRepository.findById(dto.getGrupoId())
                    .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
        }

        LocalDateTime ahora = LocalDateTime.now();

        Nino nino = Nino.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .fechaNacimiento(dto.getFechaNacimiento())
                .sexo(dto.getSexo())
                .direccion(dto.getDireccion())
                .alergias(dto.getAlergias())
                .observaciones(dto.getObservaciones())
                .foto(dto.getFoto())
                .activo(dto.getActivo() != null ? dto.getActivo() : true)
                .grupo(grupo)
                .createdAt(ahora)
                .updatedAt(ahora)
                .build();

        Nino guardado = ninoRepository.save(nino);

        return NinoDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .apellido(guardado.getApellido())
                .fechaNacimiento(guardado.getFechaNacimiento())
                .sexo(guardado.getSexo())
                .direccion(guardado.getDireccion())
                .alergias(guardado.getAlergias())
                .observaciones(guardado.getObservaciones())
                .foto(guardado.getFoto())
                .activo(guardado.getActivo())
                .grupoId(
                        guardado.getGrupo() != null
                                ? guardado.getGrupo().getId()
                                : null
                )
                .grupoNombre(
                        guardado.getGrupo() != null
                                ? guardado.getGrupo().getNombre()
                                : null
                )
                .createdAt(guardado.getCreatedAt())
                .updatedAt(guardado.getUpdatedAt())
                .build();
    }

    public void deleteById(Long id) {
        ninoRepository.deleteById(id);
    }
}