//////////////////////////////
//Simple Guessing Game
//////////////////////////////
import java.util.*;
public class GuessingGame {
	public static Scanner user = new Scanner(System.in);
	public static int guess;
	public static int numGuesses;
	static String repeat;

	public static void main(String[] args) 
	{
		System.out.println("Please enter the number of "
				+ "max value of the secret number.");
		int maxValue = user.nextInt();
		do 
		{
			numGuesses=0;
			int secretNumber = (int) (Math.random() * maxValue) + 1;

			System.out.print("A new secret number has been chosen.\n");
			do
			{
				System.out.print("Enter Guess: ");
				guess = user.nextInt();
				if(guess<secretNumber)
				{
					System.out.print("Too Low; Try Again.\n");
					numGuesses++;
				}
				if( guess>secretNumber) 
				{
					System.out.print("Too High; Try Again.\n");
					numGuesses++;
				}
				if(guess>maxValue) 
				{
					System.out.print("Above the Max value; Try Again.\n");
			        numGuesses++;
				}
			}while(guess!=secretNumber);
			if(guess==secretNumber) 
			{
				System.out.print("You Won! Number of Guesses: " + numGuesses + 
						"\n");
			}
			System.out.print("Play Again? (Y/N) \n");
			repeat = user.next();
		}
		while(repeat.equalsIgnoreCase("Y"));
	}
}
