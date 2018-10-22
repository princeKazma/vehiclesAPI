package com.daniel.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.api.entities.Airplane;
import com.daniel.api.entities.Amphibious;
import com.daniel.api.entities.Boat;
import com.daniel.api.entities.Car;
import com.daniel.api.entities.Drone;
import com.daniel.api.entities.Truck;
import com.daniel.api.entities.Vehicle;
import com.daniel.api.handlers.NotFoundException;
import com.daniel.api.repo.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;

	/**
	 * Retrieve a list of Vehicles from Repo, or throw a NotFound (404) if empty
	 */
	public List<Vehicle> retrieveAllVehicles(){
		List<Vehicle> vehicles = vehicleRepo.findAll();
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Vehicles not found");
        }
		
        return vehicles;
	}

	/**
	 * Retrieve a list of Vehicles, of type Car only, from Repo, or throw a NotFound (404) if empty
	 */
	public List<Vehicle> retrieveCars(){
		List<Vehicle> vehicles = vehicleRepo.findByType("CAR");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Cars not found");
        }
		
        return vehicles;
	}

	/**
	 * Retrieve a list of Vehicles, of type Truck only, from Repo, or throw a NotFound (404) if empty
	 */
	public List<Vehicle> retrieveTrucks(){
		List<Vehicle> vehicles = vehicleRepo.findByType("TRUCK");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Trucks not found");
        }
		
        return vehicles;
	}

	/**
	 * Retrieve a list of Vehicles, of type Airplane only, from Repo, or throw a NotFound (404) if empty
	 */
	public List<Vehicle> retrieveAirplanes(){
		List<Vehicle> vehicles = vehicleRepo.findByType("AIRPLANE");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Airplanes not found");
        }
		
        return vehicles;
	}

	/**
	 * Retrieve a list of Vehicles, of type Drone only, from Repo, or throw a NotFound (404) if empty
	 */
	public List<Vehicle> retrieveDrones(){
		List<Vehicle> vehicles = vehicleRepo.findByType("DRONE");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Drones not found");
        }
		
        return vehicles;
	}

	/**
	 * Retrieve a list of Vehicles, of type Boat only, from Repo, or throw a NotFound (404) if empty
	 */
	public List<Vehicle> retrieveBoats(){
		List<Vehicle> vehicles = vehicleRepo.findByType("BOAT");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Boats not found");
        }
		
        return vehicles;
	}

	/**
	 * Retrieve a list of Vehicles, of type Amphibious only, from Repo, or throw a NotFound (404) if empty
	 */
	public List<Vehicle> retrieveAmphibiouses(){
		List<Vehicle> vehicles = vehicleRepo.findByType("AMPHIBIOUS");
		
		if(vehicles.isEmpty()){
            throw new NotFoundException("Amphibiouses not found");
        }
		
        return vehicles;
	}

	/**
	 * @param id
	 * Retrieve a single Vehicle, found by Id, or throw a NotFound (404) if Id not found
	 */
	public Vehicle retrieveVehicle(long id){
		Vehicle foundVehicle = vehicleRepo.findById(id);
        
        if (foundVehicle == null) {
            throw new NotFoundException("Vehicle not found");
        }
 
        return foundVehicle;
	}

	/**
	 * @param make
	 * @param year
	 * @param type
	 * Retrieve a list of Vehicles, searched on the sent parameters (make, year, type), or throw a NotFound (404)
	 */
	public List<Vehicle> searchVehicles(String make, Integer year, String type){
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
 
        return vehicles;
	}

	/**
	 * Retrieve the last Vehicle created, or throw a NotFound (404) if no Vehicle found
	 */
	public Vehicle retrieveLastVehicle(){
		Vehicle foundVehicle = vehicleRepo.findTopByOrderByIdDesc();
        
        if (foundVehicle == null) {
            throw new NotFoundException("Vehicle not found");
        }
 
        return foundVehicle;
	}
	
	/**
	 * @param car
	 * Receive a Vehicle object, of type Car, and find if combination of Make and Year already exists.
	 *  If a vehicle is found with these Make and Year throw a General (Runtime) Exception with its corresponding message.
	 *  Else, if no vehicle matches, create this new Car in the Repo, and return an object representation of this new Vehicle.
	 */
	public Vehicle createVehicle(Car car) {
		Vehicle vehicle = new Car(car);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Car already exists");
        }
		vehicleRepo.save(vehicle);
 
        return vehicle;
	}

	/**
	 * @param truck
	 * Receive a Vehicle object, of type Truck, and find if combination of Make and Year already exists.
	 *  If a vehicle is found with these Make and Year throw a General (Runtime) Exception with its corresponding message.
	 *  Else, if no vehicle matches, create this new Truck in the Repo, and return an object representation of this new Vehicle.
	 */
	public Vehicle createVehicle(Truck truck) {
		Vehicle vehicle = new Truck(truck);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Truck already exists");
        }
		vehicleRepo.save(vehicle);
 
        return vehicle;
	}

	/**
	 * @param airplane
	 * Receive a Vehicle object, of type Airplane, and find if combination of Make and Year already exists.
	 *  If a vehicle is found with these Make and Year throw a General (Runtime) Exception with its corresponding message.
	 *  Else, if no vehicle matches, create this new Airplane in the Repo, and return an object representation of this new Vehicle.
	 */
	public Vehicle createVehicle(Airplane airplane) {
		Vehicle vehicle = new Airplane(airplane);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Airplane already exists");
        }
		vehicleRepo.save(vehicle);
 
        return vehicle;
	}

	/**
	 * @param drone
	 * Receive a Vehicle object, of type Drone, and find if combination of Make and Year already exists.
	 *  If a vehicle is found with these Make and Year throw a General (Runtime) Exception with its corresponding message.
	 *  Else, if no vehicle matches, create this new Drone in the Repo, and return an object representation of this new Vehicle.
	 */
	public Vehicle createVehicle(Drone drone) {
		Vehicle vehicle = new Drone(drone);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Drone already exists");
        }
		vehicleRepo.save(vehicle);
 
        return vehicle;
	}

	/**
	 * @param boat
	 * Receive a Vehicle object, of type Boat, and find if combination of Make and Year already exists.
	 *  If a vehicle is found with these Make and Year throw a General (Runtime) Exception with its corresponding message.
	 *  Else, if no vehicle matches, create this new Boat in the Repo, and return an object representation of this new Vehicle.
	 */
	public Vehicle createVehicle(Boat boat) {
		Vehicle vehicle = new Boat(boat);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Boat already exists");
        }
		vehicleRepo.save(vehicle);
 
        return vehicle;
	}

	/**
	 * @param amph
	 * Receive a Vehicle object, of type Amphibious, and find if combination of Make and Year already exists.
	 *  If a vehicle is found with these Make and Year throw a General (Runtime) Exception with its corresponding message.
	 *  Else, if no vehicle matches, create this new Amphibious in the Repo, and return an object representation of this new Vehicle.
	 */
	public Vehicle createVehicle(Amphibious amph) {
		Vehicle vehicle = new Amphibious(amph);
		Vehicle foundVehicle = vehicleRepo.findByMakeAndYear(vehicle.getMake(), vehicle.getYear());
		
		if (foundVehicle != null) {
            throw new RuntimeException("Amphibious already exists");
        }
		vehicleRepo.save(vehicle);
 
        return vehicle;
	}
	
	/**
	 * @param id
	 * @param vehicle
	 * Receive a Vehicle object and an Id as parameters, and search for a vehicle with a matching Id.
	 *  If a vehicle is found, then update/replace with the received Vehicle object, and return this same object.
	 *  Else, if no vehicle is found with this Id, save it as a new Vehicle based on its type
	 */
	public Vehicle updateVehicle(long id, Vehicle vehicle) {
		if (vehicleRepo.existsById(id)) {
			Vehicle foundVehicle = vehicleRepo.findById(id);
			
			foundVehicle.setCapacity(vehicle.getCapacity());
	        foundVehicle.setColor(vehicle.getColor());
	        foundVehicle.setMake(vehicle.getMake());
	        foundVehicle.setWheels(vehicle.getWheels());
	        foundVehicle.setYear(vehicle.getYear());
	        vehicle = foundVehicle;
		}else {
			if(vehicle.getType().equalsIgnoreCase("TRUCK")) {
				vehicle = new Truck(vehicle);
			} else if(vehicle.getType().equalsIgnoreCase("AIRPLANE")) {
				vehicle = new Airplane(vehicle);
			} else if(vehicle.getType().equalsIgnoreCase("DRONE")) {
				vehicle = new Drone(vehicle);
			} else if(vehicle.getType().equalsIgnoreCase("BOAT")) {
				vehicle = new Boat(vehicle);
			} else if(vehicle.getType().equalsIgnoreCase("AMPHIBIOUS")) {
				vehicle = new Amphibious(vehicle);
			} else {
				vehicle = new Car(vehicle);
			}
		}
		
        vehicleRepo.save(vehicle);
        return vehicle;
    }
	
	/**
	 * @param id
	 * Search if a vehicle exists with the received Id.
	 *  If a vehicle is found, then delete this Vehicle object from the Repo.
	 *  Found or not, the response will be the same.
	 */
	public void deleteVehicle(long id) {
		if (vehicleRepo.existsById(id)) {
        	vehicleRepo.deleteById(id);
        }
    }

	/**
	 * Search if a vehicle exists in the repo, then retrieve the last created.
	 *  If a vehicle is found, then delete this Vehicle object from the Repo.
	 *  Found or not, the response will be the same.
	 */
	public void deleteLastVehicle(){
		Vehicle foundVehicle = vehicleRepo.findTopByOrderByIdDesc();
        
        if (foundVehicle != null) {
        	vehicleRepo.delete(foundVehicle);
        }
	}
	
}
