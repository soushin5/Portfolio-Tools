//////////////////////////////
//Tower of Hanoi Solution
//////////////////////////////
import java.util.*;
public class HanoiSolution { 
	public static Scanner console = new Scanner(System.in);
	public static int diskNum = 0;
	public static int stepCounter = 0;
	 
    static void towerOfHanoi(int n, char source, char dest, char rod) 
    { 
    	stepCounter++;
        if (n == 1) 
        { 
            System.out.println("Step " + stepCounter + ": Move disk 1 from rod " +
            		source + " to rod " + dest); 
            return; 
        } 
        towerOfHanoi(n-1, source, rod, dest); 
        System.out.println("Step " + stepCounter + ": Move disk " +  n + " from rod "
        		+  source + " to rod " + dest);
        towerOfHanoi(n-1, rod, dest, source); 
    } 
      
    //  Driver method 
    public static void main(String args[]) 
    { 
    	System.out.print("How many Disks? \n");
		diskNum = console.nextInt();
        towerOfHanoi(diskNum, 'A', 'C', 'B');  // A, B and C are names of rods 
        System.out.println("Total Steps: " + stepCounter);
    } 
} 
