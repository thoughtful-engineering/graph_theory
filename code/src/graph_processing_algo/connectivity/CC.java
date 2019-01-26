package graph_processing_algo.connectivity;

import graph_api.IGraph;

public class CC implements IConnectedComponents {

	private boolean[] visited;
	private int[] id;
	private int count;
	
	public CC(IGraph g) {
		for(int i = 0; i<g.vertices();i++) {
			if(!visited[i]) {
				dfs(g,i);
				count++;
			}
		}
	}
	
	private void dfs(IGraph g, int i) {
		visited[i] = true;
		id[i] = count;
		for(int w: g.adjacents(i)) {
			if(!visited[w]) {
				dfs(g, w);
			}
				
		}
	}

	@Override
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int id(int v) {
		return id[v];
	}

}
