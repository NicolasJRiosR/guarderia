package com.guarderia.guarderia.service;

import com.guarderia.guarderia.dto.MatriculaDTO;
import com.guarderia.guarderia.entity.Matricula;
import com.guarderia.guarderia.entity.Nino;
import com.guarderia.guarderia.repository.MatriculaRepository;
import com.guarderia.guarderia.repository.NinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final NinoRepository ninoRepository;

    public List<MatriculaDTO> findAll() {
        return matriculaRepository.findAll()
                .stream()
                .map(matricula -> MatriculaDTO.builder()
                        .id(matricula.getId())
                        .ninoId(matricula.getNino().getId())
                        .fecha(matricula.getFecha())
                        .estado(matricula.getEstado())
                        .valor(matricula.getValor())
                        .build())
                .toList();
    }

    public Optional<MatriculaDTO> findById(Long id) {
        return matriculaRepository.findById(id)
                .map(matricula -> MatriculaDTO.builder()
                        .id(matricula.getId())
                        .ninoId(matricula.getNino().getId())
                        .fecha(matricula.getFecha())
                        .estado(matricula.getEstado())
                        .valor(matricula.getValor())
                        .build());
    }

    public MatriculaDTO save(MatriculaDTO dto) {

        Nino nino = ninoRepository.findById(dto.getNinoId())
                .orElseThrow(() ->
                        new RuntimeException("Niño no encontrado"));

        Matricula matricula = Matricula.builder()
                .nino(nino)
                .fecha(dto.getFecha())
                .estado(dto.getEstado())
                .valor(dto.getValor())
                .build();

        Matricula guardada = matriculaRepository.save(matricula);

        return MatriculaDTO.builder()
                .id(guardada.getId())
                .ninoId(guardada.getNino().getId())
                .fecha(guardada.getFecha())
                .estado(guardada.getEstado())
                .valor(guardada.getValor())
                .build();
    }

    public void deleteById(Long id) {
        matriculaRepository.deleteById(id);
    }
}