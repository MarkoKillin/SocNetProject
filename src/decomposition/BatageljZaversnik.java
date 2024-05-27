package decomposition;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.util.*;
import java.util.stream.Collectors;


public class BatageljZaversnik<V, E> {
    private UndirectedSparseGraph<V, E> graph;

    public BatageljZaversnik(UndirectedSparseGraph<V, E> graph) {
        if (graph == null || graph.getVertexCount() == 0)
            throw new IllegalArgumentException("Graph must contain at least 1 node!");
        this.graph = graph;
    }

    public Map<V, Integer> decompose() {
        Map<V, Integer> indices = new HashMap<>();
        int maxDegree = graph.getVertices().parallelStream()
                .mapToInt(graph::degree)
                .max()
                .orElse(0);

        ArrayList<Set<V>> boxes = new ArrayList<>(maxDegree + 1);
        for (int i = 0; i <= maxDegree; i++) {
            boxes.add(new HashSet<>());
        }
        for (V vertex : graph.getVertices()) {
            int degree = graph.degree(vertex);
            indices.put(vertex, degree);
            boxes.get(degree).add(vertex);
        }
        for (int k = 0; k <= maxDegree; k++) {
            Set<V> box = boxes.get(k);
            Iterator<V> iterator = box.iterator();
            while (iterator.hasNext()) {
                V x = iterator.next();
                iterator.remove();
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

    public UndirectedSparseGraph<V, E> getCore(int shellIndex) {
        UndirectedSparseGraph<V, E> core = new UndirectedSparseGraph<>();
        Map<V, Integer> indecies = decompose();

        for (V vertex : graph.getVertices()) {
            core.addVertex(vertex);
        }
        for (E edge : graph.getEdges()) {
            core.addEdge(edge, graph.getIncidentVertices(edge), EdgeType.UNDIRECTED);
        }

        Set<V> toRemove = indecies.keySet().parallelStream().filter(x -> indecies.get(x) < shellIndex).collect(Collectors.toSet());

        for (V vertex : toRemove) {
            core.removeVertex(vertex);
        }

        return core;
    }
}
