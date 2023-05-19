package br.edu.utfpr.td.tsi.api.vehicle.service;

import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import java.util.List;

public interface ReadService {

    Vehicle findByRegistration(String registration);

    List<Vehicle> findAll();

    List<Vehicle> findByColor(String color);

    List<Vehicle> findByType(String type);

    List<Vehicle> findByColorAndType(String color, String type);

    Vehicle findById(String id);

}
