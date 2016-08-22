package Graph;

import java.util.ArrayList;

public class Vertex {
	public int name;
	ArrayList<Edges> edges = new ArrayList<Edges>();
	State state = State.Unvisited;
	public enum State{
		Visted, Unvisited;
	}
	
	public Vertex(int name){
		this.setName(name);
	}
	public void connect(Vertex v){
		edges.add(new Edges(this, v));
	}
	public Vertex[] getAdjacent(){
		Vertex[] adj = new Vertex[edges.size()];
		for (int i = 0; i < edges.size(); i++){
			adj[i] = edges.get(i).v2;
		}
		
		return adj;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
}
