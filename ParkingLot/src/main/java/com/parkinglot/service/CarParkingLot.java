package com.parkinglot.service;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

import com.parkinglot.domain.Car;
import com.parkinglot.domain.ParkingSpace;
import com.parkinglot.exceptions.InvalidParkingLotSizeException;


public class CarParkingLot implements ParkingLot<Car>{
	
	private static final CarParkingLot INSTANCE=new CarParkingLot();
	
	private AtomicInteger numberOfCarsParked=new AtomicInteger();
	
	private int parkingLotSize=0;//defaults to 0
	
	private final StatusFormatter statusFormatter=new StatusFormatter();
	
	private  Map<Integer,ParkingSpace> parkingSpaces;
	
	private  Map<String,Set<String>> colorToRegistrationNumberMap;
	
	private  Map<String,Integer> registrationNumberToSlotNumberMap;
	
	private  Map<String,Set<Integer>> colorToParkingSlotNumberMap;
	
	private boolean created=false;

	public static CarParkingLot getInstance()
	{
		return INSTANCE;
	}
	
	private CarParkingLot(){
		if( CarParkingLot.INSTANCE != null ) {
			throw new InstantiationError( "Creating of this object is not allowed." );
		}
	}
	
	@Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this class is not allowed"); 
    }
	
    protected Object readResolve() {
        return INSTANCE;
    }
	
	public void createParkingLot(String parkingLotSizeStr){
			try{
				int maxSize=validateParkingLotSize(parkingLotSizeStr);
				this.parkingLotSize = maxSize;
				this.parkingSpaces=new LinkedHashMap<Integer,ParkingSpace>(parkingLotSize);
				this.colorToRegistrationNumberMap=new LinkedHashMap<>(parkingLotSize);
				this.registrationNumberToSlotNumberMap=new LinkedHashMap<>(parkingLotSize);
				this.colorToParkingSlotNumberMap=new LinkedHashMap<>(parkingLotSize);
				int size=parkingLotSize;
				int i=1;
				do{
					parkingSpaces.put(i, new ParkingSpace(i));
					i++;
					size--;
				}while(size>0);
				this.created=true;
				System.out.println("Created a parking lot with "+ parkingLotSizeStr +" slots");
			}catch(InvalidParkingLotSizeException ex)
			{
				System.out.println(ex.getMessage());
			}
	}
	
	private int validateParkingLotSize(String parkingLotSizeStr) throws InvalidParkingLotSizeException {
		try{
			int maxSize=Integer.parseInt(parkingLotSizeStr);
			if(maxSize<=0)
				throw new InvalidParkingLotSizeException("Invalid size for parking lot must be a number > 0");
			return maxSize;
		}catch(NumberFormatException e)
		{
			throw new InvalidParkingLotSizeException("Invalid size for parking lot must be a number > 0");
		}
	}

	@Override
	public void park(String registrationNumber, String color) {
		Car car=new Car();
		car.setColor(color);
		car.setRegNo(registrationNumber);
		park(car);
	}
	
	public void park(Car car){
		if(isFull()){
			System.out.println("Sorry, parking lot is full");
		}else if(isCreated()){
			int parkingSlotNumber=getNearestVacantSpot();
			if(parkingSlotNumber!=-1)
			{
				ParkingSpace parkingSpace=parkingSpaces.get(parkingSlotNumber);
				parkingSpace.setVacant(false);
				parkingSpace.setCar(car);
				buildColorToRegistrationNumberMap(car);
				buildRegistrationNumberToSlotNumberMap(car,parkingSlotNumber);
				buildColorToParkingSlotNumberMap(car,parkingSlotNumber);
				numberOfCarsParked.getAndIncrement();
				System.out.println("Allocated slot number: "+ parkingSlotNumber);
			}else{
				System.out.println("Sorry, parking lot is full");
			}
		}else{
			System.out.println("Parking Lot not created First create it using create_parking_lot command");
		}
	}
	
	public void unpark(String parkingSlotNumberStr){
		try{
			int parkingSlotNumber=Integer.parseInt(parkingSlotNumberStr);
			ParkingSpace parkingSpace=parkingSpaces.get(parkingSlotNumber);
			if(!parkingSpace.isVacant())
			{
				parkingSpace.setVacant(true);
				Car c=parkingSpace.getCar();
				String carColor=c.getColor();
				colorToParkingSlotNumberMap.get(carColor).remove(parkingSlotNumber);
				colorToRegistrationNumberMap.get(carColor).remove(c.getRegNo());
				registrationNumberToSlotNumberMap.remove(c.getRegNo());
				numberOfCarsParked.getAndDecrement();
				System.out.println("Slot number "+ parkingSlotNumber +" is free");
			}else{
				System.out.println("Slot number "+ parkingSlotNumber +" is not occupied");
			}
		}catch(NumberFormatException ex)
		{
			System.out.println("Inalid Parking Slot Number");
		}
	}

	private void buildColorToParkingSlotNumberMap(Car car, int parkingSlotNumber) {
		Set<Integer> parkingSlotNumbers=colorToParkingSlotNumberMap.get(car.getColor());
		if(parkingSlotNumbers==null)
		{	
			parkingSlotNumbers=new HashSet<Integer>();
			colorToParkingSlotNumberMap.put(car.getColor(), parkingSlotNumbers);
		}
		parkingSlotNumbers.add(parkingSlotNumber);
	}

	private void buildRegistrationNumberToSlotNumberMap(Car car,
			int parkingSlotNumber) {
		registrationNumberToSlotNumberMap.put(car.getRegNo(), parkingSlotNumber);
		
	}

	private void buildColorToRegistrationNumberMap(Car car) {
		Set<String> registrationNumbers=colorToRegistrationNumberMap.get(car.getColor());
		if(registrationNumbers==null)
		{	
			registrationNumbers=new HashSet<>();
			colorToRegistrationNumberMap.put(car.getColor(), registrationNumbers);
		}
		registrationNumbers.add(car.getRegNo());
	}

	private int getNearestVacantSpot() {
		for(Map.Entry<Integer, ParkingSpace> entry:parkingSpaces.entrySet())
		{
			ParkingSpace space=entry.getValue();
			if(space.isVacant())
				return space.getNumber();
			else
				continue;
		}
		return -1;
	}

	@Override
	public Set<String> getRegistrationNumbersByColor(String color) {
		if(colorToRegistrationNumberMap.containsKey(color))
		{
			Set<String> registrationNumbers=colorToRegistrationNumberMap.get(color);
			System.out.println(String.join(",", registrationNumbers));
			return registrationNumbers;
		}else{
			System.out.println("Not found");
			return Collections.emptySet();
		}
	}

	@Override
	public int getSlotNumberByRegistrationNumber(String registrationNumber) {
		if(registrationNumberToSlotNumberMap.containsKey(registrationNumber))
		{
			int slotNumber=registrationNumberToSlotNumberMap.get(registrationNumber);
			System.out.println(slotNumber);
			return slotNumber;
		}else{
			System.out.println("Not found");
			return -1;
		}
	}

	@Override
	public Set<Integer> getSlotNumbersByColor(String color) {
		if(colorToParkingSlotNumberMap.containsKey(color))
		{
			Set<Integer> slotNumbers=colorToParkingSlotNumberMap.get(color);
			StringJoiner joiner = new StringJoiner(",");
			for (Integer item : slotNumbers) {
			    joiner.add(item.toString());
			}
			System.out.println(joiner.toString());
			return slotNumbers;
		}else{
			System.out.println("Not found");
			return Collections.emptySet();
		}
	}

	@Override
	public void displayStatus() {
		statusFormatter.displayParkingLotStatus(parkingSpaces);
	}

	@Override
	public boolean isFull() {
		return numberOfCarsParked.intValue()==parkingSpaces.size();
	}

	public boolean isCreated() {
		return created;
	}
}
