package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.apache.commons.collections15.Transformer;

import java.util.ArrayList;
import java.util.List;

public class PlantedPartition<V, E> {

    public UndirectedSparseGraph<V, E> generatePP(int n, double coreNodes, double coreProbability,
                                                  double peripheryProbability, double corePeripheryProbability,
                                                  Transformer<Integer, V> vTransformer, Transformer<String, E> eTransformer) {
        UndirectedSparseGraph<V, E> graph = new UndirectedSparseGraph<>();
        int numOfCoreNodes = (int) (n * coreNodes);
        List<V> coreVertices = new ArrayList<>(numOfCoreNodes);
        for (int i = 0; i < numOfCoreNodes; i++) {
            V vertex = vTransformer.transform(i);
            coreVertices.add(vertex);
            graph.addVertex(vertex);
        }
        int numOfPeripheryNodes = n - numOfCoreNodes;
        List<V> peripheryVertices = new ArrayList<>(numOfPeripheryNodes);
        for (int i = numOfCoreNodes; i < n; i++) {
            V vertex = vTransformer.transform(i);
            peripheryVertices.add(vertex);
            graph.addVertex(vertex);
        }
        List<V> vertices = graph.getVertices().stream().toList();
        for (int i = 0; i < n; i++) {
            V vertex1 = vertices.get(i);
            for (int j = i + 1; j < n; j++) {
                V vertex2 = vertices.get(j);
                if (coreVertices.contains(vertex1) && coreVertices.contains(vertex2) && Math.random() <= coreProbability) {
                    E edge = eTransformer.transform(vertex1 + " - " + vertex2);
                    graph.addEdge(edge, vertex1, vertex2, EdgeType.UNDIRECTED);
                } else if (peripheryVertices.contains(vertex1) && peripheryVertices.contains(vertex2) && Math.random() <= peripheryProbability) {
                    E edge = eTransformer.transform(vertex1 + " - " + vertex2);
                    graph.addEdge(edge, vertex1, vertex2, EdgeType.UNDIRECTED);
                } else if (Math.random() <= corePeripheryProbability) {
                    E edge = eTransformer.transform(vertex1 + " - " + vertex2);
                    graph.addEdge(edge, vertex1, vertex2, EdgeType.UNDIRECTED);
                }
            }
        }
        return graph;
    }
}
