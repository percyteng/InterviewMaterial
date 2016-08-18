package Graph;

import java.util.ArrayList;
import java.util.List;
//Space used by AdjacencyMatrix is O(n^2);
//outEdges and inEdges take O(n);
//In particular, when the graph G is dense, i.e., it has close to  n^2 edges, then a memory usage of n^2 may be acceptable.
//
//The AdjacencyMatrix data structure is also commonly used because algebraic operations on the matrix a can be used to efficiently compute properties of the graph G. 
public class AdjacencyMatrix {
	 int n;
	    boolean[][] a;
	    AdjacencyMatrix(int n0) {
	        n = n0;
	        a = new boolean[n][n];
	    }
	    void addEdge(int i, int j) {
	        a[i][j] = true;
	    }
	    
	    void removeEdge(int i, int j) {
	        a[i][j] = false;
	    }
	    boolean hasEdge(int i, int j) {
	        return a[i][j];
	    }
	    boolean object(int i, int j){
	    	return a[i][j];
	    }
	    List<Integer> outEdges(int i) {
	        List<Integer> edges = new ArrayList<Integer>();
	        for (int j = 0; j < n; j++) 
	            if (a[i][j]) edges.add(j);
	        return edges;
	    }
	    List<Integer> inEdges(int i) {
	        List<Integer> edges = new ArrayList<Integer>();
	        for (int j = 0; j < n; j++)
	            if (a[j][i]) edges.add(j);
	        return edges;
	    }
}
