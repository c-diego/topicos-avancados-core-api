package br.edu.utfpr.td.tsi.api.report.service;

import br.edu.utfpr.td.tsi.api.report.exception.InvalidArgumentException;
import br.edu.utfpr.td.tsi.api.report.model.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.report.repository.ReportRepository;

@Component
public class ReportUpdateServiceImpl implements UpdateService {

    @Autowired
    private ReportRepository repository;

    @Override
    public Report update(String id, Report updatedReport) {

        Report report = repository.findById(id)
                .orElseThrow(() -> new InvalidArgumentException("Boletim não encontrado para o ID: " + id));

        report = setAttributes(report, updatedReport);

        return repository.save(report);
    }

    private Report setAttributes(Report old, Report updated) {

        old.setAddress(updated.getAddress());
        old.setDate(updated.getDate());
        old.setPeriod(updated.getPeriod().toUpperCase());
        old.setParts(updated.getParts());
        old.setVehicle(updated.getVehicle());

        return old;
    }

}
