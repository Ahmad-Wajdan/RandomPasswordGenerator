package com.level1;
import java.util.Scanner;

public class Palindrome {
	public static boolean isPalindrome(String str) {
		int n = str.length();
		for(int i=0; i < n / 2; i++) {
			if(str.charAt(i) != str.charAt(n - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String sc = scanner.next();

		System.out.println( sc + " is palindrome: " + isPalindrome(sc));
		scanner.close();
	}
}
