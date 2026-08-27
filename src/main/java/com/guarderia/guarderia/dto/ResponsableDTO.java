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
public class ResponsableDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String correo;
    private String direccion;
}
