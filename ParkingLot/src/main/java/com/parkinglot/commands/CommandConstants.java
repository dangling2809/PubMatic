package com.parkinglot.commands;

/**
 * All supported commands in system.
 * @author Piyush
 */
public enum CommandConstants {

	PARK_COMMAND("park"),
	CREATE_PARKING_LOT_COMMAND("create_parking_lot"),
	UNPARK_COMMAND("leave"),
	GET_REG_NO_BY_COLOR_COMMAND("registration_numbers_for_cars_with_colour"),
	GET_SLOT_NUMBERS_BY_COLOUR_COMMAND("slot_numbers_for_cars_with_colour"),
	GET_SLOT_NUMBER_BY_REG_NO("slot_number_for_registration_number"),
	STATUS("status");
	
	private String command;

	private CommandConstants(String command) {
		this.command = command;
	}

	public String getCommand() {
		return command;
	}
}