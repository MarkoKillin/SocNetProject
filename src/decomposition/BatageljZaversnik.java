package decomposition;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * BatageljZaversnik algorithm for kcore decomposition
 * Instancing this class starts decomposition
 *
 * @param <V> Vertex generic class
 * @param <E> Edge generic class
 */
public class BatageljZaversnik<V, E> {
    private UndirectedSparseGraph<V, E> graph;
    private Map<V, Integer> indecies;

    public BatageljZaversnik(UndirectedSparseGraph<V, E> graph) {
        if (graph == null || graph.getVertexCount() == 0)
            throw new IllegalArgumentException("Graph must contain at least 1 node!");
        this.graph = graph;
        this.indecies = decompose();
    }

    public Map<V, Integer> getShellIndecies() {
        return indecies;
    }

    public int getMaxShellIndex() {
        return this.indecies.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    private Map<V, Integer> decompose() {
        Map<V, Integer> indices = new HashMap<>();
        int maxDegree = graph.getVertices().stream()
                .mapToInt(graph::degree)
                .max()
                .orElse(0);

        ArrayList<ArrayList<V>> boxes = new ArrayList<>(maxDegree + 1);
        for (int i = 0; i <= maxDegree; i++) {
            boxes.add(new ArrayList<>());
        }
        for (V vertex : graph.getVertices()) {
            int degree = graph.degree(vertex);
            indices.put(vertex, degree);
            boxes.get(degree).add(vertex);
        }
        for (int k = 0; k <= maxDegree; k++) {
            ArrayList<V> box = boxes.get(k);
            while (!box.isEmpty()) {
                V x = box.remove(0);
                for (V v : graph.getNeighbors(x)) {
                    if (indices.get(v) > k) {
                        boxes.get(indices.get(v)).remove(v);
                        boxes.get(indices.get(v) - 1).add(v);
                        indices.put(v, indices.get(v) - 1);
                    }
                }
            }
        }
        return indices;
    }

    /**
     * Returns core as new graph. Does not restart decomposition!
     *
     * @param shellIndex - core
     * @return UndirectedSparceGraph as core
     */
    public UndirectedSparseGraph<V, E> getCore(int shellIndex) {
        UndirectedSparseGraph<V, E> core = new UndirectedSparseGraph<>();

        for (V vertex : graph.getVertices()) {
            core.addVertex(vertex);
        }
        for (E edge : graph.getEdges()) {
            core.addEdge(edge, graph.getIncidentVertices(edge), EdgeType.UNDIRECTED);
        }

        Set<V> toRemove = indecies.keySet().stream().filter(x -> indecies.get(x) < shellIndex).collect(Collectors.toSet());

        for (V vertex : toRemove) {
            core.removeVertex(vertex);
        }

        return core;
    }
}
