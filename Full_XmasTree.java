//////////////////////////////
//Christmas Tree Drawer
//////////////////////////////
import java.util.*;
public class Full_XmasTree 
{
	public static Scanner user = new Scanner(System.in);
	public static int rows;
	public static int diffMaker;
	public static int originalRows;

	public static void main(String[] args)
	{
		System.out.println("Please enter the number of rows.");
		rows = user.nextInt();
		originalRows = rows;
		diffMaker = rows-1;
		
		for(int j=originalRows; j>=1; j--) 
		{
			for(int i=1; i<=rows; i++)
			{
				System.out.print(" ");
			}
			rows--;
			for(int i = originalRows; i>diffMaker; i--) 
			{
				System.out.print(" *");
			}
			System.out.println("");
			diffMaker--;
		}
	}
}  