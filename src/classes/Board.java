package classes;

public class Board {

	private int[][] board; 
	
	public Board() {
		board = new int[3][3];
	}
	
	public void printBoard() {
		System.out.println("| - | - | - |");
		System.out.println("| 1 | 2 | 3 |");
		System.out.println("| - | - | - |");
		System.out.println("| 4 | 5 | 6 |");
		System.out.println("| - | - | - |");
		System.out.println("| 7 | 8 | 9 |");
		System.out.println("| - | - | - |");
	}
	
	public void printState() {
		System.out.println("| - | - | - |");
		System.out.println(row(0));
		System.out.println("| - | - | - |");
		System.out.println(row(1));
		System.out.println("| - | - | - |");
		System.out.println(row(2));
		System.out.println("| - | - | - |");
	}
	
	private String row(int row) {
		if(row == 0) {
			return "| " + getSymbol(row, 0, 1) + " | " + getSymbol(row, 1, 2) + " | " + getSymbol(row, 2, 3) + " |"; 
		}
		if(row == 1) {
			return "| " + getSymbol(row, 0, 4) + " | " + getSymbol(row, 1, 5) + " | " + getSymbol(row, 2, 6) + " |"; 
		}
		
		return "| " + getSymbol(row, 0, 7) + " | " + getSymbol(row, 1, 8) + " | " + getSymbol(row, 2, 9) + " |"; 
	}
	
	private String getSymbol(int row, int col, int cell) {
		int player = board[row][col]; 
		if(player == 0) {
			return Integer.toString(cell); 
		}
		if(player == 1) {
			return "X"; 
		}
		return "O"; 
	}
	
	public boolean place(int position, int symbol) {
		
		if(position > 9 || position < 0) {
			return false; 
		}
	
			
		int row = 10; 
		int col = 10; 
		
		switch(position) {
		case 1: row =0; col = 0; break; 
		case 2: row =0; col = 1; break; 
		case 3: row =0; col = 2; break; 
		case 4: row =1; col = 0; break; 
		case 5: row =1; col = 1; break; 
		case 6: row =1; col = 2; break; 
		case 7: row =2; col = 0; break; 
		case 8: row =2; col = 1; break; 
		case 9: row =2; col = 2; break; 
		default: return false; 
		}
		
		if(board[row][col] != 0) {
			return false;
		}
		
		board[row][col] = symbol;
		return true; 
	}
	
	public boolean gameOver() {
		
		if(isWinner(1)) {
			System.out.println("Game over! X won!");
			return true; 
		}
		
		if(isWinner(2)) {
			System.out.println("Game over! O won!");
			return true;
		}
		
		int movesLeft = 0; 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 0)
					movesLeft++; 
			}
		}
		
		if(movesLeft == 0) {
			System.out.println("Game over! It's a draw, no more moves left");
			return true; 
		}
		
		return false;
	}
	
	private boolean isWinner(int player) {
		
		//rows
		boolean row1 = (board[0][0] == player && board[0][1] == player && board[0][2] == player);
		boolean row2 = (board[1][0] == player && board[1][1] == player && board[1][2] == player);
		boolean row3 = (board[2][0] == player && board[2][1] == player && board[2][2] == player);
		
		//Columns
		boolean col1 = (board[0][0] == player && board[1][0] == player && board[2][0] == player);
		boolean col2 = (board[0][1] == player && board[1][1] == player && board[2][1] == player);
		boolean col3 = (board[0][2] == player && board[1][2] == player && board[2][2] == player);
		
		//Diagonal 
		boolean diag1 = (board[0][0] == player && board[1][1] == player && board[2][2] == player); 
		boolean diag2 = (board[0][2] == player && board[1][1] == player && board[2][0] == player); 
		
		return row1 || row2 || row3 || col1 || col2 || col3 || diag1 || diag2; 
	}
}
