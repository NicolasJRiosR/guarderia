package com.guarderia.guarderia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
@Entity
@Table(name = "responsables_ninos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsableNino {

    @EmbeddedId
    private ResponsableNinoId id;

    @ManyToOne
    @MapsId("responsableId")
    @JoinColumn(name = "responsable_id")
    private Responsable responsable;

    @ManyToOne
    @MapsId("ninoId")
    @JoinColumn(name = "nino_id")
    private Nino nino;

    @Column(nullable = false, length = 50)
    private String parentesco;
}