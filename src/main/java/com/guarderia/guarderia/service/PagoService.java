package com.guarderia.guarderia.service;

import com.guarderia.guarderia.dto.PagoDTO;
import com.guarderia.guarderia.entity.Nino;
import com.guarderia.guarderia.entity.Pago;
import com.guarderia.guarderia.repository.NinoRepository;
import com.guarderia.guarderia.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;
    private final NinoRepository ninoRepository;

    public List<PagoDTO> findAll() {
        return pagoRepository.findAll()
                .stream()
                .map(pago -> PagoDTO.builder()
                        .id(pago.getId())
                        .ninoId(pago.getNino().getId())
                        .fechaPago(pago.getFechaPago())
                        .mes(pago.getMes())
                        .anio(pago.getAnio())
                        .valor(pago.getValor())
                        .estado(pago.getEstado())
                        .metodoPago(pago.getMetodoPago())
                        .build())
                .toList();
    }

    public Optional<PagoDTO> findById(Long id) {
        return pagoRepository.findById(id)
                .map(pago -> PagoDTO.builder()
                        .id(pago.getId())
                        .ninoId(pago.getNino().getId())
                        .fechaPago(pago.getFechaPago())
                        .mes(pago.getMes())
                        .anio(pago.getAnio())
                        .valor(pago.getValor())
                        .estado(pago.getEstado())
                        .metodoPago(pago.getMetodoPago())
                        .build());
    }

    public PagoDTO save(PagoDTO dto) {

        Nino nino = ninoRepository.findById(dto.getNinoId())
                .orElseThrow(() ->
                        new RuntimeException("Niño no encontrado"));

        Pago pago = Pago.builder()
                .nino(nino)
                .fechaPago(dto.getFechaPago())
                .mes(dto.getMes())
                .anio(dto.getAnio())
                .valor(dto.getValor())
                .estado(dto.getEstado())
                .metodoPago(dto.getMetodoPago())
                .build();

        Pago guardado = pagoRepository.save(pago);

        return PagoDTO.builder()
                .id(guardado.getId())
                .ninoId(guardado.getNino().getId())
                .fechaPago(guardado.getFechaPago())
                .mes(guardado.getMes())
                .anio(guardado.getAnio())
                .valor(guardado.getValor())
                .estado(guardado.getEstado())
                .metodoPago(guardado.getMetodoPago())
                .build();
    }

    public void deleteById(Long id) {
        pagoRepository.deleteById(id);
    }
}