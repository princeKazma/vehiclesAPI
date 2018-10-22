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

import com.daniel.api.services.VehicleService;
import com.daniel.api.entities.Airplane;
import com.daniel.api.entities.Amphibious;
import com.daniel.api.entities.Boat;
import com.daniel.api.entities.Car;
import com.daniel.api.entities.Drone;
import com.daniel.api.entities.Truck;
import com.daniel.api.entities.Vehicle;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicles")
	public ResponseEntity<List<Vehicle>> retrieveVehicles(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.retrieveAllVehicles(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/car")
	public ResponseEntity<List<Vehicle>> retrieveCars(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.retrieveCars(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/truck")
	public ResponseEntity<List<Vehicle>> retrieveTrucks(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.retrieveTrucks(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/airplane")
	public ResponseEntity<List<Vehicle>> retrieveAirplanes(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.retrieveAirplanes(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/drone")
	public ResponseEntity<List<Vehicle>> retrieveDrones(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.retrieveDrones(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/boat")
	public ResponseEntity<List<Vehicle>> retrieveBoats(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.retrieveBoats(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/amph")
	public ResponseEntity<List<Vehicle>> retrieveAmphibiouses(){
		return new ResponseEntity<List<Vehicle>>(vehicleService.retrieveAmphibiouses(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> retrieveVehicle(@PathVariable("id") long id){
		return new ResponseEntity<Vehicle>(vehicleService.retrieveVehicle(id), HttpStatus.OK);
	}

	@GetMapping("/vehicles/search")
	public ResponseEntity<List<Vehicle>> searchVehicles(
			@RequestParam(value = "make", required = false) String make, 
			@RequestParam(value = "year", required = false) Integer year, 
			@RequestParam(value = "type", required = false) String type){
		return new ResponseEntity<List<Vehicle>>(vehicleService.searchVehicles(make, year, type), HttpStatus.OK);
	}

	@GetMapping("/vehicles/last")
	public ResponseEntity<Vehicle> retrieveLastVehicle(){
		return new ResponseEntity<Vehicle>(vehicleService.retrieveLastVehicle(), HttpStatus.OK);
	}
	
	@PostMapping("/vehicles/car")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Car car) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(car), HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/truck")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Truck truck) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(truck), HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/airplane")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Airplane airplane) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(airplane), HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/drone")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Drone drone) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(drone), HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/boat")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Boat boat) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(boat), HttpStatus.CREATED);
	}

	@PostMapping("/vehicles/amph")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Amphibious amph) {
		return new ResponseEntity<Vehicle>(vehicleService.createVehicle(amph), HttpStatus.CREATED);
	}
	
	@PutMapping("/vehicles/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") long id, @RequestBody Vehicle vehicle) {
		return new ResponseEntity<Vehicle>(vehicleService.updateVehicle(id, vehicle), HttpStatus.OK);
    }
	
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<Object> deleteVehicle(@PathVariable("id") long id) {
		vehicleService.deleteVehicle(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

	@DeleteMapping("/vehicles/last")
	public ResponseEntity<Object> deleteLastVehicle(){
		vehicleService.deleteLastVehicle();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
}
