package com.daniel.api.entities;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {

	private int maxDriveSpeed = 150;
	
	public Car() {
		super();
	}

	public Car(Car vehicle) {
		super();
		this.type = "CAR";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		// Cars should always have 4 wheels
		this.wheels = 4;
		this.year = vehicle.getYear();
		this.maxDriveSpeed = vehicle.getMaxDriveSpeed();
	}

	public Car(Vehicle vehicle) {
		super();
		this.type = "CAR";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		// Cars should always have 4 wheels
		this.wheels = 4;
		this.year = vehicle.getYear();
	}

	public int getMaxDriveSpeed() {
		return maxDriveSpeed;
	}

	public void setMaxDriveSpeed(int maxDriveSpeed) {
		this.maxDriveSpeed = maxDriveSpeed;
	}

}
