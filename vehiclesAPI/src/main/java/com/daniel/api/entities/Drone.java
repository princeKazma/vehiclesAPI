package com.daniel.api.entities;

import javax.persistence.Entity;

@Entity
public class Drone extends Vehicle {

	private int maxFlightHeight = 500;
	private boolean hasCamera = false;
	
	public Drone() {
		super();
	}

	public Drone(Drone vehicle) {
		super();
		this.type = "DRONE";
		// Drones can't carry humans, yet
		this.capacity = 0;
		this.color = vehicle.getColor();
		this.make = vehicle.getMake();
		// Flying drones don't need wheels
		this.wheels = 0;
		this.year = vehicle.getYear();
		this.maxFlightHeight = vehicle.getMaxFlightHeight();
		this.hasCamera = vehicle.isHasCamera();
	}

	public int getMaxFlightHeight() {
		return maxFlightHeight;
	}

	public void setMaxFlightHeight(int maxFlightHeight) {
		this.maxFlightHeight = maxFlightHeight;
	}

	public boolean isHasCamera() {
		return hasCamera;
	}

	public void setHasCamera(boolean hasCamera) {
		this.hasCamera = hasCamera;
	}

}
