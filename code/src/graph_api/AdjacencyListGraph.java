package graph_api;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements IGraph {

	private final int V;
	private final int E;

	private final List<Integer>[] adjacencyList;

	public AdjacencyListGraph(int v, int e) {
		this.V = v;
		this.E = e;
		adjacencyList = new List[v];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new ArrayList<>();
		}
	}

	@Override
	public void addEdge(int v, int w) {
		adjacencyList[v].add(w);
		adjacencyList[w].add(v);
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
