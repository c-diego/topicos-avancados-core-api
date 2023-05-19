package br.edu.utfpr.td.tsi.api.report.service;

import br.edu.utfpr.td.tsi.api.report.model.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.report.repository.ReportRepository;

@Component
public class ReportSaveServiceImpl implements SaveService {

    @Autowired
    private ReportRepository repository;

    @Override
    public Report save(Report report) {
        report.setPeriod(report.getPeriod().toUpperCase());
        return repository.save(report);
    }
    
}
