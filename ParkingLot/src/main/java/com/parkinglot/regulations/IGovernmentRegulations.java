package com.parkinglot.regulations;
import java.util.List;
import java.util.Set;


public interface IGovernmentRegulations {

	public Set<String> getRegistrationNumbersByColor(String color);
	
	public int getSlotNumberByRegistrationNumber(String registrationNumber);
	
	public Set<Integer> getSlotNumbersByColor(String color);
}
