package com.guarderia.guarderia.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nino_id", nullable = false)
    private Nino nino;

    @Column(name = "fecha_pago")
    private LocalDate fechaPago;

    @Column(nullable = false)
    private Short mes;

    @Column(nullable = false)
    private Integer anio;

    @Column(precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(length = 20)
    private String estado;

    @Column(name = "metodo_pago", length = 30)
    private String metodoPago;
}