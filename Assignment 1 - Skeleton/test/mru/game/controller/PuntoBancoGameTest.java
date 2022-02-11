package mru.game.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PuntoBancoGameTest {

	@Test
	void testDraw() {
		
	}

	@Test
	void testCardValue() {
		//rank of cards valued at 10 or above
		PuntoBancoGame pbg = new PuntoBancoGame();
		pbg.cardValue(10);
		Assert.assertTrue(pbg.cardValue(10) == 0);
	}

	@Test
	void testCheckPlayerNull() {
		PuntoBancoGame pbg = new PuntoBancoGame();
		String[]playerHand = new String[3];
		playerHand[0] = "Ace of Spades";
		playerHand[1] = "Ace of Heart";
		playerHand[2] = null;
		pbg.checkPlayerNull(playerHand);
		Assert.assertTrue(playerHand[2].equals(""));
	}

	@Test
	void testCheckBankerNull() {
		PuntoBancoGame pbg = new PuntoBancoGame();
		String[]bankerHand = new String[3];
		bankerHand[0] = "Six of Diamonds";
		bankerHand[1] = "Seven of Clubs";
		bankerHand[2] = null;
		pbg.checkBankerNull(bankerHand);
		Assert.assertTrue(bankerHand[2].equals(""));
	}

	@Test
	void testSumPoints() {
		PuntoBancoGame pbg = new PuntoBancoGame();
		pbg.sumPoints(17);
		Assert.assertTrue(pbg.sumPoints(17)==7);
	}

	@Test
	void checkNatural() {
		PuntoBancoGame pbg = new PuntoBancoGame();
		Assert.assertTrue(pbg.checkNatural(8)==true);
		Assert.assertTrue(pbg.checkNatural(9)==true);
		Assert.assertTrue(pbg.checkNatural(7)==false);	
	}
}
