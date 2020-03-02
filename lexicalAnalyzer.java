import java.io.*;
import java.util.*;
public class lexicalAnalyzer {
	static public void analyze(Queue<String> a, String b) {
		for(int i=0; i< b.length(); i++) {
			String t = b.valueOf(b.charAt(i));
			if(t.matches("[a-zA-Z0-9]")) {
				a.add(t);
			}
			else if(t.matches("\\s")) {
				if(!a.isEmpty()) {
					while(!a.isEmpty()) {
			    		System.out.print(a.remove());
			    	}
					System.out.print("\n");
				}
			}
			else
			{
			    if(!a.isEmpty()) {
			    	while(!a.isEmpty()) {
			    		System.out.print(a.remove());
			    	}
			    	System.out.print("\n"+ t + "\n");
			    }
			    else {
			    	System.out.print("Stack is Empty");
			    }
			}
		}
		while(!a.isEmpty()) {
			System.out.print(a.remove());
		}
	}

	public static void main(String[] args) {
		File file = new File("C:\\Users\\kuwan_000\\Documents\\Georgia State\\GA State Spring 2020\\Programming Language Concepts\\test.txt");
		Queue<String> q = new LinkedList<>();
		String st = "", temp;

		try {
		    BufferedReader br = new BufferedReader(new FileReader(file)); 
 
			while (( temp = br.readLine()) != null) {
		    	st = temp;
		    	System.out.println(st + "\n");
		    }
		    analyze(q, st);
		    br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
 