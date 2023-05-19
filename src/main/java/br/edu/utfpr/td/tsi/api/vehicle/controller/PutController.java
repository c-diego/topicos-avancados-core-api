package br.edu.utfpr.td.tsi.api.vehicle.controller;

import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.utfpr.td.tsi.api.vehicle.service.UpdateService;

@RestController
@RequestMapping(value = "/veiculos", produces = "application/json")
public class PutController {

    @Autowired
    private UpdateService service;

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable String id, @RequestBody @Valid Vehicle vehicle) {
        return ResponseEntity.ok(service.update(id, vehicle));
    }
}
