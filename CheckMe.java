//////////////////////////////
//equality checker
//////////////////////////////
import java.util.*;
public class CheckMe {
	static Scanner console = new Scanner(System.in);
	static int num1 = 0;
	static int num2 = 0;
	static int num3 = 0;
	
	public static void main(String[] args)
	{
		System.out.print("Enter threee numbers.");
		num1 = console.nextInt();
		num2 = console.nextInt();
		num3 = console.nextInt();
		System.out.println("Your numbers:" + num1 + " " +
						  num2 + " " + num3);
		
		if(num1 == num2 && num1 == num3) 
		{
			System.out.println("Your numbers are equal.");
		} else {
			System.out.println("Your numbers are not equal.");
		}
	}

}
