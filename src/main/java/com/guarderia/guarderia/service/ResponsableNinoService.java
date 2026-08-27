package com.guarderia.guarderia.service;

import com.guarderia.guarderia.dto.ResponsableNinoDTO;
import com.guarderia.guarderia.entity.Nino;
import com.guarderia.guarderia.entity.Responsable;
import com.guarderia.guarderia.entity.ResponsableNino;
import com.guarderia.guarderia.entity.ResponsableNinoId;
import com.guarderia.guarderia.repository.NinoRepository;
import com.guarderia.guarderia.repository.ResponsableNinoRepository;
import com.guarderia.guarderia.repository.ResponsableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponsableNinoService {

    private final ResponsableNinoRepository responsableNinoRepository;
    private final ResponsableRepository responsableRepository;
    private final NinoRepository ninoRepository;

    public List<ResponsableNinoDTO> findAll() {
        return responsableNinoRepository.findAll()
                .stream()
                .map(relacion -> ResponsableNinoDTO.builder()
                        .responsableId(relacion.getResponsable().getId())
                        .ninoId(relacion.getNino().getId())
                        .parentesco(relacion.getParentesco())
                        .build())
                .toList();
    }

    public Optional<ResponsableNinoDTO> findById(
            ResponsableNinoId id) {

        return responsableNinoRepository.findById(id)
                .map(relacion -> ResponsableNinoDTO.builder()
                        .responsableId(relacion.getResponsable().getId())
                        .ninoId(relacion.getNino().getId())
                        .parentesco(relacion.getParentesco())
                        .build());
    }

    public ResponsableNinoDTO save(ResponsableNinoDTO dto) {

        Responsable responsable = responsableRepository
                .findById(dto.getResponsableId())
                .orElseThrow(() ->
                        new RuntimeException("Responsable no encontrado"));

        Nino nino = ninoRepository
                .findById(dto.getNinoId())
                .orElseThrow(() ->
                        new RuntimeException("Niño no encontrado"));

        ResponsableNinoId id = new ResponsableNinoId(
                responsable.getId(),
                nino.getId()
        );

        ResponsableNino relacion = ResponsableNino.builder()
                .id(id)
                .responsable(responsable)
                .nino(nino)
                .parentesco(dto.getParentesco())
                .build();

        ResponsableNino guardado =
                responsableNinoRepository.save(relacion);

        return ResponsableNinoDTO.builder()
                .responsableId(guardado.getResponsable().getId())
                .ninoId(guardado.getNino().getId())
                .parentesco(guardado.getParentesco())
                .build();
    }

    public void deleteById(ResponsableNinoId id) {
        responsableNinoRepository.deleteById(id);
    }
}