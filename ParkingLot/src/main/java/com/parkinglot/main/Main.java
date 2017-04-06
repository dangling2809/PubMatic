package com.parkinglot.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import com.parkinglot.commands.CarParkingLotCommandExecutor;
import com.parkinglot.exceptions.InvalidCommandException;
import com.parkinglot.service.CarParkingLot;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
    	if(args!=null){
    	CarParkingLotCommandExecutor commandExecutor = new CarParkingLotCommandExecutor(CarParkingLot.getInstance());
        switch (args.length) {
            case 0:
            	System.out.println("Enter 'exit' to quit");
                try {
                	while (true) {
                    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = br.readLine();
                        if ("exit".equalsIgnoreCase(inputString)) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                        	try{
                        		commandExecutor.parseAndExecuteTextInput(inputString.trim());
                        	}catch(InvalidCommandException ex){
                        		System.out.println(ex.getMessage());
                        	}
                        }
                } } catch(IOException e) {
                    System.out.println("Error in reading from console ");
                    e.printStackTrace();
                }
                break;
            case 1:
            	if("help".equalsIgnoreCase(args[0]))
            	{
            		printUsage(commandExecutor);
            	}else{
            		commandExecutor.parseAndExecuteFileInput(args[0]);
            	}break;
            default:
                System.out.println("Invalid input type 'help' to see all available options");
        }
      }
     }
   

	private static void printUsage(CarParkingLotCommandExecutor commandExecutor) {
		Set<String> commands=commandExecutor.getCommandMap().keySet();
		System.out.println("All available commands:");
		commands.forEach(System.out::println);
	}
}
