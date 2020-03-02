//////////////////////////////
//Matt Wang
//Assignment 2 Question 3
//CSC 2720 Data Structures
//Baykal
//////////////////////////////
import java.util.*;
public class Infix_PostfixConverter {

	// function to return precedence of a given operator 
	// Higher returned value means higher precedence 
	static int Prec(char ch) 
	{ 
		switch (ch) 
		{ 
		case '+': 
		case '-': 
			return 1; 

		case '*': 
		case '/': 
			return 2; 

		case '^': 
			return 3; 
		} 
		return -1; 
	} 

	// converting method  
	public static String infixToPostfix(String s) 
	{ 
		String postFix = new String(""); 
		Stack<Character> stack = new Stack<>(); 

		for (int i = 0; i<s.length(); ++i) 
		{ 
			char c = s.charAt(i); 

			// If the scanned character is an operand, add it to output. 
			if (Character.isLetterOrDigit(c)) 
				postFix += c; 

			// If the scanned character is an '(', push it to the stack. 
			else if (c == '(') 
				stack.push(c); 

			//  If the scanned character is an ')', pop and output from the stack  
			// until an '(' is encountered. 
			else if (c == ')') 
			{ 
				while (!stack.isEmpty() && stack.peek() != '(') 
					postFix += stack.pop(); 

				if (!stack.isEmpty() && stack.peek() != '(') 
					return "Invalid Expression"; // invalid expression                 
				else
					stack.pop(); 
			} 
			else // an operator is encountered 
			{ 
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) 
					postFix += stack.pop(); 
				stack.push(c); 
			}
		} 
		while (!stack.isEmpty()) 
			postFix += stack.pop(); 

		return postFix; 
	} 

	// Driver  
	public static void main(String[] args)  
	{ 
		String exp = "(A+B/C*(D+E)-F)"; 
		System.out.println(infixToPostfix(exp)); 
	} 
} 
