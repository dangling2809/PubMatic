package com.parkinglot.service;

import com.parkinglot.regulations.IGovernmentRegulations;
/**
 * Base interface to combine {@link IGovernmentRegulations} and 
 * Parking lot basic requirements.
 * @author Piyush
 *
 * @param <T>
 */
public interface ParkingLot<T> extends IGovernmentRegulations{

	public void park(T t);
	
	public void unpark(String i);
	
	public void displayStatus();
	
	public void park(String registrationNumber,String color);
	
	public boolean isFull();
	
	public boolean isCreated();
	
}
