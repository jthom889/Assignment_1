package mru.game.view;
import java.util.Scanner;

import mru.game.model.Player;

/**
 * this class provides the methods that sort out parts of the menus 
 * @author Jonah Thompson
 *
 */
public class AppMenu {
	
	Scanner keyboard;
	Player p;

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	
	public AppMenu() {
		keyboard = new Scanner(System.in);
		p = new Player("", 0, 0);
	}
	
	/**
	 * this method will print the main menu portion of the interface
	 */
	public String mainMenu() {
		
		//prints the prompt message for the user
		System.out.println("Select one of these options:");
		System.out.println();
		System.out.printf("\t (P) Play game\n ");
		System.out.printf("\t (S) Search\n ");
		System.out.printf("\t (E) Exit\n ");
		System.out.println();
		System.out.println("Enter a choice: ");

		String option;
		
		//loop that takes users choice and makes sure choice is valid
		while(true) {
					
			option = keyboard.nextLine();
					
			//if cases for each of the acceptable letters
			if(option.equals("P")|| option.equals("p")) 
				break;
					
			else if(option.equals("S")|| option.equals("s")) 
				break;
			
			else if(option.equals("E")|| option.equals("e")) 
				break;
			
			//else case if the users input isn't valid
			else
				System.out.println("Please enter a valid character");		
		}
		return option;
	}
	
	
	/**
	 * this method prints the search menu of the interface
	 */
	public String searchMenu() {
		
		//prints the prompt message for the user
		//prints the prompt message for the user
		System.out.println("Select one of these options:");
		System.out.println();
		System.out.printf("\t (T) Top player(Most number of wins)\n ");
		System.out.printf("\t (N) Looking for a Name\n ");
		System.out.printf("\t (B) Back to Main menu\n ");
		System.out.println();
		System.out.println("Enter a choice: ");
		
		String option;
		
		//loop that takes users choice and makes sure choice is valid
		while(true) {
					
			option = keyboard.nextLine();
				
			//if cases for each of the acceptable letters
			if(option.equals("T")|| option.equals("t")) 
				break;
			
			else if(option.equals("N")|| option.equals("n")) 
				break;
				
			else if(option.equals("B")|| option.equals("b")) 
				break;
					
			//else case if the users input isn't valid
			else
				System.out.println("Please enter a valid character");
		}
		
		return option;
	}
	
	/**
	 * this method prints the search menu of the interface
	 */
	public String betMenu() {
		
		//prints the prompt message for the user
		//prints the prompt message for the user
		System.out.println("Who do you wish to bet on:");
		System.out.println();
		System.out.printf("\t (P) Player Wins\n ");
		System.out.printf("\t (B) Banker Wins\n ");
		System.out.printf("\t (T) Tie Game\n ");
		System.out.println();
		System.out.println("Enter a choice: ");
		
		String option;
		
		//loop that takes users choice and makes sure choice is valid
		while(true) {
					
			option = keyboard.nextLine();
				
			//if cases for each of the acceptable letters
			if(option.equals("P")|| option.equals("p")) 
				break;
			
			else if(option.equals("B")|| option.equals("b")) 
				break;
				
			else if(option.equals("T")|| option.equals("t")) 
				break;
					
			//else case if the users input isn't valid
			else
				System.out.println("Please enter a valid character");
		}
		
		return option;
	}
	
	/**
	 * prompts the user for name
	 * @return the name the user inputs
	 */
	public String promptName() {
		System.out.print("What is your name? ");
		String name = keyboard.nextLine();
		return name;
	}
	
	public void playerInfo(Player ply) {
		
		System.out.println(ply.playerInfo());
		}

	/**
	 * identifies the player's name before starting game
	 * @return the name of the player
	 */
	public String identifyPlayer() {
		System.out.print("What is the player's name?");
		String name = keyboard.nextLine();
		return name;
	}
	
}
	
	

