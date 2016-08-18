package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
//space used by adjacencylist is O(n+m)
//inEdges(i) takse O(n+m) time;
//An adjacency matrix uses O(n*n) memory. It has fast lookups to check 
//for presence or absence of a specific edge(constant), but slow to iterate over all edges(n^2).
//This is commonly used for dense graphs where index access is necessary. 
//You can represent a un/directed and weighted structure with this.

//Adjacency lists use memory in proportion to the number edges, (n+m)
//which might save a lot of memory if the adjacency matrix is sparse. 
//It is fast to iterate over all edges(m), but finding the presence or absence of
//specific edge is slightly slower than with the matrix(worst case: time spent to go through all of the edges under a vertex).
//This is used for representing sparse graphs, if you are applying at Google, 
//you should know that the webgraph is sparse. You can deal with them in a more scalable way using a BigTable.
//by using adjacencylist we lose the graph and we can't rebuild it.

//Objects and pointers is commonly used for object oriented implementations, 
//since it is more readable and convenient for object oriented users ;).
public class AdjacencyLists {
	int n;
    HashMap<Integer, ArrayList<Integer>> adj;
    AdjacencyLists(int n0) {
        n = n0;
        adj = new HashMap<Integer,ArrayList<Integer>>();
      for (int i = 0; i < n; i++){
    	  ArrayList<Integer> each = new ArrayList<Integer>();
    	  adj.put(i,each);
      }
    }
    int object(int i, int j){
    	return adj.get(i).get(j);
    }
    void addEdge(int i, int j) {
        adj.get(i).add(j);
    }
    void removeEdge(int i, int j) {
    	adj.get(i).remove((Object)j);
    	//    	for (int k = 0; k < adj.get(i).size(); k++){
//    		if (j == adj.get(i).get(k))
//    			adj.get(i).remove(k);
//    	}
         
    }
    boolean hasEdge(int i, int j) {
        return adj.get(i).contains(j);
    }
    List<Integer> outEdges(int i) {
        return adj.get(i);
    }
    List<Integer> inEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < n; j++)
            if (adj.get(i).contains(i))    edges.add(j);
        return edges;
    }
}
