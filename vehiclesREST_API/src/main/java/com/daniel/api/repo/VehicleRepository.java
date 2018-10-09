package com.daniel.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.api.entities.Vehicle;

//@NoRepositoryBean
//public interface VehicleRepository<T extends Vehicle> extends JpaRepository<T, Long>{
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	Vehicle findById(long id);
	List<Vehicle> findByType(String type);
	List<Vehicle> findByMake(String make);
	List<Vehicle> findByYear(int year);
	List<Vehicle> findByColor(String color);
	Vehicle findByMakeAndYear(String make, int year);
	Vehicle findTopByOrderByIdDesc();
}
