import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Items {

	static HashSet<String> dup;


	public Items() {

		dup = new HashSet<String>();

	}

	/**
	 * Adds an item that the user has typed to the Array List
	 * @param scanner - Used for user input
	 * @return - true if successful & false if not successful
	 */

	public boolean addItem(Scanner scanner) {



		String item; // Item to be added

		System.out.print("Enter an item -> ");

		if(scanner.hasNext(Pattern.compile("[A-Za-z]+"))) { // Checks to see whether the input is alphabetical

			item = scanner.nextLine(); // User input for item to be added

			String output = item.substring(0,1).toUpperCase() + item.substring(1).toLowerCase();

			if(dup.contains(output)) {

				System.out.println("Duplicate value. Cannot add.");
				return false;

			} else {

				dup.add(output);
				System.out.println("Item " + output + " successfully added" );
				return true;
			}



		}
		else {

			System.out.println("Only letters can be added. No numbers.");
			scanner.next();
			return false;


		}



	}

	public void deleteItem(Scanner scanner) {
		String item;
		System.out.print("Enter an item to delete: ");
		item = scanner.nextLine();
		if(dup.contains(item)) {
			dup.remove(item);
			System.out.println("Successfully removed " + item);

		}
		else {
			System.out.println("Cannot remove item because it is not in the list");

		}

	}
	public void displayItems() {
		//make only first letter caps

		if(dup.isEmpty()) {
			System.out.println("Nothing items in the list");
		}

		java.util.Iterator<String> itr = dup.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public boolean searchItem(Scanner scanner) {
		String item;
		System.out.print("Enter an item to search for: ");
		item = scanner.nextLine();

		if(dup.contains(item)) {
			System.out.println("Item is in the list");
			return true;
		}	else {
			return false;
		}


	}

	public void saveItem(Scanner scanner) throws IOException {
		System.out.println("Enter file name to save:");
		String filename = scanner.next();
		BufferedWriter write = new BufferedWriter(new FileWriter(filename));
		java.util.Iterator<String> itr = dup.iterator();

		while(itr.hasNext()) {
			write.write(itr.next() + "\n");
		}

		write.close();
	}

	public void readFile(Scanner scanner) throws IOException {
		try {
			String line;

			System.out.println("Enter a file name:");
			String name = scanner.next();
			BufferedReader buffer = new BufferedReader(new FileReader(name));

			while((line = buffer.readLine()) != null) {
				System.out.println(line);

			}
			buffer.close();
		} catch(java.io.FileNotFoundException e) {
			System.out.println("File not found.");
		}
	}

}


