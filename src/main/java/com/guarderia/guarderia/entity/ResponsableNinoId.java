package com.guarderia.guarderia.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsableNinoId implements Serializable {

    private Long responsableId;
    private Long ninoId;
}