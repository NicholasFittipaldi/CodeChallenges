package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Question_3 {
	
	public static void printSmallestNumber(ArrayList<Integer> array, int index) {
		Collections.sort(array);
		System.out.println("Smallest number at position " + (index + 1) 
				+ ": " + array.get(index));
	}

	public static void main(String[] args) {
		Random random = new Random();
		ArrayList<Integer> array = new ArrayList<>();
		boolean bool = true;
		
		while (bool) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter a number between 1 and 500.");
			int index = scan.nextInt();
		
			if (index > 500 || index < 1)
				System.out.println("You have entered a number outside the range of 1 to 500, "
						+ "\nplease enter a different number.\n");
			else {
				for (int i = 1; i <= 500; i++) 
					array.add(random.nextInt());
			
				printSmallestNumber(array, index - 1);
				
				scan.close();
				bool = false;
			}
		}
	}
}
