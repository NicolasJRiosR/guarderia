package com.guarderia.guarderia.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class NinoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Character sexo;
    private String direccion;
    private String alergias;
    private String observaciones;
    private String foto;
    private Boolean activo;
    private Long grupoId;
    private String grupoNombre;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
