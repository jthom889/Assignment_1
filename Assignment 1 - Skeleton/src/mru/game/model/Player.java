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
		return name + "," + balance + "," + wins + "\n";
	}
	
	/**
	 * the output that is used for the player search
	 * @return 
	 */
	public String playerInfo() {
		String space = " ";
		String name = getName();
		double balance = getBalance();
		int wins = getWins();		
		
		//System.out.println
		return "+==============+==============+==============+\n" + 
		"|NAME          |# WINS        |BALANCE       |\n" + "+==============+==============+==============+\n" 
				+ "|" + name + space.repeat(14 - name.length()) + "|"+ wins + space.repeat(14 - String.valueOf(wins).length())
				+ "|" + "$" + balance + space.repeat(13 - String.valueOf(balance).length()) + "|\n" +
				"+==============+==============+==============+";
		//System.out.println();
		//System.out.println();
		//System.out.println();
		//System.out.println();
	}
	
}
