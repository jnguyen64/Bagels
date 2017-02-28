/*
 * Bagels.java
 * Author: Jonathan Nguyen
 * Submission Date: 11/09/15
 *
 * Purpose: Main class for the Bagels Project. Runs the game.
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
public class Bagels {
	private Player player;
	public static void main(String[] args)
	{
		//Instantiating the other classes
		Engine b = new Engine();
		Scanner keyboard = new Scanner(System.in);
		
		Validator v = new Validator();

		//Used when prompted for the user to play again/reset game
		boolean startGame = true;
		while(startGame == true)
		{
			Player check = new Player();
			System.out.println("Welcome!");
			System.out.println("Enter the number of digits to use: ");
			int numDigits = keyboard.nextInt();
			keyboard.nextLine();


			System.out.println("Enter the player's name: ");
			String Name = keyboard.nextLine();
			check.setName(Name);

			//Used if the player wants to just play again
			boolean continueGame = true;

			while(continueGame == true)
			{
				
				b.setNumDigits(numDigits);
				b.generateNewSecret();
				System.out.println();
				System.out.println("Starting game #" + (check.getGamesCompleted() + 1));
				int[] secret = b.getSecretNumber();
				int[] guess;

				int numOfMovesTaken = 0;
				//Allows the loop to keep running until the user guesses the secret
				boolean x = true; 
				do
				{
					System.out.println("Enter your guess: ");
					String userGuess = check.askForGuess();

					guess = b.convertNumToDigitArray(userGuess);
					System.out.print(secret[0]);
					System.out.println(secret[1]);
					x = Validator.validateGuess(secret, guess, numDigits);
					numOfMovesTaken++;
				}
				while(x == false);

				System.out.println("Congratulations! You won in " + numOfMovesTaken + " moves.");

				check.updateStats(numOfMovesTaken);

				System.out.println();
				System.out.println("Statistics for " + check.getName() + ":");
				System.out.println("Games completed: " + check.getGamesCompleted());
				System.out.println("Number of digits: " + numDigits);
				System.out.println("Fastest win: " + check.getFastestWin() + " guesses");
				System.out.println("p - Play again");
				System.out.println("r - Reset game");
				System.out.println("q - Quit");
				System.out.println();
				System.out.println("What would you like to do? ");

				String userInput = keyboard.nextLine();
				switch(userInput)
				{
				case "p":
					startGame = false;
					break;
				case "r":
					startGame = true;
					continueGame = false;
					break;
				case "q":
					System.out.println();
					System.out.println("Goodbye!");
					System.exit(0);

				}
			}
		}
	}
}
