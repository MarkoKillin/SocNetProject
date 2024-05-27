package decomposition;

import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.util.HashMap;
import java.util.Map;

public class Straightforward<V, E> {
    private UndirectedGraph<V, E> graph;

    public Straightforward(UndirectedGraph<V, E> graphToDecompose) {
        if (graphToDecompose == null || graphToDecompose.getVertexCount() == 0)
            throw new IllegalArgumentException("Graph must contain at least 1 node!");
        this.graph = new UndirectedSparseGraph<>();

        for (V v : graphToDecompose.getVertices()) {
            this.graph.addVertex(v);
        }
        for (E e : graphToDecompose.getEdges()) {
            this.graph.addEdge(e, graphToDecompose.getIncidentVertices(e));
        }
    }

    public Map<V, Integer> decompose() {
        Map<V, Integer> indices = new HashMap<>();

        return indices;
    }

    public UndirectedSparseGraph<V, E> getCore(int shellIndex) {
        UndirectedSparseGraph<V, E> core = new UndirectedSparseGraph<>();

        return core;
    }
}
