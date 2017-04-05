package com.parkinglot.service;
import java.util.Map;
import java.util.Map.Entry;

import com.parkinglot.domain.ParkingSpace;


public class StatusFormatter {

	public void displayParkingLotStatus(Map<Integer,ParkingSpace> parkingSpaces) 
	{
		 System.out.println("Slot No.\tRegistration No.\tColor");
		 for(Entry<Integer, ParkingSpace> entry: parkingSpaces.entrySet())
		 {
			 ParkingSpace parkingSpace=entry.getValue();
			 if(!parkingSpace.isVacant() && parkingSpace.getCar()!=null)
				 System.out.println(entry.getKey() +"\t\t"+ parkingSpace.getCar().getRegNo() +"\t\t"+ parkingSpace.getCar().getColor());
		 }
	}
}
