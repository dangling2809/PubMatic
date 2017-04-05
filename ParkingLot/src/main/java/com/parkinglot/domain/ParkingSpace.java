package com.parkinglot.domain;

public class ParkingSpace {

	private int slotNumber;
	
	private boolean vacant;
	
	private Car car;
	
	public ParkingSpace(int number) {
		super();
		this.slotNumber = number;
		this.vacant=true;
	}

	public int getNumber() {
		return slotNumber;
	}

	public void setNumber(int number) {
		this.slotNumber = number;
	}

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
