package br.edu.utfpr.td.tsi.api.report.controller;

import br.edu.utfpr.td.tsi.api.report.model.Report;
import br.edu.utfpr.td.tsi.api.report.service.DeleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boletins", produces = "application/json")
public class ReportDeleteController {

    @Autowired
    private DeleteService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Report> deleteVehicle(@PathVariable String id) {
        return ResponseEntity.ok(service.delete(id));
    }
    
}
