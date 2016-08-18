package Graph;

import java.util.ArrayList;

//One way to analyze these is in terms of memory and time complexity (which depends on how you want to access the graph).
//
//Storing nodes as objects with pointers to one another
//
//The memory complexity for this approach is O(n) because you have as many objects as you have nodes. The number of pointers (to nodes) required is up to O(n^2) as each node object may contain pointers for up to n nodes.
//The time complexity for this data structure is O(n) for accessing any given node.
//Storing a matrix of edge weights
//
//This would be a memory complexity of O(n^2) for the matrix.
//The advantage with this data structure is that the time complexity to access any given node is O(1).
//Depending on what algorithm you run on the graph and how many nodes there are, you'll have to choose a suitable representation.

public class Graph {
	public static void main(String[] args){
		//matrix
		AdjacencyMatrix am = new AdjacencyMatrix(3);
		am.addEdge(1, 2);
		for (int i = 0; i< 3; i++){
			for (int j = 0; j < 3; j++)
				System.out.println(Integer.toString(i) + "," + Integer.toString(j) + " is: " + am.object(i, j));
		}
		//list
		AdjacencyLists ls = new AdjacencyLists(5);
		ls.addEdge(1, 3);
		ls.addEdge(1, 4);
		for (int i = 0; i< 5; i++){
			System.out.print(Integer.toString(i) + " has edges with vertices ");
			for (int j = 0; j < ls.outEdges(i).size(); j++)
				System.out.print(ls.object(i, j) + ", ");
			System.out.println("");
		}
		ls.removeEdge(1, 3);
		System.out.println(" ");
		for (int i = 0; i< 5; i++){
			System.out.print(Integer.toString(i) + " has edges with vertices ");
			for (int j = 0; j < ls.outEdges(i).size(); j++)
				System.out.print(ls.object(i, j) + ", ");
			System.out.println("");
		}
		//objects and pointers
		ArrayList<Vertex> objects = new ArrayList<Vertex>();
		for (int i = 0; i < 5; i++){
			objects.add(new Vertex(i));
		}
		objects.get(1).connect(objects.get(4));
		objects.get(4).connect(objects.get(1));

		objects.get(2).connect(objects.get(4));
		objects.get(4).connect(objects.get(2));

		objects.get(3).connect(objects.get(4));
		objects.get(4).connect(objects.get(3));
		for (int i = 0; i < objects.size(); i++){
			for (int j = 0; j < objects.get(i).edges.size(); j++){
				System.out.println("Vertex: " + Integer.toString(objects.get(i).name) + " has edges: " + objects.get(i).edges.get(j).v1.name + ", " + objects.get(i).edges.get(j).v2.name);
			}
		}
	}
}
