package classes;

import java.util.Scanner;

public class Game {
	Board board; 
	Player currentPlayer; 
	Player player1; 
	Player player2; 
	Scanner sc; 
	
	public Game(Player player1, Player player2) {
		board = new Board(); 
		this.player1 = player1; 
		this.player2 = player2; 
		this.player1.setPlayerNumber(1);
		this.player2.setPlayerNumber(2);
		this.currentPlayer = player1; 
		sc = new Scanner(System.in);
	}
	
	
	public void playGame() {
		while(!board.gameOver()) {
			System.out.println("----------------------");
			System.out.println(getPlayer(currentPlayer.getPlayerNumber()) + " is placing.");
			System.out.println("Current board: ");
			board.printState();
			
			playTurn(); 
			swapPlayers(); 
		}
		sc.close();
		board.printState();
	}
	
	private void swapPlayers() {
		if(currentPlayer.getPlayerNumber() == player1.getPlayerNumber()) {
			currentPlayer = player2; 
		} else {
			currentPlayer = player1;
		}
	}
	
	private void playTurn() {
		if(currentPlayer.isAiPlayer()) {
			playAiMove(); 
		} else {
			playPlayerMove();
		}
	}
	
	private void playAiMove() {
		boolean isValid = false; 
		int aiMove = currentPlayer.getAiMove();
		while(!isValid) {
			isValid = board.place(aiMove, currentPlayer.getPlayerNumber()); 
			if(!isValid) {
				aiMove = currentPlayer.getAiMove();
			}
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(getPlayer(currentPlayer.getPlayerNumber()) + " placed " + aiMove);
	}
	
	private void playPlayerMove() {
		boolean isValid = false; 
		while(!isValid) {
			System.out.println("1-9: ");
			int position = sc.nextInt();
			
			isValid = board.place(position, currentPlayer.getPlayerNumber());
			
			if(!isValid) {
				System.out.println("Invalid option!");
			}
		}
	}
	
	private static String getPlayer(int player) {
		return player == 1 ? "X" : "O"; 
	}
}
