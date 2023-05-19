package br.edu.utfpr.td.tsi.api.report.service;

import br.edu.utfpr.td.tsi.api.report.model.Report;

import java.util.List;

public interface ReadService {

    Report findById(String id);

    List<Report> findAll();

    List<Report> findByPeriod(String period);

}
