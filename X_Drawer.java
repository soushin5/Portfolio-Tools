//////////////////////////////
//Matt Wang
//Homework 7
//CSC 1301 Lab: Th 10
//Henry
//////////////////////////////
import java.util.*;
public class X_Drawer
{
	public static Scanner user = new Scanner(System.in);
	public static int gridLength;
    public static int counter = 1;
	public static int reverseCounter;
	
	public static void printX(int N) 
	{
		reverseCounter = ((2*N)+1);
		for(int j= ((2*N)+1); j>=1; j--)
		{
			for(int i=1; i<=((2*N)+1); i++) 
			{
				if(counter == i || i == reverseCounter) 
				{
					System.out.print("*");
				}
				else {
					System.out.print(".");
				}
			}
			counter++;
			reverseCounter--;
			System.out.println("");
		}
	}

	public static void main(String[] args) 
	{
		System.out.println("Please enter grid length.");
		gridLength = user.nextInt();
		printX(gridLength);

	}

}
