package com.guarderia.guarderia.entity;

import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "responsables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Responsable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 30, unique = true)
    private String documento;

    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(length = 150, unique = true)
    private String correo;

    @Column(length = 250)
    private String direccion;
}