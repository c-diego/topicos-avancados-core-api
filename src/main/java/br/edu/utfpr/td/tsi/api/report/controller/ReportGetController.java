package br.edu.utfpr.td.tsi.api.report.controller;

import br.edu.utfpr.td.tsi.api.report.model.Report;
import br.edu.utfpr.td.tsi.api.report.service.ReadService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boletins", produces = "application/json")
public class ReportGetController {

    @Autowired
    private ReadService service;

    @GetMapping
    public ResponseEntity<List<Report>> find(@RequestParam(required = false) String periodo) {

        if (periodo != null) {
            return ResponseEntity.ok(service.findByPeriod(periodo.toUpperCase()));
        }

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> findByLicensePlate(@PathVariable(required = false) String id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
