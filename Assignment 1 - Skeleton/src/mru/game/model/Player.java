package mru.game.model;

/**
 * this class sets up the Player object
 * @author Jonah Thompson
 *
 */
public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	//declare values of Player class
	private String name;
	private double balance;
	private int wins;
	
	
	
	/**
	 * this method is the constructor for the Player class
	 * @param n is the name
	 * @param b is the balance
	 * @param w is the number of wins
	 */
	public Player(String n, double b, int w) {
		
		//setting variables equal to the corresponding variables
		name = n;
		setBalance(b);
		setWins(w);
	}
	
	/**
	 * gets the name of the user
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the name of the user
	 * @param n is the name
	 */
	public void setName(String n) {
		name = n;		
	}

	/**
	 * gets the balance of the player
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * sets the balance of the user
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * gets the number of wins
	 * @return the number of wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * sets the number of wins a user has
	 * @param wins
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	/**
	 * to string method
	 * @return a string output
	 */
	public String toString() {
		return "Name: " + name + "Balance: " + balance + "Number of wins: " + wins;
	}
	
	/**
	 * to string method that returns a formatted return for the file
	 * @return formatted output
	 */
	public String format() {
		return name + "," + balance + "," + wins;
	}
	
	/**
	 * the output that is used for the player search
	 */
	public void playerInfo() {
		String space = " ";
				
		System.out.println("+==============+==============+==============+");
		System.out.println("|NAME          |# WINS        |BALANCE       +");
		System.out.println("+==============+==============+==============+");
		System.out.println("|" + name + space.repeat(name.length() - 14) + "|"+ wins + space.repeat(String.valueOf(wins).length()-14)
				+ balance + space.repeat(String.valueOf(balance).length()-14));
		System.out.println("+==============+==============+==============+");
	}
	
}
