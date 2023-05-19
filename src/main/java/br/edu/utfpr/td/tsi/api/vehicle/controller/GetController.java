package br.edu.utfpr.td.tsi.api.vehicle.controller;

import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.edu.utfpr.td.tsi.api.vehicle.service.ReadService;

@RestController
@RequestMapping(value = "/veiculos", produces = "application/json")
public class GetController {

    @Autowired
    private ReadService service;

    @GetMapping
    public ResponseEntity<?> find(@RequestParam(required = false) String emplacamento, @RequestParam(required = false) String cor, @RequestParam(required = false) String tipoVeiculo) {

        if (emplacamento != null)
            return ResponseEntity.ok(service.findByRegistration(emplacamento));
        
        if (cor != null && tipoVeiculo != null) {
            return ResponseEntity.ok(service.findByColorAndType(cor, tipoVeiculo));

        } else if (tipoVeiculo != null) {
            return ResponseEntity.ok(service.findByType(tipoVeiculo));

        } else if (cor != null) {
            return ResponseEntity.ok(service.findByColor(cor));

        }

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findByLicensePlate(@PathVariable(required = false) String id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
