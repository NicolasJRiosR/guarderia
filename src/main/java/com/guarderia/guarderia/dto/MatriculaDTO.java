package com.guarderia.guarderia.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatriculaDTO {

    private Long id;
    private Long ninoId;
    private LocalDate fecha;
    private String estado;
    private BigDecimal valor;
}
