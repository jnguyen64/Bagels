/*
 * Engine.java
 * Author: Jonathan Nguyen
 * Submission Date: 11/09/15
 *
 * Purpose: Engine class for the Bagels Project. Contains methods that are essential
 * to making sure the game runs smoothly.
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

import java.util.Random;

public class Engine 
{
	private int numDigits;
	private int[] secretNumber;
	private static Random randomNumberGenerator = new Random();

	//Converts the player's guess to an array
	public int[] convertNumToDigitArray(String number)
	{
		int[] convertArray = new int[number.length()];
		for(int x =0; x<number.length(); x++)
		{
			convertArray[x] = Character.getNumericValue(number.charAt(x));
		}
		return convertArray;
	}
	
	//Returns the number of digits the player wants to play with
	public int getNumDigits()
	{
		return numDigits;
	}
	
	//Returns the secret number
	public int[] getSecretNumber()
	{
		return secretNumber;
	}
	
	//Creates a new secret
	public void generateNewSecret()
	{
		secretNumber = new int[numDigits];
		secretNumber[0] = randomNumberGenerator.nextInt(8) + 1;
		
		for(int x = 1; x < numDigits; x++)
		{
			secretNumber[x] = randomNumberGenerator.nextInt(9);
		}
	}
	
	//Sets the number of digits the player input for their game
	public void setNumDigits(int numDigits)
	{
		if(numDigits >= 0)
		{
		this.numDigits = numDigits;
		}
	}
	
	//Sets the secret number
	public void setSecretNumber(int[] secretNumber)
	{
		for(int x = 0; x < secretNumber.length; x++)
		{
			this.secretNumber[x] = secretNumber[x];
		}
		this.setNumDigits(secretNumber.length);
		
		
	}
}
