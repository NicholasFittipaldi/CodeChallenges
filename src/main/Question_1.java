package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_1 {
	public static void doesFileExist(String path) throws FileNotFoundException,  IOException {
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		reader.close();
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the file name or file path.");
		String path = scan.next();
		
		try {
			doesFileExist(path);
			
			String string;
			File file = new File(path);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while ((string = reader.readLine()) != null) {
				String[] stringArray = string.split("-");
				ArrayList<String> arrayList = new ArrayList<>();
				
				arrayList.add(stringArray[0]);
				
				if (stringArray[1].contains(",")) {
					int size = stringArray[1].split(",").length;
					
					for (int i = 0; i < size; i++)
						arrayList.add(stringArray[1].split(",")[i]);
				}
				else 
					arrayList.add(stringArray[1]);
				
				for (String s : arrayList)
					System.out.println(s);
			}
			reader.close();
			scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("I'm sorry, that file or path does not exist, "
					+ "\nplease try a different file name or path.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
