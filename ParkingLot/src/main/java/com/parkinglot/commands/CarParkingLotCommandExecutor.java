package com.parkinglot.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.parkinglot.domain.Car;
import com.parkinglot.exceptions.InvalidCommandException;
import com.parkinglot.service.CarParkingLot;
import com.parkinglot.service.ParkingLot;

/**
 * Immutable parking lot command executor.
 * Use this class to parse/execute command line input both file/interactive mode.
 *  
 * @author Piyush
 *
 */
public final class CarParkingLotCommandExecutor {
	
	private final Map<String,Method> commandMap;
	private final ParkingLot<Car> parkingLot;

	public CarParkingLotCommandExecutor(ParkingLot<Car> parkingLot) throws NoSuchMethodException, SecurityException {
		super();
		this.commandMap =new HashMap<String,Method>();
		this.parkingLot = parkingLot;
		initializeCommandMap();
	}

	/**
	 * Initialization method to be called from constructor for 
	 * creating a map of commands and method to be executed for it.
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private void initializeCommandMap() throws NoSuchMethodException, SecurityException {
		commandMap.put(CommandConstants.CREATE_PARKING_LOT_COMMAND.getCommand(),CarParkingLot.class.getDeclaredMethod("createParkingLot", String.class));
		commandMap.put(CommandConstants.PARK_COMMAND.getCommand(), ParkingLot.class.getDeclaredMethod("park", String.class,String.class));
		commandMap.put(CommandConstants.UNPARK_COMMAND.getCommand(),CarParkingLot.class.getDeclaredMethod("unpark", String.class));
		commandMap.put(CommandConstants.GET_REG_NO_BY_COLOR_COMMAND.getCommand(), CarParkingLot.class.getDeclaredMethod("getRegistrationNumbersByColor", String.class));
		commandMap.put(CommandConstants.GET_SLOT_NUMBERS_BY_COLOUR_COMMAND.getCommand(),CarParkingLot.class.getDeclaredMethod("getSlotNumbersByColor", String.class));
		commandMap.put(CommandConstants.GET_SLOT_NUMBER_BY_REG_NO.getCommand(), CarParkingLot.class.getDeclaredMethod("getSlotNumberByRegistrationNumber", String.class));
		commandMap.put(CommandConstants.STATUS.getCommand(), CarParkingLot.class.getDeclaredMethod("displayStatus"));
	}

	public void parseAndExecuteTextInput(String command) {
		String[] inputs = command.split(" ");
		if(!CommandConstants.CREATE_PARKING_LOT_COMMAND.getCommand().equals(inputs[0]) && !parkingLot.isCreated()){
			System.out.println("Parking lot not created yet , Kindly create using create_parking_lot command");
			return;
		}
        switch (inputs.length) {
            case 1:
                try {
                    Method method = commandMap.get(command);
                    if (method != null) {
                        method.invoke(parkingLot);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    throw new InvalidCommandException("Command "+Arrays.toString(inputs) + "not valid");
                } catch (InvocationTargetException e) {
                	throw new InvalidCommandException("Command "+Arrays.toString(inputs) + "not valid");
                }catch(IllegalArgumentException e){
                	throw new InvalidCommandException("Command "+Arrays.toString(inputs) + "not valid");
                }
                break;
            case 2:
                try {
                    Method method = commandMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(parkingLot, inputs[1]);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    throw new InvalidCommandException("Command "+Arrays.toString(inputs) + " not valid");
                } catch (InvocationTargetException e) {
                	throw new InvalidCommandException("Command "+Arrays.toString(inputs)+ " not valid");
                }catch(IllegalArgumentException e){
                	throw new InvalidCommandException("Command "+Arrays.toString(inputs) + " not valid");
                }
                break;
            case 3:
                try {
                    Method method = commandMap.get(inputs[0]);
                    if (method != null) {
                        method.invoke(parkingLot, inputs[1], inputs[2]);
                    } else {
                        System.out.println("Invalid input");
                    }
                } catch (IllegalAccessException e) {
                    throw new InvalidCommandException("Command "+ Arrays.toString(inputs) + " not valid");
                } catch (InvocationTargetException e) {
                	throw new InvalidCommandException("Command "+ Arrays.toString(inputs) + " not valid");
                }catch(IllegalArgumentException e){
                	throw new InvalidCommandException("Command "+ Arrays.toString(inputs) + " not valid");
                }
                break;
            default:
                System.out.println("Invalid input.");
        }
	}

	public void parseAndExecuteFileInput(String filePath) {
        File inputFile = new File(filePath);
        if(inputFile!=null && inputFile.exists() && inputFile.canRead())
        {
        	//using try with resources to avoid finally
        	try (BufferedReader br = new BufferedReader(new FileReader(inputFile));){
        		String line;
        		try {
        			while ((line = br.readLine()) != null) {
        				parseAndExecuteTextInput(line.trim());
        			}
        		} catch (IOException ex) {
        			System.out.println("Error in reading the input file.");
                	ex.printStackTrace();
        		}
        } catch (FileNotFoundException e) {
            System.out.println("File not found at the path specified.");
            e.printStackTrace();
        } catch (IOException e1) {
        	  System.out.println("File not found at the path specified.");
			e1.printStackTrace();
		}
        }else{
        	System.out.println("Command file does not exist or not readable at path -> "+filePath);
        }
	}
	
	public Map<String, Method> getCommandMap() {
		return commandMap;
	}

	public ParkingLot<Car> getParkingLot() {
		return parkingLot;
	}
	
	
}
