package com.level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileCipher {
	
	private static char encryptChar(char character, int key) {
		return (char) ((character + key) % 256);
	}
	
	private static char decryptChar(char character, int key) {
		return (char) ((character - key + 256) % 256);
	}
	
	public static void processFile(char operation, String inputFilePath, String outputFilePath, int key)
	throws IOException{
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
	         BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))){
			int charCode;
            // Read character by character until the end of the file (-1)
            while ((charCode = reader.read()) != -1) {
                char originalChar = (char) charCode;
                char processedChar;

                if (operation == 'E') {
                    processedChar = encryptChar(originalChar, key);
                } else { // operation == 'D'
                    processedChar = decryptChar(originalChar, key);
                }
                writer.write(processedChar);
            }
            System.out.println("File processing complete. Result saved to: " + outputFilePath);
		}catch(IOException e) {
			System.err.print("An I/O error occured: " + e.getMessage());
			throw e;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("==== File Encryption/Decryption Program ====");
		
		char operation = ' ';
		while(operation != 'E' && operation != 'D') {
			System.out.print("Do you want to (E)ncrypt or (D)ecrypt? Enter E or D: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.length() == 1) {
                operation = input.charAt(0);
            }
            if (operation != 'E' && operation != 'D') {
                System.out.println("Invalid choice. Please enter 'E' or 'D'.");
            }
		}
		System.out.print("Enter the path of the input text file: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Enter the path for the output text file: ");
        String outputFilePath = scanner.nextLine();

        int key = 0;
        boolean validKey = false;
        while (!validKey) {
            try {
                System.out.print("Enter the integer key (e.g., 3 for Caesar cipher): ");
                key = scanner.nextInt();
                validKey = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer for the key.");
                scanner.next(); 
            }
        }
        scanner.nextLine();
        
        try {
            processFile(operation, inputFilePath, outputFilePath, key);
        } catch (IOException e) {
            System.err.println("Failed to process file. Please check file paths and permissions.");
        } finally {
            scanner.close();
        }
	}
}
