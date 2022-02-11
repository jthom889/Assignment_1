package mru.game.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.game.model.Player;

class tests {

	@Test
	void testGetName() {
		Player player = new Player("Jonah", 100.0, 20);
		
		String actualName = player.getName();
		String expectedName = "Jonah";
		
		assertEquals(expectedName, actualName);
		
	}
	
	@Test
	void testGetBalance() {
		Player player = new Player("Jonah", 100.0, 20);
		
		double actualBalance = player.getBalance();
		double expectedBalance = 100.0;
		
		assertEquals(expectedBalance, actualBalance);
		
	}
	
	@Test
	void testGetWins() {
		Player player = new Player("Jonah", 100.0, 20);
		
		int actualWins = player.getWins();
		int expectedWins = 20;
		
		assertEquals(expectedWins, actualWins);
		
	}
	
	@Test
	void testFormat() {
		Player player = new Player("Jonah", 100.0, 20);
		
		String actualOutput = player.format();
		String expectedOutput = "Jonah,100.0,20\n";
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testSetName() {
		Player player = new Player("Jonah", 100.0, 20);
		
		player.setName("Joseph");
		
		String actualName = player.getName();
		String expectedName = "Joseph";
		
		assertEquals(actualName, expectedName);
		
	}
	
	@Test
	void testSetBalance() {
		Player player = new Player("Jonah", 100.0, 20);
		
		player.setBalance(125.0);
		
		double actualBalance = player.getBalance();
		double expectedBalance = 125.0;
		
		assertEquals(actualBalance, expectedBalance);
		
	}
	
	@Test
	void testSetWins() {
		Player player = new Player("Jonah", 100.0, 20);
		
		player.setWins(25);
		
		int actualWins = player.getWins();
		int expectedWins = 25;
		
		assertEquals(actualWins, expectedWins);
		
	}

}
