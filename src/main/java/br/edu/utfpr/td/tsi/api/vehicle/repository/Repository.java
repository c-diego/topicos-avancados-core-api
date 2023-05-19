package br.edu.utfpr.td.tsi.api.vehicle.repository;

import java.util.List;

import br.edu.utfpr.td.tsi.api.vehicle.model.Vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Vehicle, String> {

    Vehicle findByRegistration(String registration);

    List<Vehicle> findByColorAndType(String color, String type);

    List<Vehicle> findByColor(String color);

    List<Vehicle> findByType(String type);
    
}
