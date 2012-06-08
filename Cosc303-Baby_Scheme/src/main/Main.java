package main;

import java.util.Scanner;


public class Main {
	public static void main(String[] args){
	//Simple input/output for calculator.
      System.out.println("+++++++Team_Hond_Bang+++++++");
		Scanner scan = new Scanner(System.in);
		The_Scheminator n = new The_Scheminator(); 
		while (true){
			System.out.println("Please enter a 'Baby Scheme' prefix notation expression to evaluate:");
			String s = scan.nextLine();
			System.out.println("Output: " + n.terminate(s));
			System.out.println();
			System.out.println("Wanna evaluate another expression?(enter Y for yes or N for no)");
			s = scan.nextLine();
			if (s.toUpperCase().equals("N")) break;
			
			
		}
		
	}
}
