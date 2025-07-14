package com.level1;

import java.util.Scanner;

public class StudentGradeCalculator {
	
	
	
	public static void main(String[] args) {
		StudentGradeCalculator details = new StudentGradeCalculator();
		
		int marks[] = new int[5];
		int i;
		float total=0, avg;
		Scanner sc = new Scanner(System.in);
		
		for(i=0;i<5;i++) {
			System.out.print("Enter Marks of Subject"+(i+1)+":");
			marks[i] = sc.nextInt();
			total += marks[i];
		}
		sc.close();
		
		avg = total/5;
		System.out.print("The Student Grade is : ");
		if(avg >= 90) {
			System.out.print("O");
		}else if(avg >=80 && avg<= 90){
			System.out.print("A+");
		}else if(avg >=70 && avg<= 80){
			System.out.print("A");
		}else if(avg >=60 && avg<= 70){
			System.out.print("B+");
		}else if(avg >=50 && avg<= 60){
			System.out.print("B");
		}else if(avg >=40 && avg<= 50){
			System.out.print("C");
		}else {
			System.out.print("D");
		}
	}
}
