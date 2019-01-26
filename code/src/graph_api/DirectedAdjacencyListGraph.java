package graph_api;

import java.util.ArrayList;
import java.util.List;

public class DirectedAdjacencyListGraph implements IGraph {

	private final int V;
	private final int E;

	private final List<Integer>[] adjacencyList;

	public DirectedAdjacencyListGraph(int v, int e) {
		this.V = v;
		this.E = e;
		adjacencyList = new List[v];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new ArrayList<>();
		}
	}

	@Override
	public void addEdge(int v, int w) { //v -> w
		adjacencyList[v].add(w);
	}

	@Override
	public Iterable<Integer> adjacents(int v) {
		return adjacencyList[v];
	}

	@Override
	public int edges() {
		return V;
	}

	@Override
	public int vertices() {
		return E;
	}

}
