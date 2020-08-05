import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Grocery {
	static Scanner input = new Scanner(System.in);
	static Scanner enter = new Scanner(System.in);



	public static void main(String[]args) throws IOException {
		Items item = new Items();
		boolean isvalid = true;
		int choice = 0;

		while (isvalid) {
			displayMenu();
			System.out.print(">");
			if(input.hasNext(Pattern.compile("[1-7]"))) {

				if(input.hasNextInt()) {
					choice = input.nextInt();


					if(choice == 1) {

						item.addItem(enter);
						enter = new Scanner(System.in); // Clears the buffer for the scanner

					}
					else if(choice == 2) {

						item.deleteItem(enter);
						enter = new Scanner(System.in); // Clears the buffer for the scanner

					}
					else if(choice == 3) {
						item.displayItems();

					}
					else if(choice == 4) {

						if(item.searchItem(enter)) {
							enter = new Scanner(System.in);
						} else {
							System.out.println("Item is not in the list");
						}
					}
					else if(choice == 5) {
						item.saveItem(enter);
						enter = new Scanner(System.in);

					}


					else if(choice == 6) {
						item.readFile(enter);
						enter = new Scanner(System.in);

					}
					else if (choice == 7) {

						System.out.println("Exiting...");
						isvalid = false;

					}

				} else {
					System.out.println("Invalid entry");
					isvalid = true;
					input.next();
				}


			} else {
				System.out.println("Invalid entry");
				isvalid = true;
				input.next();

			}
		}

	}









	public static void displayMenu() {

		System.out.println("1) Add item");
		System.out.println("2) Delete item");
		System.out.println("3) Print item list");
		System.out.println("4) Search for item");
		System.out.println("5) Save to file");
		System.out.println("6) Read from file");
		System.out.println("7) Exit");

	}




}
