package graphOperations;
import java.util.*;

public class DetectCycleGraph {
	int vertices; // total number of vertices
	LinkedList<Integer>[] arrOfAdj;
	
	public DetectCycleGraph(int vertices){
		this.vertices = vertices;
		arrOfAdj = new LinkedList[this.vertices]; // cannot use generics to instantiate an array
		for(int i=0; i< vertices; i++){// initializing each of the adjacency lists 
			arrOfAdj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int first, int second){
		this.arrOfAdj[first].add(second);
	}
	
	// returns true if cycle is present
	public boolean detectCycleUsingDFS(int start){
		Stack<Integer> st = new Stack<Integer>();
		st.push(start);
		boolean[] visited = new boolean[this.vertices];
		visited[start] = true;
		while(!st.isEmpty()){
			int curr = st.pop();
			for(int v : arrOfAdj[curr]){
				if(!visited[v]){
					st.push(v);
					visited[v] = true;
				}
				else{
					return true;
				}
			}			
		}
		return false; //  returns false if the entire graph has no cycle.
	}
	// returns true if cycle is present
	public boolean detectCycleUsingBFS(int start){
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		boolean[] visited = new boolean[this.vertices];
		visited[start] = true;
		while(!q.isEmpty()){
			int curr = q.poll();
			for(int v: arrOfAdj[curr]){
				if(!visited[v]){
					q.offer(v);
				}
				else{
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectCycleGraph g = new DetectCycleGraph(5);	
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(2, 4);        
        
        System.out.println(g.detectCycleUsingBFS(1)); // true
        System.out.println(g.detectCycleUsingDFS(4)); // false
        System.out.println(g.detectCycleUsingBFS(4)); // false
	}

}
