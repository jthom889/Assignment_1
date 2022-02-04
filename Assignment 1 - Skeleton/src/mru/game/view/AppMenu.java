package mru.game.view;
import java.util.Scanner;


public class AppMenu {

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	
	/**
	 * this method will print the main menu portion of the interface
	 */
	public void mainMenu() {
		
		//prints the prompt message for the user
		System.out.println("Select one of these options:");
		System.out.println();
		System.out.printf("\t (P) Play game\n ");
		System.out.printf("\t (S) Search\n ");
		System.out.printf("\t (E) Exit\n ");
		System.out.println();
		System.out.println("Enter a choice: ");
		
		
	}
	
	/**
	 * this method will call the mainMenu method and
	 * validate the users input
	 * @return the users valid input c1
	 */
	public String mainInput() {
		
		//creates scanner object
		Scanner keyboard = new Scanner(System.in);
		
		//declare return variable
		String c1 = "";
		
		
		//loop that takes users choice and makes sure choice is valid
		while(true) {
			
			//calls main menu
			mainMenu();
			
			//saves user input
			c1 = keyboard.next();
			
			//if cases for each of the acceptable letters
			if(c1.equals("P")|| c1.equals("p")) 
				break;
			
			else if(c1.equals("S")|| c1.equals("s")) 
				break;
			
			else if(c1.equals("E")|| c1.equals("e")) 
				break;
			
			//else case if the users input isn't valid
			else
				System.out.println("Please enter a valid character");
			
		}
		return c1;
	}
	
	/**
	 * this method prints the search menu of the interface
	 */
	public void searchMenu() {
		
		//prints the prompt message for the user
		//prints the prompt message for the user
		System.out.println("Select one of these options:");
		System.out.println();
		System.out.printf("\t (T) Top player(Most number of wins)\n ");
		System.out.printf("\t (N) Looking for a Name\n ");
		System.out.printf("\t (B) Back to Main menu\n ");
		System.out.println();
		System.out.println("Enter a choice: ");
		
	}
	
	/**
	 * this method will call the search method and 
	 * accept and validate the users input for that section
	 * @return the users valid input c2
	 */
	public String searchInput() {
		
		//creates scanner object
		Scanner keyboard = new Scanner(System.in);
		
		//declare return variable
		String c2 = "";
		
		
		//loop that takes users choice and makes sure choice is valid
		while(true) {
			
			//calls search menu
			searchMenu();
			
			//saves user input
			c2 = keyboard.next();
			
			//if cases for each of the acceptable letters
			if(c2.equals("T")|| c2.equals("t")) 
				break;
			
			else if(c2.equals("N")|| c2.equals("n")) 
				break;
			
			else if(c2.equals("B")|| c2.equals("b")) 
				break;
			
			//else case if the users input isn't valid
			else
				System.out.println("Please enter a valid character");
			
		}
		return c2;
	}
	
}
