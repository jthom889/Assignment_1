package mru.game.controller;

//import java.util.Scanner;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 * @param ply 
	 * @throws Exception 
	 */
	public void runGame(int betNum, int bet, int balance, int winNum)
	{
		//Scanner input = new Scanner(System.in);
		String[] playerHand = new String[3];
		String[] bankerHand = new String[3];
		final int MAXIMUM_HAND = 2;
		int results;
		int playerPts = 0;
		int bankerPts = 0;
		int cardVal;
		int pThird = 0;
		int bets = betNum;
		int wager = bet;
		int bal = balance;
		int wins = winNum;
		
		CardDeck myDeck = new CardDeck();
		
		//initial drawing phase
		//draws two random cards for the player
		for (int p = 0; p < 2; p++) {
			Card playerCards = draw(myDeck);
			playerHand[p] = playerCards.toString();
			cardVal = playerCards.getRank();
			playerPts += cardValue(cardVal);
		}
		playerPts = sumPoints(playerPts);  //determines the worth of the cards in the player's hand
		
		//draws two random cards for the banker
		for(int b = 0; b < 2; b++) {
			Card bankerCards = draw(myDeck);
			bankerHand[b] = bankerCards.toString();
			cardVal = bankerCards.getRank();
			bankerPts += cardValue(cardVal);
		}
		bankerPts = sumPoints(bankerPts);   //determines the worth of the cards in the banker's hand
		
		//third card drawing phase
		//determine if the player will draw a third card
		if(playerPts <= 5) {
			Card playerCards = draw(myDeck);
			playerHand[MAXIMUM_HAND] = playerCards.toString();
			pThird = playerCards.getRank();
			cardVal = pThird;
			playerPts += cardValue(cardVal);
			playerPts = sumPoints(playerPts);
			
			//determine based on player's third card if banker will draw also
			if(bankersDraw(pThird, bankerPts)) {
				Card bankerCards = draw(myDeck);
				bankerHand[MAXIMUM_HAND] = bankerCards.toString();
				cardVal = bankerCards.getRank();
				bankerPts += cardValue(cardVal);
			}
			checkPlayerNull(playerHand);   //check for any null elements in the player's hand
			checkBankerNull(bankerHand);   //check for any null elements in the banker's hand
			results = winCondition(playerPts, bankerPts);
			setOutcome(results, playerHand, bankerHand, playerPts, bankerPts);
			betWon(results, bets, wager, bal, wins);
		}
		else if(playerPts >= 6 && bankerPts <= 5) {
			Card bankerCards = draw(myDeck);
			bankerHand[MAXIMUM_HAND] = bankerCards.toString();
			cardVal = bankerCards.getRank();
			bankerPts += cardValue(cardVal);	
			checkPlayerNull(playerHand);   //check for any null elements in the player's hand
			checkBankerNull(bankerHand);   //check for any null elements in the banker's hand
			results = winCondition(playerPts, bankerPts);
			setOutcome(results, playerHand, bankerHand, playerPts, bankerPts);
			betWon(results, bets, wager, bal, wins);
		}
		//checks if the sum of either player or banker's hand equals to a natural win
		else if(checkNatural(playerPts) || checkNatural(bankerPts)) {   
			checkPlayerNull(playerHand);   //check for any null elements in the player's hand
			checkBankerNull(bankerHand);   //check for any null elements in the banker's hand
			results = winCondition(playerPts, bankerPts);
			setOutcome(results, playerHand, bankerHand, playerPts, bankerPts); 
			betWon(results, bets, wager, bal, wins);
		}	
		//GameManager gm = new GameManager();
		//System.out.println("Do you wish to play again? (Y/N)");
		//String option = input.nextLine();
		//if(option.equals("Y")||option.equals("y")) {
		//	gm.playGame();
		//}
		//else if(option.equals("N")||option.equals("n")) {
		//	System.out.println("Thank you for playing!");
		//}
	}
		
	
	/**
	 * Displays message if the bet that was placed was won or lost
	 * @param results Decides whether the Player, Banker wins or is a tie game
	 * @param bets Decides whether the bet that was placed was won or lost
	 * @param wager The amount of money that was bet
	 * @param bal The total balance
	 */
	public void betWon(int results, int bets, int wager, int bal, int win) {
		//The Player wins
		if(results == 1 && bets == 1) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("      PLAYER WON $"+wager+"     ");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			bal = bal+wager;
			win++;
			System.out.println("New Balance: $"+bal+"  || Wins: "+win);
			System.out.println("");
		}
		//The Banker wins
		else if(results == 3 && bets == 3) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("      PLAYER WON $"+wager+"     ");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			bal = bal+wager;
			win++;
			System.out.println("New Balance: $"+bal+"  || Wins: "+win);
			System.out.println("");
		}
		//The game was a tie
		else if(results == 2 && bets == 2) {
			bal = (wager*5);
			win++;
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("      PLAYER WON $"+(wager*5)+"     ");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("New Balance: $"+bal+"  || Wins: "+win);
			System.out.println("");
		}
		//The bet was lost
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("      PLAYER LOST $"+wager+"    ");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			bal = bal-wager;
			System.out.println("New Balance: $"+bal+"  || Wins: "+win);
			if(bal <= 0) {
				System.out.print("You are now bankrupt... Game Over!\n");
				System.out.println("");
			}
		}
		
	}
	
	/**
	 * Correctly reallocates card values to align with the standards of PuntoBanco
	 * by reassigning card values 10 and face cards to zero
	 * @param cardVal the value of the card that is drawn
	 * @return reassigned card values for cards valued 9 or higher
	 */
	public int cardValue (int cardVal) {
		int realVal = 0;
		if(cardVal > 9) {   
			cardVal = realVal;
		}
		return cardVal;
	}
	
	/**
	 * Prints the outcome of the game
	 * @param results
	 * @param playerHand
	 * @param bankerHand
	 * @param playerPts
	 * @param bankerPts
	 */
	public void setOutcome(int results, String[] playerHand, String[] bankerHand, int playerPts, int bankerPts) {
		String outcome = "";
		String data1 = "PLAYER POINTS: "+playerPts;
		String data2 = "BANKER POINTS: "+bankerPts;
		String space = " ";
		
		//prints the correct response depending on the integer of outcome
		switch(results) {
		case 1: outcome = "~~ PLAYER WINS ~~"; break;
		case 2: outcome = "~~ TIE GAME ~~"; break;
		case 3: outcome = "~~ BANKER WINS ~~"; break;
		}
		System.out.println("+==========================+==========================+");
		System.out.println("|          PLAYER          |          BANKER          |");
		System.out.println("+==========================+==========================+");
		System.out.println( "|" +  playerHand[0] + space.repeat(26 - playerHand[0].length())+ "|" + bankerHand[0] + 
				space.repeat(26 - String.valueOf(bankerHand[0]).length())+"|");
		System.out.println("+--------------------------+--------------------------+");
		System.out.println( "|" +  playerHand[1] + space.repeat(26 - playerHand[1].length())+ "|" + bankerHand[1] + 
				space.repeat(26 - String.valueOf(bankerHand[1]).length())+"|");
		System.out.println("+--------------------------+--------------------------+");
		System.out.println( "|" +  playerHand[2] + space.repeat(26 - playerHand[2].length())+ "|" + bankerHand[2] + 
				space.repeat(26 - String.valueOf(bankerHand[2]).length())+"|");
		System.out.println("+--------------------------+--------------------------+");
		System.out.println( "|" +  data1 + space.repeat(26 - data1.length())+ "|" + data2 + 
				space.repeat(26 - String.valueOf(data2).length())+"|");
		System.out.println("+==========================+==========================+");
		System.out.println("|" +space.repeat(35 - outcome.length())  +outcome + space.repeat(35 - outcome.length())+ "|");
		System.out.println("+==========================+==========================+\n");
		
	}
	
	/**
	 * Determines the results of the game by comparing which party
	 * has a higher number than the other
	 * (1 = Player wins, 2 = Tie game, 3 = Banker wins)
	 * @param playerPts the sum of the player's hand
	 * @param bankerPts the sum of the banker's hand
	 * @return integer which determines the outcome of the game 
	 */
	public int winCondition (int playerPts, int bankerPts) {
		int win = 0;

		if(playerPts > bankerPts) {
			return win = 1;
		}
		else if(playerPts == bankerPts) {
			return win = 2;
		}
		else if(playerPts < bankerPts){
			return win = 3;			
		}
		return win;
	}
	
	/**
	 * Loops through every element of the Player Hand array 
	 * and replaces any null values with an empty String
	 * @param playerHand String array of cards drawn
	 * @return playerHand array with no null values
	 */
	public String[] checkPlayerNull(String[]playerHand) {
		for(int i = 0; i<=playerHand.length-1; i++) {
			if (playerHand[i] == null) {
				playerHand[i] = "";
			}
		}
		return playerHand;
	}

	/**
	 * Loops through every element of the Banker Hand array 
	 * and replaces any null values with an empty String
	 * @param bankerHand String array of cards drawn
	 * @return bankerHand array with no null values
	 */
	public String[] checkBankerNull(String[]bankerHand) {
		for(int i = 0; i<=bankerHand.length-1; i++) {
			if (bankerHand[i] == null) {
				bankerHand[i] = "";
			}
		}
		return bankerHand;
	}
	
	
	/**
	 * Detects if the point sums for the player or banker equals to
	 * an Egalite, or Natural Win
	 * @param pointSum the sum of points belonging to either the player or the banker
	 * @return a boolean to flag whether a natural win has occurred
	 */
	public boolean checkNatural (int pointSum) {
		if(pointSum == 8 || pointSum == 9) {
			return true;
		}
		return false;
	}
	
	/**
	 * Evaluates the value, or rank, of the player's third card and the sum
	 * of the banker's initial two cards to determine if the banker draws a third card.
	 * 
	 * The instruction states that the banker draws if player draws a 7, but it also states 
	 * that the banker stands if the player draws a 7, so an assumption is made so that 
	 * if the player draws 7, the banker will stand to remain consistent.
	 * @param pThird The value of the player's third card
	 * @param bankerPts The sum of the banker's two cards
	 * @return boolean value to determine if the banker must draw
	 */
	public boolean bankersDraw(int pThird, int bankerPts) {
		if(bankerPts == 0 || bankerPts == 2) {
			if(pThird == 8) {return true;}
			else if(pThird > 2 && pThird < 8) {return false;}
		}
		else if(bankerPts >= 0 && bankerPts <= 3) {
			if(pThird == 1 || pThird == 9 || pThird == 0) {return true;}
			else if(pThird >= 4 && pThird <=7) {return false;}
		}
		else if(bankerPts >= 0 && bankerPts <= 4) {
			if(pThird == 2 || pThird == 3) {return true;}
			else if(pThird == 5 || pThird == 7) {return false;}
		}
		else if(bankerPts >= 0 && bankerPts <= 5) {
			if(pThird == 4 || pThird == 5) {return true;}
			else if(pThird == 6 || pThird == 7) {return false;}
		}
		else if(bankerPts >= 0 && bankerPts <= 6) {
			if(pThird == 6) {return true;}
			else if(pThird == 7) {return false;}
		}
		return false;
	}
	
	/**
	 * Draws a random card from the deck, removing it in the process
	 * @param myDeck The deck of cards
	 * @return The card that has been drawn
	 */
	public Card draw(CardDeck myDeck) {
		int randomCard;
		
		randomCard = getRandomNumber(0,(myDeck.getDeck().size()));
		Card currentCard = myDeck.getDeck().remove(randomCard);   //draws a random card and removes it from deck
		return currentCard;
	}
	
	/**
	 * generates a random number within the range of how many cards are left in the deck
	 * @param minimum the minimum number of cards, which is always zero
	 * @param maximum the current size of the deck
	 * @return a random number within the range of available cards
	 */
	public int getRandomNumber(int minimum, int maximum) {
	    return (int) ((Math.random() * (maximum - minimum)) + minimum);
	}
	
	/**
	 * Calculates the sum of the values of a party's hand
	 * @param points points either belonging to the player or the banker
	 * @return the sum of the party's hand
	 */
	public int sumPoints(int points) {
		int sum = points%10;
		return sum;
	}
}
