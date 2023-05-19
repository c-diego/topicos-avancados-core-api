package br.edu.utfpr.td.tsi.api.report.service;

import br.edu.utfpr.td.tsi.api.report.model.Report;
import br.edu.utfpr.td.tsi.api.report.exception.InvalidArgumentException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.report.repository.ReportRepository;

@Component
public class ReportDeleteServiceImpl implements DeleteService {

    @Autowired
    private ReportRepository repository;

    @Override
    public Report delete(String id) {

        Report report = repository.findById(id)
                .orElseThrow(() -> new InvalidArgumentException("Boletim não encontrado"));

        repository.delete(report);
        
        return report;

    }
}
