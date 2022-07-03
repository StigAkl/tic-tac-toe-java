package classes;

import java.util.Random;

public class Player {

	private boolean aiPlayer; 
	private int playerNumber; 
	private Random random; 
	
	public Player() {
		this.aiPlayer = false; 
		this.random = new Random(); 
	}
	
	public boolean isAiPlayer() {
		return aiPlayer;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}
	
	public void setAiPlayer(boolean aiPlayer) {
		this.aiPlayer = aiPlayer;
	}
	
	public int getAiMove() {
		return random.nextInt(9)+1;
	}
}		
