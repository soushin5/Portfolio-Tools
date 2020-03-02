//////////////////////////////
//Generate Adjacaency Matrix, Spanning Tree, and Adjacency list
//////////////////////////////
import java.util.*;
public class Graph_MatrixGenerator {
	public static Scanner console = new Scanner(System.in);
	public static int numVertices ; //number of vertices
	private boolean adjMatrix[][]; //adjacency matrix
	public  LinkedList<Integer> adj[];
	int notConnected = 0;
	
	public Graph_MatrixGenerator(int numVertices) {
		this.numVertices = numVertices;
		adjMatrix = new boolean[numVertices][numVertices];
		adj = new LinkedList[numVertices];
		for (int i=0; i<numVertices; ++i) { 
			adj[i] = new LinkedList(); 
		}
	}

	public void addEdge() {
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j <numVertices ; j++) {
				if(i == j) {
					adjMatrix[i][j] = false;
					adjMatrix[j][i] = false;
				}
				else {
					if(Math.random() > .5) {
						adjMatrix[i][j] =true;
						adjMatrix[j][i] =true;
					}
					else {
						adjMatrix[i][j] = false;
						adjMatrix[j][i] = false;
					}
				}
			}
		}
		buildList(adjMatrix);
	}

	public void buildList(boolean graph[][]) {
		for(int i = 0; i < numVertices; i++) {
			adj[i].clear();
		}
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j <numVertices ; j++) {
				if(adjMatrix[i][j] == true) {
					adj[i].add(j);
				}
			}
		}
	}

	public void connectMatrix(boolean graph[][]) {
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j <numVertices ; j++) {
				if(i == j) {
					graph[i][j] = false;
					graph[j][i] = false;
				}
				else {
					if(graph[i][j] == false) {
						if(Math.random() > .5) {
							graph[i][j] =true;
							graph[j][i] =true;
						}
					}
				}
			}
		}
		buildList(graph);
		System.out.println("");
		System.out.print("Matrix Connected: " + "\n");

		for(int i =0; i < numVertices; i++) {
			System.out.print("   " + i);
		}

		System.out.println("");
		System.out.println(toString());
	}

	//BFS Traversal
	public void BFSSpan(int v) 
	{ 
		boolean visited[] = new boolean[this.numVertices]; 

		LinkedList<Integer> queue = new LinkedList<Integer>(); 
 
		visited[v]=true; 
		queue.add(v); 

		while (queue.size() != 0) 
		{ 
			v = queue.poll(); 
			System.out.println(v+" - " + (adj[v]) + "-->" ); 

			Iterator<Integer> itr = adj[v].listIterator(); 
			while (itr.hasNext()) 
			{ 
				int n = itr.next(); 
				if (!visited[n]) 
				{ 
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		}
	}

	public void DFSCheck(int v) { 
		Vector<Boolean> visited = new Vector<Boolean>(this.numVertices); 
		for (int i = 0; i < numVertices; i++) { 
			visited.add(false); 
		}

		Stack<Integer> stck = new Stack<>();

		stck.push(v); 

		while(stck.empty() == false) 
		{ 
			int s = stck.peek(); 
			stck.pop(); 

			// Stack may contain same vertex twice.
			// So print the popped item only 
			// if it is not visited. 
			if(visited.get(s) == false) 
			{ 
				visited.set(s, true); 
			} 

			// Get all adjacent vertices of the popped vertex s 
			// If adjacent has not been visited, then push it 
			// to the stack. 
			Iterator<Integer> itr = adj[s].iterator(); 

			while (itr.hasNext())  
			{ 
				int u = itr.next(); 
				if(!visited.get(u)) 
					stck.push(u); 
			} 
		}
		for(int i = 0; i < visited.size(); i++) {
			if(visited.get(i)== false) {
				System.out.println("");
				System.out.print("not connected at " );
				System.out.print(i + " " + " ");
				notConnected = 2;
			}
		}
		if(notConnected == 2) {
			connectMatrix(adjMatrix);
		}
	} 

	public void DFSSpan(int v) { 
		Vector<Boolean> visited = new Vector<Boolean>(this.numVertices); 
		for (int i = 0; i < numVertices; i++) { 
			visited.add(false); 
		}

		Stack<Integer> stck = new Stack<>();

		stck.push(v); 

		while(stck.empty() == false) 
		{ 
			int s = stck.peek(); 
			stck.pop(); 

			// Stack may contain same vertex twice.
			// So print the popped item only 
			// if it is not visited. 
			if(visited.get(s) == false) 
			{ 
				System.out.println(s+" - " + (adj[s]) + "-->" ); 
				visited.set(s, true); 
			} 

			// Get all adjacent vertices of the popped vertex s 
			// If adjacent has not been visited, then push it 
			// to the stack. 
			Iterator<Integer> itr = adj[s].iterator(); 

			while (itr.hasNext())  
			{ 
				int u = itr.next(); 
				if(!visited.get(u)) 
					stck.push(u); 
			} 
		}
	} 
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < numVertices; i++) {
			s.append(i + ": ");
			for (boolean j : adjMatrix[i]) {
				s.append((j?1:0) + "   ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String[] args) {
		System.out.print("Please Enter number of vertices.\n");
		numVertices = console.nextInt();

		Graph_MatrixGenerator g = new Graph_MatrixGenerator(numVertices); //g for graph
		g.addEdge();
		System.out.print("Output of Matrix: " + "\n");

		for(int i =0; i < numVertices; i++) {
			System.out.print("   " + i);
		}

		System.out.println("");
		System.out.println(g.toString());

		g.DFSCheck(0);

		System.out.println("");
		System.out.println("Breadth First Tree: "+ 
				"(starting from vertex 0)");
		System.out.println("Vertex - [Edge]"); 
		g.BFSSpan(0);

		System.out.println("");
		System.out.println("Depth First Tree: "+ 
				"(starting from vertex 0)");
		System.out.println("Vertex - [Edge]"); 
		g.DFSSpan(0);
	}
}
