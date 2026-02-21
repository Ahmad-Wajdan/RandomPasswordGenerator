package com.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
	private static final Pattern upperCase = Pattern.compile(".*[A-Z].*");
	private static final Pattern lowerCase = Pattern.compile(".*[a-z].*");
	private static final Pattern digit = Pattern.compile(".*\\d.*");
	private static final Pattern specialChar = Pattern.compile(".*[^a-zA-Z0-9 ].*");
	
	private static final int minLength = 8;
	private static final int goodLength = 12;
	private static final int excellentLength = 16;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("======= PASSWORD STRENGTH CHECKER =======");
		System.out.print("Enter your password:  ");
		String password = scanner.nextLine();
		
		analyzePassword(password);
		scanner.close();
	}
	
	public static void analyzePassword(String password) {
		int score = 0;
		List <String> feedback = new ArrayList<>();
		
		int length = password.length();
		feedback.add("Password Length: " + length + " characters");
		if(length < minLength) {
			feedback.add("Feedback: Password is too short. Aim for at Least "+ minLength + " charcters");
		}else if(length < goodLength) {
			score+=1;
			feedback.add("Feedback: Good length, but consider making it longer for better security. ");
		}else if(length < excellentLength) {
			score+=2;
			feedback.add("Feedback: Very good length!");
		}else {
			score+=3;
			feedback.add("Feedback: Excellent length!");
		}
		
		if(upperCase.matcher(password).matches()) {
			score += 1;
			feedback.add(" Conatins uppercase letter");
		}else {
			feedback.add(" Missing uppercase letters. Add some for stronger security");
		}
		
		if(lowerCase.matcher(password).matches()){
			score += 1;
			feedback.add(" Conatins lowercase letter");
		}else {
			feedback.add(" Missing lowercase letters. Add some for stronger security");
		}
		
		if(digit.matcher(password).matches()) {
			score += 1;
			feedback.add(" Contains Number");
		}else {
			feedback.add(" Missing numbers. Add some for stronger security");
		}
		
		if(specialChar.matcher(password).matches()) {
			score += 1;
			feedback.add(" Contains Special Characters");
		}else {
			feedback.add(" Missing special characters (e.g., !@#$%^&*). Add some for stronger security");
		}
	
		System.out.println("\n=== Analysis Results ===");
		for (String item : feedback) {
			System.out.println(item);
		}
		
		System.out.println("\n=== overall Strength ===");
		String strengthLevel;
		if(length < minLength) {
			strengthLevel = "Very Weak (Too Short)";
		}else if(score <= 2) {
			strengthLevel = "Weak";
		}else if(score == 3) {
			strengthLevel = "Moderate";
		}else if(score == 4) {
			strengthLevel = "Strong";
		}else {
			strengthLevel = "Very Strong";
		}
		
		System.out.println("Password Strength: " + strengthLevel);
		System.out.println("Score : " + score + " (Max score based on criteria : 5 + length bonus)");
		System.out.println("========================================");
	}
}
