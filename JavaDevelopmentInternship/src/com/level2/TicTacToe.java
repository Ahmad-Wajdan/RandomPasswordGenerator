package com.level2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

	private char[][] board;
	private char currPlayer;
	private Scanner scanner ;
	private boolean gameWon;
	private int movesMade;
	
	public TicTacToe() {
		board = new char[3][3];
		currPlayer = 'X';
		scanner = new Scanner(System.in); 
		gameWon = false;
		initializeBoard();
	}
	
	private void initializeBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = ' ';
			}
		}
	}
	
	private void printBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
	
	private void makeMove() {
        int row = -1;
        int col = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Player " + currPlayer + ", enter your move (row and column, e.g., 0 1):");
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board[row][col] == ' ') {
                        board[row][col] = currPlayer;
                        movesMade++;
                        validInput = true;
                    } else {
                        System.out.println("That cell is already taken. Please choose an empty cell.");
                    }
                } else {
                    System.out.println("Invalid input. Row and column must be between 0 and 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers for row and column.");
                scanner.next(); 
                scanner.next(); 
            }
        }
    }
	
	 private boolean checkWin() {
	        for (int i = 0; i < 3; i++) {
	            if (checkLine(currPlayer, i, 0, i, 1, i, 2)) return true;
	        }

	        for (int j = 0; j < 3; j++) {
	            if (checkLine(currPlayer, 0, j, 1, j, 2, j)) return true;
	        }

	        if (checkLine(currPlayer, 0, 0, 1, 1, 2, 2)) return true; 
	        if (checkLine(currPlayer, 0, 2, 1, 1, 2, 0)) return true; 

	        return false;
	 }
	 
	 private boolean checkLine(char player, int r1, int c1, int r2, int c2, int r3, int c3) {
	        return (board[r1][c1] == player &&
	                board[r2][c2] == player &&
	                board[r3][c3] == player);
	 }

	 private boolean isBoardFull() {
	        return movesMade == 9; 
	 }

	 private void switchPlayer() {
	        currPlayer = (currPlayer == 'X') ? 'O' : 'X';
	 }

	 public void startGame() {
	        System.out.println("Welcome to Tic-Tac-Toe!");
	        System.out.println("Player X goes first.");

	        while (!gameWon && !isBoardFull()) {
	            printBoard();
	            makeMove();
	            gameWon = checkWin(); 
	            if (!gameWon) { 
	                switchPlayer();
	            	}
	        }
	 
	 
	 printBoard();
     if (gameWon) {
         System.out.println("Congratulations, Player " + currPlayer + " wins!");
     } else if (isBoardFull()) {
         System.out.println("It's a draw! The board is full.");
     }
     
     scanner.close();
     System.out.println("Thanks for playing!");
 }

		public static void main(String[] args) {
			TicTacToe game = new TicTacToe();
			game.startGame();

		}

}
