package br.edu.utfpr.td.tsi.api.vehicle.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JsonProperty("anoFabricacao")
    @NotNull(message = "{field.required}")
    @Column(nullable = false)
    private int yearManufacture;

    @JsonProperty("cor")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String color;

    @JsonProperty("fabricante")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String brand;

    @JsonProperty("tipoVeiculo")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String type;

    @JsonProperty("modelo")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String model;

    @JsonProperty("emplacamento")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String registration;

}
