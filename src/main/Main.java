package main;

import java.util.Scanner;

import classes.Game;
import classes.Player;

public class Main {
	public static void main(String[] args) {

		Player p1 = new Player();
		Player p2 = new Player();
		Scanner sc = new Scanner(System.in);

		System.out.println("Player 1 AI? 0 = no, 1 = yes");
		int aiPlayer1 = sc.nextInt();

		System.out.println("Player 2 AI? 0 = no, 1 = yes");
		int aiPlayer2 = sc.nextInt();

		if (aiPlayer1 == 1)
			p1.setAiPlayer(true);

		if (aiPlayer2 == 1)
			p2.setAiPlayer(true);

		Game game = new Game(p1, p2);

		game.playGame();
		
		sc.close();
	}
}
