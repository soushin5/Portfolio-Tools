//////////////////////////////
//Diamond Drawer
//////////////////////////////
import java.util.*;
public class DrawDiamond {
	public static Scanner user = new Scanner(System.in);
	public static int gridLength;
	public static int length;
	public static int dot;
	public static int dot2;
	public static int counter = 1;
	public static int mCounter = 0;
	public static int midpoint;


	public static void printDiamonds(int N) 
	{
		length = ((2*N)+1);
		dot = length/2;
		dot2 = length/2;
		midpoint = dot+1;
		for(int j= ((2*N)+1); j>=1; j--)
		{
			for(int i=1; i<=((2*N)+1); i++) 
			{
				if(j>=midpoint) 
				{
					if(i <= dot || i >(dot)+counter) 
					{
						System.out.print(".");
					}
					else {
						System.out.print("*");
					}
				}
				if(j<midpoint)
				{
				if(i<= mCounter || i >= length+1) 
					{
						System.out.print(".");
					}
					else {
						System.out.print("*");
					}
				}
				
			}
			dot--;
			if(j>=midpoint) {
				counter = counter+2;
			}
			if(j<=midpoint) {
				mCounter++;
				length--;
			}
			System.out.println("");
		}

	}

	public static void main(String[] args) 
	{
		System.out.println("Please enter grid length.");
		gridLength = user.nextInt();
		printDiamonds(gridLength);

	}

}
