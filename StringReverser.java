//////////////////////////////
//String reverser using Custom Stack
//////////////////////////////
public class StringReverser {

	// A linked list node 
	private class Node { 

		Object data; 
		Node link;  
	} 
	
	Node top; 

	// Constructor 
	StringReverser() 
	{ 
		this.top = null; 
	} 

	//add to element stack 
	// inserts at the beginning
	public void push(Object o)  
	{ 
		Node temp = new Node();  
		temp.data = o; 
		temp.link = top; 
		top = temp; 
	} 

	// check if empty 
	public boolean isEmpty() 
	{ 
		return top == null; 
	} 

	// remove top element from stack
	public void pop() 
	{ 
		if (top == null) { 
			System.out.print("\nStack Empty"); 
			return; 
		} 
		System.out.print(top.data + "\n"); 
		top = (top).link; 
	} 

	public void reverse(String s) {
		String reverse = "";

		for(int i=s.length()-1; i>=0; i--) {
			reverse = reverse + s.charAt(i);
		}
		push(reverse);
		push("$");
		push(s);
		print();
	}

	public void print() //from top to bottom
	{  
		Node temp = top; 
		while (temp != null) { 
			System.out.print(temp.data + ""); 
			temp = temp.link; 
		} 
	} 

	public static void main(String[] args) 
	{ 
		StringReverser stack = new StringReverser(); 
		String s = "ABC";

		stack.reverse(s);
	} 
} 
