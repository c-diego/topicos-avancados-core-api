package br.edu.utfpr.td.tsi.api.vehicle.service;

import br.edu.utfpr.td.tsi.api.vehicle.exception.InvalidArgumentException;
import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.vehicle.repository.Repository;

@Component
public class DeleteServiceImpl implements DeleteService {

    @Autowired
    private Repository repository;

    @Override
    public Vehicle delete(String id) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new InvalidArgumentException("veículo não encontrado"));

        repository.delete(vehicle);
        
        return vehicle;

    }
}
