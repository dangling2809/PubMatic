package com.parkinglot.regulations;
import java.util.List;
import java.util.Set;

/**
 * Interface to hold set of Government Regulation.
 * It is must to implement below interface for all future parking lot implementations
 * to force all rules before parking lot construction.
 * @author Piyush
 *
 */
public interface IGovernmentRegulations {

	public Set<String> getRegistrationNumbersByColor(String color);
	
	public int getSlotNumberByRegistrationNumber(String registrationNumber);
	
	public Set<Integer> getSlotNumbersByColor(String color);
}
