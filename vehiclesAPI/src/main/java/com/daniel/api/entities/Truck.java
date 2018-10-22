package com.daniel.api.entities;

import javax.persistence.Entity;

@Entity
public class Truck extends Vehicle {

	private int maxCarryWeight = 500;
	private int maxDriveSpeed = 100;

	public Truck() {
		super();
	}

	public Truck(Truck vehicle) {
		super();
		this.type = "TRUCK";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		// Truck should always have 4 wheels
		this.wheels = 4;
		this.year = vehicle.getYear();
		this.maxCarryWeight = vehicle.getMaxCarryWeight();
		this.maxDriveSpeed = vehicle.getMaxDriveSpeed();
	}

	public Truck(Vehicle vehicle) {
		super();
		this.type = "TRUCK";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		// Truck should always have 4 wheels
		this.wheels = 4;
		this.year = vehicle.getYear();
	}

	public int getMaxCarryWeight() {
		return maxCarryWeight;
	}

	public void setMaxCarryWeight(int maxCarryWeight) {
		this.maxCarryWeight = maxCarryWeight;
	}

	public int getMaxDriveSpeed() {
		return maxDriveSpeed;
	}

	public void setMaxDriveSpeed(int maxDriveSpeed) {
		this.maxDriveSpeed = maxDriveSpeed;
	}
	
}
