package br.edu.utfpr.td.tsi.api.report.controller;

import br.edu.utfpr.td.tsi.api.report.model.Report;
import br.edu.utfpr.td.tsi.api.report.service.SaveService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boletins", produces = "application/json")
public class ReportPostController {

    @Autowired
    private SaveService service;

    @PostMapping
    public ResponseEntity<Report> saveVehicle(@RequestBody @Valid Report report) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(report));
    }
}
