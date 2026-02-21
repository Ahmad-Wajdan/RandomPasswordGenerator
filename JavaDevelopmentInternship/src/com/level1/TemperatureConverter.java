package com.level1;

import java.util.Scanner;

public class TemperatureConverter {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========Temperature Converter========");
		
		double temperature;
		while(true) {
			System.out.print("Enter The Temperature Value: ");
			if(sc.hasNextDouble()) {
				temperature = sc.nextDouble();
				break;
			}else {
				System.out.println("Invaid input! Please enter a numeric value for temperature.");
				sc.next();
			}
		}
		
		String unit;
		while(true) {
			System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit):");
			unit = sc.next().toUpperCase();
			
			if(unit.equals("C") || unit.equals("F")) {
				break;
			}else {
				System.out.println("Invalid Input! Please enter 'C' or 'F'.");
			}
		}
		
		double convertedTemperature;
		String convertedUnit;
		
		if(unit.equals("C")) {
			convertedTemperature = (temperature * 9/5 ) + 32;
			convertedUnit = "Fahrenheit";
			System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.%n ", temperature, convertedTemperature);
		}else {
			convertedTemperature = (temperature - 32) * 5/9;
			convertedUnit = "Celsius";
			System.out.printf("%.2f Fahrenheit is equal to %.2f Celsius.%n ", temperature, convertedTemperature);
		}
		
		sc.close();
	}

}
