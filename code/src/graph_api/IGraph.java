package graph_api;

public interface IGraph {

	void addEdge(int v, int w);

	Iterable<Integer> adjacents(int v);

	int edges();

	int vertices();
}
