package com.daniel.api.entities;

import javax.persistence.Entity;

@Entity
public class Boat extends Vehicle {

	private boolean hasEngine = false;
	private boolean hasSails = false;
	
	public Boat() {
		super();
	}

	public Boat(Boat vehicle) {
		super();
		this.type = "BOAT";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		// Boats don't need wheels
		this.wheels = 0;
		this.year = vehicle.getYear();
		this.hasEngine = vehicle.isHasEngine();
		this.hasSails = vehicle.isHasSails();
	}

	public Boat(Vehicle vehicle) {
		super();
		this.type = "BOAT";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		// Boats don't need wheels
		this.wheels = 0;
		this.year = vehicle.getYear();
	}

	public boolean isHasEngine() {
		return hasEngine;
	}

	public void setHasEngine(boolean hasEngine) {
		this.hasEngine = hasEngine;
	}

	public boolean isHasSails() {
		return hasSails;
	}

	public void setHasSails(boolean hasSails) {
		this.hasSails = hasSails;
	}
	
}
