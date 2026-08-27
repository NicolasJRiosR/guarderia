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
public class PagoDTO {

      private Long id;
    private Long ninoId;
    private LocalDate fechaPago;
    private Short mes;
    private Integer anio;
    private BigDecimal valor;
    private String estado;
    private String metodoPago;
}
