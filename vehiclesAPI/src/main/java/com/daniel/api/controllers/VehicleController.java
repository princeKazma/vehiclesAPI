package com.daniel.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.api.repo.VehicleRepository;
import com.daniel.api.entities.Airplane;
import com.daniel.api.entities.Amphibious;
import com.daniel.api.entities.Boat;
import com.daniel.api.entities.Car;
import com.daniel.api.entities.Drone;
import com.daniel.api.entities.Truck;
import com.daniel.api.entities.Vehicle;
import com.daniel.api.handlers.NotFoundException;

@RestController
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepo;

	@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> retrieveVehicles(){
		List<Vehicle> vehicles = vehicleRepo.findAll();
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Vehicles not found");
        }
		
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/car")
	public ResponseEntity<List<Vehicle>> retrieveCars(){
		List<Vehicle> vehicles = vehicleRepo.findByType("CAR");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Cars not found");
        }
		
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/truck")
	public ResponseEntity<List<Vehicle>> retrieveTrucks(){
		List<Vehicle> vehicles = vehicleRepo.findByType("TRUCK");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Trucks not found");
        }
		
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/airplane")
	public ResponseEntity<List<Vehicle>> retrieveAirplane(){
		List<Vehicle> vehicles = vehicleRepo.findByType("AIRPLANE");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Airplanes not found");
        }
		
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/drone")
	public ResponseEntity<List<Vehicle>> retrieveDrones(){
		List<Vehicle> vehicles = vehicleRepo.findByType("DRONE");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Drones not found");
        }
		
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/boat")
	public ResponseEntity<List<Vehicle>> retrieveBoat(){
		List<Vehicle> vehicles = vehicleRepo.findByType("BOAT");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Boats not found");
        }
		
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/amph")
	public ResponseEntity<List<Vehicle>> retrieveAmphibiouses(){
		List<Vehicle> vehicles = vehicleRepo.findByType("AMPHIBIOUS");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Amphibiouses not found");
        }
		
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> retrieveVehicle(@PathVariable("id") long id){
		Vehicle foundVehicle = vehicleRepo.findById(id);
        
        if (foundVehicle == null) {
            throw new NotFoundException("Vehicle not found");
        }
 
        return new ResponseEntity<Vehicle>(foundVehicle, HttpStatus.OK);
	}

	@GetMapping("/vehicles/search")
	public ResponseEntity<List<Vehicle>> retrieveVehiclesByMake(
			@RequestParam(value = "make", required = false) String make, 
			@RequestParam(value = "year", required = false) Integer year, 
			@RequestParam(value = "type", required = false) String type){
		List<Vehicle> vehicles = null;
		if(make != null && year != null) {
			Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(make, year);
			if(foundVehicle != null) {
				vehicles = new ArrayList<Vehicle>();
				vehicles.add(foundVehicle);
			}
		}else if(make != null) {
			if(type != null) {
				vehicles  = vehicleRepo.findByMakeAndType(make,type);
			} else {
				vehicles  = vehicleRepo.findByMake(make);
			}
		} else if(year != null) {
			if(type != null) {
				vehicles  = vehicleRepo.findByYearAndType(year,type);
			} else {
				vehicles  = vehicleRepo.findByYear(year);
			}
		}else if(type != null) {
			vehicles = vehicleRepo.findByType(type);
		}
		
        
        if (vehicles == null || vehicles.isEmpty()) {
            throw new NotFoundException("Vehicles not found");
        }
 
        return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@GetMapping("/vehicles/last")
	public ResponseEntity<Vehicle> retrieveLastVehicle(){
		Vehicle foundVehicle = vehicleRepo.findTopByOrderByIdDesc();
        
        if (foundVehicle == null) {
            throw new NotFoundException("Vehicle not found");
        }
 
        return new ResponseEntity<Vehicle>(foundVehicle, HttpStatus.OK);
	}
	
	@PostMapping("/vehicles/car")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Car car) {
		Vehicle vehicle = new Car(car);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Car already exists");
        }
		vehicleRepo.save(vehicle);
 
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/truck")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Truck truck) {
		Vehicle vehicle = new Truck(truck);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Truck already exists");
        }
		vehicleRepo.save(vehicle);
 
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/airplane")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Airplane airplane) {
		Vehicle vehicle = new Airplane(airplane);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Airplane already exists");
        }
		vehicleRepo.save(vehicle);
 
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/drone")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Drone drone) {
		Vehicle vehicle = new Drone(drone);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Drone already exists");
        }
		vehicleRepo.save(vehicle);
 
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/boat")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Boat boat) {
		Vehicle vehicle = new Boat(boat);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Boat already exists");
        }
		vehicleRepo.save(vehicle);
 
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/amph")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Amphibious amph) {
		Vehicle vehicle = new Amphibious(amph);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Amphibious already exists");
        }
		vehicleRepo.save(vehicle);
 
        return new ResponseEntity<Vehicle>(vehicle, HttpStatus.CREATED);
	}
	
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id, @RequestBody Vehicle vehicle) {
		Vehicle foundVehicle = vehicleRepo.findById(id);
         
        if (foundVehicle == null) {
            throw new NotFoundException("Vehicle not found");
        }
 
        foundVehicle.setCapacity(vehicle.getCapacity());
        foundVehicle.setColor(vehicle.getColor());
        foundVehicle.setMake(vehicle.getMake());
        foundVehicle.setWheels(vehicle.getWheels());
        foundVehicle.setYear(vehicle.getYear());
         
        vehicleRepo.save(foundVehicle);
        return new ResponseEntity<Vehicle>(foundVehicle, HttpStatus.OK);
    }
	
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") long id) {
		Vehicle foundVehicle = vehicleRepo.findById(id);
        
        if (foundVehicle == null) {
            throw new NotFoundException("Vehicle not found");
        }
 
        vehicleRepo.deleteById(id);
        return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);
    }

	@DeleteMapping("/vehicles/last")
	public ResponseEntity<Vehicle> deleteLastVehicle(){
		Vehicle foundVehicle = vehicleRepo.findTopByOrderByIdDesc();
        
        if (foundVehicle == null) {
            throw new NotFoundException("Vehicle not found");
        }

        vehicleRepo.delete(foundVehicle);
        return new ResponseEntity<Vehicle>(HttpStatus.NO_CONTENT);
	}
	
	
}
