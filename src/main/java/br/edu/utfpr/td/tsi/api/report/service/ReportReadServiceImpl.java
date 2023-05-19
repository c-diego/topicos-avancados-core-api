package br.edu.utfpr.td.tsi.api.report.service;

import br.edu.utfpr.td.tsi.api.report.exception.NotFoundException;
import br.edu.utfpr.td.tsi.api.report.model.Report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.report.repository.ReportRepository;

@Component
public class ReportReadServiceImpl implements ReadService {

    @Autowired
    private ReportRepository repository;

    @Override
    public Report findById(String id) {
        return validadeReportOrThrowException(repository.findById(id).orElse(null));
    }

    @Override
    public List<Report> findAll() {
        return validadeListOrThrowException(repository.findAll());
    }

    @Override
    public List<Report> findByPeriod(String period) {
        return validadeListOrThrowException(repository.findByPeriod(period));
    }

    private List<Report> validadeListOrThrowException(List<Report> report) {

        if (report == null || report.isEmpty()) {
            throw new NotFoundException("Nenhum boletim encontrado");
        }

        return report;
    }

    private Report validadeReportOrThrowException(Report report) {

        if (report == null) {
            throw new NotFoundException("Boletim não encontrado");
        }

        return report;
    }

}
