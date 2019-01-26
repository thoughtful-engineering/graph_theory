package graph_processing_algo;

public interface PathAlgo {

	boolean hasPathTo(int v);

	Iterable<Integer> path(int v);
}
