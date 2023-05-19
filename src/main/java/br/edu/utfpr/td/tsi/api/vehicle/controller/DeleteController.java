package br.edu.utfpr.td.tsi.api.vehicle.controller;

import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.utfpr.td.tsi.api.vehicle.service.DeleteService;

@RestController
@RequestMapping(value = "/veiculos", produces = "application/json")
public class DeleteController {

    @Autowired
    private DeleteService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable String id) {
        return ResponseEntity.ok(service.delete(id));
    }
    
}
