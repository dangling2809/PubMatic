package com.parkinglot.tests;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.parkinglot.domain.Car;
import com.parkinglot.service.CarParkingLot;

public class CarParkingLotTest {
	
	private static CarParkingLot parkingLot;

	@Before
	public void setUp() throws Exception {
		parkingLot=CarParkingLot.getInstance();
	}

	@Test
	public void testCreateParkingLot() {
		cleanupParkingLotTestData();
		parkingLot.createParkingLot("ABC");
		Assert.assertEquals(false, parkingLot.isCreated());
		
		parkingLot.createParkingLot("4");
		Assert.assertEquals(true, parkingLot.isCreated());
	}

	@Test
	public void testParkCar() {
		cleanupParkingLotTestData();
		parkingLot.createParkingLot("4");
		parkingLot.park("", "");
		Assert.assertEquals(0, parkingLot.getNumberOfCarsParked().intValue());
		parkingLot.park("KA-01-HN-1999","White");
		parkingLot.park("KA-01-HN-1994","Black");
		parkingLot.park("KA-01-HN-1998","Blue");
		Assert.assertEquals(3, parkingLot.getNumberOfCarsParked().intValue());
		parkingLot.park("KA-01-HN-1999","Black");
		Assert.assertEquals(true, parkingLot.isFull());
		parkingLot.park("KA-01-HN-1996","Blue");
		Assert.assertEquals(true, parkingLot.isFull());
		Assert.assertEquals(4, parkingLot.getNumberOfCarsParked().intValue());
	}

	@Test
	public void testUnpark() {
		setupParkingLotTestData();
		parkingLot.unpark("5");
		Assert.assertEquals(4, parkingLot.getNumberOfCarsParked().intValue());
		parkingLot.unpark("ABB");
		Assert.assertEquals(4, parkingLot.getNumberOfCarsParked().intValue());
		parkingLot.unpark("3");
		Assert.assertEquals(3, parkingLot.getNumberOfCarsParked().intValue());
	}

	@Test
	public void testGetRegistrationNumbersByColor() {
		setupParkingLotTestData();
		Assert.assertArrayEquals(new String[]{"KA-01-HN-1994","KA-01-HN-1999"},parkingLot.getRegistrationNumbersByColor("Black").toArray());
	}

	@Test
	public void testGetSlotNumberByRegistrationNumber() {
		setupParkingLotTestData();
		Assert.assertEquals(2,parkingLot.getSlotNumberByRegistrationNumber("KA-01-HN-1994"));
	}

	@Test
	public void testGetSlotNumbersByColor() {
		setupParkingLotTestData();
		Assert.assertArrayEquals(new Integer[]{2,4},parkingLot.getSlotNumbersByColor("Black").toArray());
	}
	
	public void setupParkingLotTestData()
	{
		parkingLot.createParkingLot("4");
		parkingLot.park("KA-01-HN-1999","White");
		parkingLot.park("KA-01-HN-1994","Black");
		parkingLot.park("KA-01-HN-1998","Blue");
		parkingLot.park("KA-01-HN-1999","Black");
	}
	
	public void cleanupParkingLotTestData()
	{
		parkingLot.setCreated(false);
	}
}
