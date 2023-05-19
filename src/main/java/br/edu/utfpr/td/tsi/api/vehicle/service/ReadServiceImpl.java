package br.edu.utfpr.td.tsi.api.vehicle.service;

import br.edu.utfpr.td.tsi.api.vehicle.exception.NotFoundException;
import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.api.vehicle.repository.Repository;

@Component
public class ReadServiceImpl implements ReadService {

    @Autowired
    private Repository repository;

    @Override
    public Vehicle findById(String id) {
        return validadeVehicleOrThrowException(repository.findById(id).orElse(null));
    }

    @Override
    public Vehicle findByRegistration(String registration) {
        return validadeVehicleOrThrowException(repository.findByRegistration(registration));
    }

    @Override
    public List<Vehicle> findAll() {
        return validadeListOrThrowException(repository.findAll());
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        return validadeListOrThrowException(repository.findByColor(color.toUpperCase()));
    }

    @Override
    public List<Vehicle> findByType(String type) {
        return validadeListOrThrowException(repository.findByColor(type.toUpperCase()));
    }

    @Override
    public List<Vehicle> findByColorAndType(String color, String type) {
        return validadeListOrThrowException(repository.findByColorAndType(color.toUpperCase(), type.toUpperCase()));
    }

    private List<Vehicle> validadeListOrThrowException(List<Vehicle> vehicles) {

        if (vehicles == null || vehicles.isEmpty()) {
            throw new NotFoundException("Nenhum veículo encontrado");
        }

        return vehicles;
    }

    private Vehicle validadeVehicleOrThrowException(Vehicle vehicle) {

        if (vehicle == null) {
            throw new NotFoundException("Veículo não encontrado");
        }

        return vehicle;
    }

}
