package graph_processing_algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import graph_api.IGraph;

public class BFS implements PathAlgo{

	private final int s;
	private boolean[] visited;
	private int[] edgeTo;
	private int[] distTo;
	
	
	
	public BFS(int root,IGraph g) {
		this.s = root;
		visited = new boolean[g.vertices()];
		edgeTo = new int[g.vertices()];
		distTo = new int[g.vertices()];
		bfs(g);
	}
	
	private void bfs(IGraph g) {
		Queue<Integer> q = new LinkedBlockingQueue<>();
		q.add(s);
		visited[s] = true;
		edgeTo[s] = s;
		distTo[s] = 0;
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int w : g.adjacents(v)) {
				if(!visited[w]) {
					q.add(w);
					visited[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
				}
			}
		}
	}
	
	int level(int v) {
		return distTo[v];
	}

	@Override
	public boolean hasPathTo(int v) {
		return visited[v];
	}

	@Override
	public Iterable<Integer> path(int v) {
		List<Integer> list = new ArrayList<>();
		for (int w = v; w != s; w = edgeTo[w]) {
			list.add(w);
		}
		list.add(s);
		return list;
	}

}
