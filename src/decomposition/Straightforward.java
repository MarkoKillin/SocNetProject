package decomposition;

import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.util.*;

public class Straightforward<V, E> {
    private UndirectedSparseGraph<V, E> graphSafe;
    private UndirectedSparseGraph<V, E> graph;

    public Straightforward(UndirectedGraph<V, E> graphToDecompose) {
        if (graphToDecompose == null || graphToDecompose.getVertexCount() == 0)
            throw new IllegalArgumentException("Graph must contain at least 1 node!");
        this.graphSafe = new UndirectedSparseGraph<>();

        for (V v : graphToDecompose.getVertices()) {
            this.graphSafe.addVertex(v);
        }
        for (E e : graphToDecompose.getEdges()) {
            this.graphSafe.addEdge(e, graphToDecompose.getIncidentVertices(e));
        }
    }

    private void copyGraph() {
        this.graph = new UndirectedSparseGraph<>();
        for (V v : graphSafe.getVertices()) {
            this.graph.addVertex(v);
        }
        for (E e : graphSafe.getEdges()) {
            this.graph.addEdge(e, graphSafe.getIncidentVertices(e), EdgeType.UNDIRECTED);
        }
    }

    public Map<V, Integer> decompose() {
        copyGraph();
        Map<V, Integer> indices = new HashMap<>();
        int maxDegree = graph.getVertices().parallelStream()
                .mapToInt(graph::degree)
                .max()
                .orElse(0);
        int currentShellIndex = 0;
        while(graph.getVertexCount() > 0 && currentShellIndex <= maxDegree + 1) {
            List<V> currentCore = findCore(currentShellIndex);
            for (V v : currentCore) {
                indices.put(v, currentShellIndex - 1);
            }
            currentShellIndex++;
        }
        return indices;
    }

    private List<V> findCore(int currentShellIndex) {
        List<V> result = new ArrayList<>();
        boolean found = true;
        while (found) {
            found = false;
            Iterator<V> it = graph.getVertices().iterator();
            while (it.hasNext()) {
                V v = it.next();
                if (graph.degree(v) < currentShellIndex){
                    result.add(v);
                    it.remove();
                    found = true;
                }
            }
        }
        return result;
    }

    public UndirectedSparseGraph<V, E> getCore(int shellIndex) {
        copyGraph();
        boolean found = true;
        while (found) {
            found = false;
            Iterator<V> it = graph.getVertices().iterator();
            while (it.hasNext()) {
                V v = it.next();
                if (graph.degree(v) < shellIndex){
                    it.remove();
                    found = true;
                }
            }
        }
        return graph;
    }
}
