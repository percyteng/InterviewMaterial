package Graph;

import java.util.ArrayList;

public class Vertex {
	int name;
	ArrayList<Edges> edges = new ArrayList<Edges>();
	
	public Vertex(int name){
		this.name = name;
	}
	public void connect(Vertex v){
		edges.add(new Edges(this, v));
	}
}
