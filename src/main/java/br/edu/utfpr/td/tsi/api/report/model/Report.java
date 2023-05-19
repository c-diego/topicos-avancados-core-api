package br.edu.utfpr.td.tsi.api.report.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JsonProperty("dataOcorrencia")
    @NotNull(message = "{field.required}")
    @Column(nullable = false)
    private String date;

    @JsonProperty("periodoOcorrencia")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String period;

    @JsonProperty("partes")
    @Column(nullable = true)
    private String[] parts;

    @JsonProperty("localOcorrencia")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String address;

    @JsonProperty("veiculoFurtado")
    @NotEmpty(message = "{field.required}")
    @Column(nullable = false)
    private String vehicle;

}
