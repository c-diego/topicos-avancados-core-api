package br.edu.utfpr.td.tsi.api.vehicle.service;

import br.edu.utfpr.td.tsi.api.vehicle.exception.InvalidArgumentException;
import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.vehicle.repository.Repository;

@Component
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private Repository repository;

    @Override
    public Vehicle update(String id, Vehicle updatedVehicle) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new InvalidArgumentException("Veículo não encontrado para o ID: " + id));

        vehicle = setAttributes(vehicle, updatedVehicle);

        return repository.save(vehicle);
    }

    private Vehicle setAttributes(Vehicle old, Vehicle updated) {

        old.setYearManufacture(updated.getYearManufacture());
        old.setColor(updated.getColor().toUpperCase());
        old.setBrand(updated.getBrand().toUpperCase());
        old.setType(updated.getType().toUpperCase());
        old.setModel(updated.getModel().toUpperCase());

        return old;
    }

}
