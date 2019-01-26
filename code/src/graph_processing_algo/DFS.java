package graph_processing_algo;

import java.util.ArrayList;
import java.util.List;

import graph_api.IGraph;

public class DFS implements PathAlgo {

	private final int root;
	private boolean[] visited;
	private int[] edgeTo;

	public DFS(int root, IGraph g) {
		this.root = root;
		visited = new boolean[g.vertices()];
		edgeTo = new int[g.vertices()];
		dfs(g, root);
	}

	private void dfs(IGraph g, int v) { 
		visited[v] = true;
		for (int w : g.adjacents(v)) {
			if (!visited[w]) {
				edgeTo[w] = v;
				dfs(g, w);
			}
		}
	}

	@Override
	public boolean hasPathTo(int v) {
		return visited[v];
	}

	@Override
	public Iterable<Integer> path(int v) {
		List<Integer> list = new ArrayList<>();
		for (int w = v; w != root; w = edgeTo[w]) {
			list.add(w);
		}
		list.add(root);
		return list;
	}

}
