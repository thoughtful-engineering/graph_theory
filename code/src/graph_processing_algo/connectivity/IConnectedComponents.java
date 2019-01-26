package graph_processing_algo.connectivity;

public interface IConnectedComponents {
	boolean connected(int v, int w);

	int count();

	int id(int v);
}
