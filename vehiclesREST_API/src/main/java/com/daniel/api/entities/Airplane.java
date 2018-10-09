package com.daniel.api.entities;

import javax.persistence.Entity;

@Entity
public class Airplane extends Vehicle {

	private int maxFlightHeight = 40000;
	private int maxFlightSpeed = 800;
	private boolean isPrivate = false;
	
	public Airplane() {
		super();
	}

	public Airplane(Airplane vehicle) {
		super();
		this.type = "AIRPLANE";
		this.capacity = vehicle.getCapacity();
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		this.wheels = vehicle.getWheels();
		this.year = vehicle.getYear();
		this.maxFlightHeight = vehicle.getMaxFlightHeight();
		this.maxFlightSpeed = vehicle.getMaxFlightSpeed();
		this.isPrivate = vehicle.isPrivate();
	}

	public int getMaxFlightHeight() {
		return maxFlightHeight;
	}

	public void setMaxFlightHeight(int maxFlightHeight) {
		this.maxFlightHeight = maxFlightHeight;
	}

	public int getMaxFlightSpeed() {
		return maxFlightSpeed;
	}

	public void setMaxFlightSpeed(int maxFlightSpeed) {
		this.maxFlightSpeed = maxFlightSpeed;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

}
