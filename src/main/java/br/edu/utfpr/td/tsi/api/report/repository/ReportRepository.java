package br.edu.utfpr.td.tsi.api.report.repository;

import br.edu.utfpr.td.tsi.api.report.model.Report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, String> {

    List<Report> findByPeriod(String period);

}
