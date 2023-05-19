package br.edu.utfpr.td.tsi.api.vehicle.controller;

import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.utfpr.td.tsi.api.vehicle.service.SaveService;

@RestController
@RequestMapping(value = "/veiculos", produces = "application/json")
public class PostController {

    @Autowired
    private SaveService service;

    @PostMapping
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody @Valid Vehicle vehicle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(vehicle));
    }
}
