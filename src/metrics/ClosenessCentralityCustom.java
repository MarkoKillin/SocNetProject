package metrics;

import edu.uci.ics.jung.algorithms.shortestpath.UnweightedShortestPath;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.util.HashMap;
import java.util.Map;

public class ClosenessCentralityCustom {
    private UndirectedSparseGraph<Integer, String> graph;
    private Map<Integer, Double> closenessMap;

    public ClosenessCentralityCustom(UndirectedSparseGraph<Integer, String> graph) {
        if (graph == null)
            throw new IllegalArgumentException("graph is null");
        this.graph = graph;
        this.closenessMap = new HashMap<Integer, Double>();
        evaluate();
    }

    public Map<Integer, Double> getClosenessMap() {
        return closenessMap;
    }

    private void evaluate() {
        int numOfVertices = graph.getVertexCount();
        for (Integer vertex : graph.getVertices()) {
            UnweightedShortestPath<Integer, String> udsp = new UnweightedShortestPath<>(graph);
            Map<Integer, Number> vertexDistances = udsp.getDistanceMap(vertex);
            double distance = 0;
            for (Number value : vertexDistances.values()) {
                distance += value.doubleValue();
            }
            double closeness = (numOfVertices - 1) / distance;
            closenessMap.put(vertex, closeness);
        }
    }
}
