package com.parkinglot.exceptions;

public class InvalidCommandException extends RuntimeException{

	public InvalidCommandException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCommandException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
