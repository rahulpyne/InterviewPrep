package graphOperations;
import java.util.*;
public class GraphOperations {
	int vertices; // The total number of vertices	
	LinkedList<Integer>[] arrOfAdj; // its an array of the adjacent List
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphOperations g = new GraphOperations(4);	
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println(" ---- BFS ------");
        g.bFSTraversalUsingQueue(2);
        System.out.println();
        System.out.println("----DFS using stack-------");
        g.dFSTraversalUsingStack(2);
        System.out.println();
        System.out.println("----DFS using recursion-------");
        g.dfsTraversal(2, new boolean[g.vertices]);
        System.out.println();
	}
	public GraphOperations(int vertices){
		this.vertices = vertices;
		this.arrOfAdj = new LinkedList[vertices];
		for(int i = 0; i< vertices; i++)
		{
			arrOfAdj[i] = new LinkedList<Integer>();
		}
	}
	//the vertices start from 0
	public void addEdge(int firstVertice, int secVertice){
		arrOfAdj[firstVertice].add(secVertice);
	}
	// traverses the graph using BFS Traversal, O(V+E)
	// start defines the starting vertices.
	public void bFSTraversalUsingQueue(int start){
		boolean visited[] = new boolean[this.vertices]; // keeps a track of which vertices have been covered.
		Queue<Integer> q =  new LinkedList<Integer>();
		q.offer(start);// inserting the first start;
		visited[start] = true; //making the starting node visited
		while(!q.isEmpty()){
			int currVertice = q.poll();
			System.out.print(currVertice + " ");
			for(int ver : arrOfAdj[currVertice]){
				if(!visited[ver]){
					visited[ver] = true;
					q.offer(ver);
				}
			}
		}
		
		
	}
	
	public void dfsTraversal(int start,boolean[] visited){
		System.out.print(start + " ");
		visited[start] = true;
		for(int vertice : arrOfAdj[start]){
			if(!visited[vertice]){
				dfsTraversal(vertice,visited);
			}			
		}
	}
	
	public void dFSTraversalUsingStack(int start){
		Stack<Integer> st = new Stack<Integer>();		
		st.push(start);
		boolean[] visited = new boolean[this.vertices];
		visited[start] = true;
		while(!st.isEmpty()){
			int currVertice = st.pop();
			System.out.print(currVertice + " ");
			for(int v : arrOfAdj[currVertice]){
				if(!visited[v]){
					st.push(v);
					visited[v] = true;
				}
			}
		}
	}
	
	
		
	

}
