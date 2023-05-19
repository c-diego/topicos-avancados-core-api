package br.edu.utfpr.td.tsi.api.report.controller;

import br.edu.utfpr.td.tsi.api.report.service.UpdateService;
import br.edu.utfpr.td.tsi.api.report.model.Report;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boletins", produces = "application/json")
public class ReportPutController {

    @Autowired
    private UpdateService service;

    @PutMapping("/{id}")
    public ResponseEntity<Report> updateVehicle(@PathVariable String id, @RequestBody @Valid Report report) {
        return ResponseEntity.ok(service.update(id, report));
    }
}
