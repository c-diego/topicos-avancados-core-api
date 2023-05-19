package br.edu.utfpr.td.tsi.api.report.service;

import br.edu.utfpr.td.tsi.api.report.model.Report;

public interface UpdateService {
    
    Report update(String id, Report report);
    
}
