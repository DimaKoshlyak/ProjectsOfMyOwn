package ua.dimakoshlyak;

import java.util.*;
/**
 * 
 * @author DimaKoshlyak
 *
 *TicTacToe game for 2 players
 */
public class TicTacToe {

	public static void main(String[] args) {
	
		String[][] arr = new String [3][3]; 
		String playerMove = new String();
		String player1Name = new String();
		String player2Name = new String();
		int moveCount = 0;
		int positionX = 0;
		int positionY = 0;
		int[] positionXY = new int[2];
		boolean ifCorrect = false;
		boolean ifWinner = false;
		String stringChoice = new String();
		char charChoice = 'a';
		int choice = 0;
		boolean ifNumberCorrect = false;
		String winner = new String();

		System.out.println("Welcome to the Tic Tac Tor game!");
		player1Name=keyboard("Please enter the name of the first player");
		player2Name=keyboard("Please enter the name of the second player");

		Random r = new Random();
		playerMove = r.nextInt(2)==0?player1Name:player2Name;

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				arr[i][j] = "-";
			}
		}
		showArr(arr);

		while(!ifWinner){
			ifCorrect = false;
			ifNumberCorrect = false;
			do{
				System.out.println("Player " + playerMove + " move!");

				while (!ifNumberCorrect){
					ifNumberCorrect = false;
					stringChoice = keyboard("Please enter the position");
					charChoice = stringChoice.charAt(0);
					if (Character.isLetter(charChoice)==true){
						System.out.println("Please enter the number from 1 to 9:");}
					else ifNumberCorrect = true;
				}
				choice = Character.getNumericValue(charChoice);

				getChoice(choice,positionXY);
				positionX = positionXY[0];
				positionY = positionXY[1];
				if((choice>9)||(choice<1)){
					System.out.println("Enter the right position from 1 to 9:");}
				else if(arr[positionX][positionY]!="-"){
					System.out.println("This position is already occupied. Please enter another position:");}
				else 
					ifCorrect = true;	
			}
			while(!ifCorrect);
			if(playerMove == player1Name){
				arr[positionX][positionY]="X";
			}
			else arr[positionX][positionY]="0";
			moveCount++;
			ifWinner = winnerStatus(arr);
			if (ifWinner){
				winner = playerMove;
			}
			if ((moveCount == 9)&&(!ifWinner)){
				winner = "Try one more time!";
				ifWinner = true;
			}
			showArr(arr);
			playerMove = getPlayerMove(playerMove,player1Name,player2Name);
			System.out.println();
		}
		System.out.println("winner is: " + winner + "!");
	}
	
	//keyboard enter
	public static String keyboard(String message){
		System.out.println(message  + ":");
		Scanner scanner = new Scanner(System.in);
		String rez = scanner.nextLine();
		return rez;
	}
	
	//show current array	
	public static void showArr(String[][] array){
		for (int i = 0; i<array.length; i++){
			for (int j = 0; j <array.length; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();	
		}
		System.out.println("*****************");
		System.out.println("1 | 2 | 3");
		System.out.println("---------");
		System.out.println("4 | 5 | 6");
		System.out.println("---------");
		System.out.println("7 | 8 | 9");
	}

	//Player move change
	public static String getPlayerMove(String playerMove, String player1Name, String player2Name){
		if(playerMove == player1Name){
			return  playerMove = player2Name;
		}
		else return playerMove = player1Name;
	}

	// winner status check.
	static boolean  winnerStatus (String[][] arr){
		if (    ((arr[0][0]==arr[0][1])&&(arr[0][1]==arr[0][2])&&(arr[0][0]!="-")&&(arr[0][1]!="-")&&(arr[0][2]!="-"))||
				((arr[0][2]==arr[1][2])&&(arr[1][2]==arr[2][2])&&(arr[0][2]!="-")&&(arr[1][2]!="-")&&(arr[2][2]!="-"))||
				((arr[2][2]==arr[2][1])&&(arr[2][1]==arr[2][0])&&(arr[2][2]!="-")&&(arr[2][1]!="-")&&(arr[2][0]!="-"))||
				((arr[0][0]==arr[1][0])&&(arr[1][0]==arr[2][0])&&(arr[0][0]!="-")&&(arr[1][0]!="-")&&(arr[2][0]!="-"))||
				((arr[0][1]==arr[1][1])&&(arr[1][1]==arr[2][1])&&(arr[0][1]!="-")&&(arr[1][1]!="-")&&(arr[2][1]!="-"))||
				((arr[1][0]==arr[1][1])&&(arr[1][1]==arr[1][2])&&(arr[0][1]!="-")&&(arr[1][1]!="-")&&(arr[1][2]!="-"))||
				((arr[0][0]==arr[1][1])&&(arr[1][1]==arr[2][2])&&(arr[0][0]!="-")&&(arr[1][1]!="-")&&(arr[2][2]!="-"))||
				((arr[0][2]==arr[1][1])&&(arr[1][1]==arr[2][0])&&(arr[0][2]!="-")&&(arr[1][1]!="-")&&(arr[2][0]!="-"))
				)
			return true;
		else
			return false;
	}

	//translation of player choice
	static void getChoice(int choice, int[] positionXY){
		int x = 1 ,  y = 1 ;

		switch (choice){
		case 1:
			x = 0;
			y = 0;
			break;
		case 2:
			x = 0;
			y = 1;
			break;
		case 3:
			x = 0;
			y = 2;
			break;
		case 4:
			x = 1;
			y = 0;
			break;
		case 5:
			x = 1;
			y = 1;
			break;
		case 6:
			x = 1;
			y = 2;
			break;
		case 7:
			x = 2;
			y = 0;
			break;
		case 8:
			x = 2;
			y = 1;
			break;
		case 9:
			x = 2;
			y = 2;
			break;
		}
		positionXY[0] = x;
		positionXY[1] = y;
	}
}
