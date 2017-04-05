package com.parkinglot.exceptions;

public class InvalidParkingLotSizeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidParkingLotSizeException(String message) {
		super(message);
	}
}
