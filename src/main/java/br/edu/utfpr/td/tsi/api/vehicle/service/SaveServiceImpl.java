package br.edu.utfpr.td.tsi.api.vehicle.service;

import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.vehicle.repository.Repository;

@Component
public class SaveServiceImpl implements SaveService {

    @Autowired
    private Repository repository;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return repository.save(toUpperCase(vehicle));
    }
    
    private Vehicle toUpperCase(Vehicle vehicle) {
        
        vehicle.setBrand(vehicle.getBrand().toUpperCase());
        vehicle.setColor(vehicle.getColor().toUpperCase());
        vehicle.setModel(vehicle.getModel().toUpperCase());
        vehicle.setType(vehicle.getType().toUpperCase());
        
        return vehicle;
    }

}
