package com.guarderia.guarderia.dto;

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
public class GrupoDTO {

    private Long id;
    private String nombre;
    private Short edadMinima;
    private Short edadMaxima;
    private Integer capacidad;
    private Long profesorId;
}
