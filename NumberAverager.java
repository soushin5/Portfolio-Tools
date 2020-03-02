//////////////////////////////
//Number Averager
//////////////////////////////
import java.util.*;
public class NumberAverager {
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.print("Please enter your full name.\n");
		String name = user.nextLine();
		System.out.print("Please enter your first grade.");
		int grade1 = user.nextInt();
		System.out.print("Please enter your second grade.");
		int grade2 = user.nextInt();
		System.out.print("Please enter your third grade.");
		int grade3 = user.nextInt();
		int avg = (grade1+grade2+grade3)/3;
		System.out.println("Your name: " + name + "\r"
				+ "Your Avg: " + avg);
	}
}
