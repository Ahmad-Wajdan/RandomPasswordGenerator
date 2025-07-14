package com.level1;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class RandomPasswordGenerator {
	private static String  digits = "1234567890";
	private static String lowerCase = "abcdefghijklmnopqrstuvwxyz";
	private static String upperCase = "ABCDEFGHIJLMNOPQRSTUVWXYZ";
	private static String specialChar = "~`!@#$%^&*()-_=+[]{};':,.|<>/?";
	
    private static final SecureRandom secureRandom = new SecureRandom();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("========PASSWORD GENERATOR========");
		int length = getPasswordLength(scanner);
		
		boolean includeUpperCase = getBooleanInput(scanner , "Would you like to include UpperCase letters? (Y/N): ");
		boolean includeLowerCase = getBooleanInput(scanner , "Would you like to include LowerCase letters? (Y/N): ");
		boolean includeDigits = getBooleanInput(scanner , "Would you like to include Digits ? (Y/N): ");
		boolean includeSpecialChars = getBooleanInput(scanner , "Would you like to include Special Characters? (Y/N): ");
	
		if(!includeUpperCase && !includeLowerCase && !includeDigits && !includeSpecialChars) {
			System.err.println("Error: You must select at least one character type. Exiting.");
			return;
		}

		String password = generatePassword(length, includeUpperCase, includeLowerCase, 
            includeDigits, includeSpecialChars);

		System.out.println("\nGenerated Password: " + password);
		System.out.println("==================================");

		scanner.close();	
	}

	private static int getPasswordLength(Scanner scanner) {
		int length = 0;
		while(length <= 0) {
			try {
				System.out.print("Enter desired password length: ");
				length = Integer.parseInt(scanner.nextLine());
				if(length <= 0) {
					System.out.println("Length must be a positive number.");
				}
			}catch(NumberFormatException e) {
				System.out.println("Invalid Input! please enter a number");
			}
		}
		return length;
	}

	private static boolean getBooleanInput(Scanner scanner, String prompt) {
		String input;
		while(true) {
			System.out.print(prompt);
			input = scanner.nextLine().trim();
			if(input.equalsIgnoreCase("y")) {
				return true;
			}else if(input.equalsIgnoreCase("n")){
				return false;
			}
		}
	}
	
	public static String generatePassword(int length,
			boolean includeUppercase, 
            boolean includeLowercase, 
            boolean includeDigits, 
            boolean includeSpecialChars) {
		
		StringBuilder charPool = new StringBuilder();
		if(includeUppercase) charPool.append(upperCase);
		if(includeLowercase) charPool.append(lowerCase);
		if(includeDigits) charPool.append(digits);
		if(includeSpecialChars) charPool.append(specialChar);
		
		List<Character> passwordChars = new ArrayList<>();
		
		if(includeUppercase) passwordChars.add(getRandomChar(upperCase));
		if(includeLowercase) passwordChars.add(getRandomChar(lowerCase));
		if(includeDigits) passwordChars.add(getRandomChar(digits));
		if(includeSpecialChars) passwordChars.add(getRandomChar(specialChar));
		
		int remainingLength = length - passwordChars.size();
		if(remainingLength < 0 ) remainingLength = 0;
		
		IntStream.range(0, remainingLength)
				 .mapToObj(i -> getRandomChar(charPool.toString()))
				 .forEach(passwordChars::add);
		
		Collections.shuffle(passwordChars, secureRandom);
		
		return passwordChars.stream()
							.map(String::valueOf)
							.collect(Collectors.joining());
	}
	
	private static char getRandomChar(String charSet) {
		int index = secureRandom.nextInt(charSet.length()); 
		return charSet.charAt(index);
	}
}


