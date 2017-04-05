package com.parkinglot.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.parkinglot.service.CarParkingLot;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
    	if(args!=null){
    	CarParkingLotCommandExecutor commandExecutor = new CarParkingLotCommandExecutor(CarParkingLot.getInstance());
        switch (args.length) {
            case 0:
                System.out.println("Please enter 'exit' to quit");
                System.out.println("Waiting for input...");
                while (true) {
                    try {
                    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = br.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            // Do nothing
                        } else {
                        	commandExecutor.parseAndExecuteTextInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("Error in reading ");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
            	commandExecutor.parseAndExecuteFileInput(args[0]);
                break;
            default:
                System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
        }
      }
    }
}
