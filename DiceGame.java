//////////////////////////////
//Simple Dice Game: guess the total of two rolled numbers
//////////////////////////////
import java.util.*;
public class DiceGame 
{
	static Scanner console = new Scanner(System.in);
	static int dice;
	static int dice2;
	static int diceTotal;
	static int userPick;
	static int userPick2;
	static int userTotal;
	static String answer;

	static int rollDie() {
		dice = (int)(Math.random()*6)+1;
		return dice;
	}
	static int rollDie2() {
		dice2 = (int)(Math.random()*6)+1;
		return dice2;
	}

	public static void main(String[] args)
	{
		do 
		
		{
			System.out.print("Pick a number between 1 and 6.");
			userPick = console.nextInt();
			System.out.println("Pick a second number between 1 and 6.");
			userPick2 = console.nextInt();
			userTotal = userPick + userPick2;
			System.out.println("Your total guess is: " + userTotal);
			System.out.println("The first dice roll is: " + rollDie());
			System.out.println("The second dice roll is: " + rollDie2());
			diceTotal = dice+dice2;
			System.out.println("the total die rolls are: " + diceTotal);
			if(diceTotal == userTotal)
			{
				System.out.println("Your guess is correct, You Win!");
			} else
			{
				System.out.println("Your guess is wrong, You Lose!");
			}
			System.out.println("Care to play again? Y/N");
			answer = console.next();

		}
		while(answer.equals("Y") || (answer.equals("y")));

	}
}
