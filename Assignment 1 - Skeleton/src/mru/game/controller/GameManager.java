package mru.game.controller;

import mru.game.model.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import mru.game.view.AppMenu;



/**
 * the class that sets up the outline of the game and the menus
 * @author Jonah Thompson
 *
 */
public class GameManager {
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */

	private final String FILE_PATH = "res/CasinoInfo.txt";
	ArrayList<Player> players;
	AppMenu appMen; 
	Scanner keyboard;
	
	/**
	 * game manager constructor
	 * @throws Exception
	 */
	public GameManager() throws Exception {
		
		players = new ArrayList<Player>();
		appMen = new AppMenu();
		keyboard = new Scanner(System.in);
		loadData();
		launchApplication();
		
	}
	
	/**
	 * this method is how the game comes back to the menu
	 * @throws FileNotFoundException
	 */
	private void launchApplication() throws FileNotFoundException {
		
		String option = null;
		 boolean running = true;
		 
		 while (running) {
			 option = appMen.mainMenu();
			 if(option.equals("P")|| option.equals("p")) 
					playGame();
						
				else if(option.equals("S")|| option.equals("s")) 
					search();
				
				else if(option.equals("E")|| option.equals("e")) {
					exit();
					break;
				}
		 }
		
	}

	/**
	 * the method that starts the game from the main menu
	 */
	private void playGame() {
		
		
	}

	/**
	 * the search method for the sub menu
	 */
	public void search() {
		
		//declare variables
		String option = appMen.searchMenu();
		Player ply = null;
		
		//if cases for each of the acceptable letters
		if(option.equals("T")|| option.equals("t")) 
			topPlayer();
		
		else if(option.equals("N")|| option.equals("n")) {
			ply = nameOfPlayer();
			appMen.playerInfo(ply);
		}
			
		else if(option.equals("B")|| option.equals("b")) {
			
		}
			
		
		
	}

	/**
	 * this method makes the name search sub menu
	 * @return
	 */
	public Player nameOfPlayer() {
	
		//declare variables
		String name = appMen.promptName();
		Player ply = null;
		
		//for loop to find name of desired player
		for(Player p: players) {
			
			if(p.getName().equals(name)) {
				ply = p;
				break;
			}
		}
		return ply;
		
	}

	/**
	 * this method sets up the top player UI
	 */
	public void topPlayer() {
		
		//declare variables
		int highWin = 0;
		int highWin2 = 0;
		String nameHigh = null;
		String nameHigh2 = null;
		String space = " ";
		
	
		//sort through each player to determine the top player
		for(Player p: players) {
			
			//determine if this player is the top player and setting their values
			if(p.getWins() > highWin) {				
				
				//declaring the  highest players variables
				nameHigh = p.getName();
				highWin = p.getWins();
			}
		}
		
		//loop to determine the second highest player
		for(Player p: players) {
			
			//sorts out the second highest player
			if(p.getWins() > highWin2 && p.getWins() < highWin) {
				
				//declaring the second top users variables
				nameHigh2 = p.getName();
				highWin2 = p.getWins();
				
			}
			
		}
		
		//printing the formatted output
		System.out.println("            - TOP PLAYERS -");
		System.out.println("+==================+==================+");
		System.out.println("|NAME              |# WINS            |");
		System.out.println("+==================+==================+");
		System.out.println( "|" +  nameHigh + space.repeat(18 - nameHigh.length())+ "|" + highWin + 
				space.repeat(18 - String.valueOf(highWin).length())+"|");
		System.out.println("+==================+==================+");
		System.out.println("|" +  nameHigh2 + space.repeat(18 - nameHigh2.length())+ "|" + highWin2 + 
				space.repeat(18 - String.valueOf(highWin2).length())+"|");
		System.out.println("+==================+==================+");
		System.out.println("");
		System.out.println("Press \"Enter\" to continue... ");
		
		//make it so that the user can look at the table before returning to the menu
		keyboard.nextLine();
	}

	/**
	 * this method sets up the exit UI and goes back to the main menu
	 * @throws FileNotFoundException
	 */
	private void exit() throws FileNotFoundException  {
		
		//declare variables
		File db = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(db);
		
		//prints the players back into the file
		for(Player p: players) {
			pw.print(p.format());
		}
		
		pw.close();
	}

	/**
	 * this method loads the data from the file into an arrayList of players
	 * @throws Exception
	 */
	public void loadData() throws Exception {
		
		//declare variables
		File playerInfo = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		Scanner fileReader = null;
		
		if(playerInfo.exists()) {
			
			fileReader = new Scanner(playerInfo);
			
			//loop that makes lines from file into an arrayList of players
			while(fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				Player p = new Player(splittedLine[0],Double.parseDouble(splittedLine[1]),
						Integer.parseInt(splittedLine[2]));
				players.add(p);
				
			}
			
		}
		//if file cannot be found
		else
			System.out.println("File not found");
		
		fileReader.close();
	}
	
	
	

}
