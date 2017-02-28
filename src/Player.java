/*
 * Player.java
 * Author: Jonathan Nguyen
 * Submission Date: 11/09/15
 *
 * Purpose: Player class that has methods related to the player.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */

import java.util.Scanner;
public class Player 
{
	private String Name;
	private int gamesCompleted;
	private int fastestWin;
	private static Scanner keyboard = new Scanner(System.in);
	
	//Asks for the player's guess
	public String askForGuess()
	{
		String userGuess = keyboard.nextLine();
		return userGuess;
	}
	
	//Returns the player's name
	public String getName()
	{
		return Name;
	}
	
	//Returns the player's fastest win
	public int getFastestWin()
	{
		return fastestWin;
	}
	
	//Returns the number of games completed
	public int getGamesCompleted()
	{
		return gamesCompleted;
	}
	
	//Sets the player's name in game to the one submitted
	public void setName(String Name)
	{
		this.Name = Name;
	}
	
	//Used after each game to update the statistics
	public void updateStats(int numOfMovesTaken)
	{
		this.gamesCompleted += 1;
		if(numOfMovesTaken < this.fastestWin || this.fastestWin == 0)
		{
			this.fastestWin = numOfMovesTaken;
		}
	}
}
