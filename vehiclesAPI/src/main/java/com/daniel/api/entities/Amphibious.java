package com.daniel.api.entities;

import javax.persistence.Entity;

@Entity
public class Amphibious extends Vehicle {

	private boolean canDive = true;

	public Amphibious() {
		super();
	}
	
	public Amphibious(Amphibious vehicle) {
		super();
		this.type = "AMPHIBIOUS";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		this.wheels = vehicle.getWheels();
		this.year = vehicle.getYear();
		this.canDive = vehicle.isCanDive();
	}

	public Amphibious(Vehicle vehicle) {
		super();
		this.type = "AMPHIBIOUS";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		this.wheels = vehicle.getWheels();
		this.year = vehicle.getYear();
	}

	public boolean isCanDive() {
		return canDive;
	}

	public void setCanDive(boolean canDive) {
		this.canDive = canDive;
	}

}
