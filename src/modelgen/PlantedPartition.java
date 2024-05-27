package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.util.ArrayList;
import java.util.List;

public class PlantedPartition<V, E> {

    public UndirectedSparseGraph<V, E> generatePP(int n, double coreNodes, double coreProbability, double peripheryProbability, double corePeripheryProbability, Class<V> vClass, Class<E> eClass) {
        UndirectedSparseGraph<V, E> graph = new UndirectedSparseGraph<>();
            int numOfCoreNodes = (int) (n * coreNodes);
            List<V> coreVertices = new ArrayList<>(numOfCoreNodes);
            for (int i = 0; i < numOfCoreNodes; i++) {
                try {
                    V vertex = vClass.getDeclaredConstructor().newInstance();
                    coreVertices.add(vertex);
                    graph.addVertex(vertex);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Class V must contain constructor!");
                }
            }
            int numOfPeripheryNodes = n - numOfCoreNodes;
            List<V> peripheryVertices = new ArrayList<>(numOfPeripheryNodes);
            for (int i = 0; i < numOfPeripheryNodes; i++) {
                try {
                    V vertex = vClass.getDeclaredConstructor().newInstance();
                    peripheryVertices.add(vertex);
                    graph.addVertex(vertex);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Class V must contain constructor!");
                }
            }
            List<V> vertices = graph.getVertices().stream().toList();
            for (int i = 0; i < n; i++) {
                V vertex1 = vertices.get(i);
                for (int j = i + 1; j < n; j++) {
                    V vertex2 = vertices.get(j);
                    if (coreVertices.contains(vertex1) && coreVertices.contains(vertex2) && Math.random() <= coreProbability) {
                        try {
                            E edge = eClass.getDeclaredConstructor().newInstance();
                            graph.addEdge(edge, vertex1, vertex2, EdgeType.UNDIRECTED);
                        } catch (Exception e){
                            throw new IllegalArgumentException("Class E must contain constructor!");
                        }
                    } else if (peripheryVertices.contains(vertex1) && peripheryVertices.contains(vertex2) && Math.random() <= peripheryProbability) {
                        try {
                            E edge = eClass.getDeclaredConstructor().newInstance();
                            graph.addEdge(edge, vertex1, vertex2, EdgeType.UNDIRECTED);
                        } catch (Exception e){
                            throw new IllegalArgumentException("Class E must contain constructor!");
                        }
                    } else if(Math.random() <= corePeripheryProbability) {
                        try {
                            E edge = eClass.getDeclaredConstructor().newInstance();
                            graph.addEdge(edge, vertex1, vertex2, EdgeType.UNDIRECTED);
                        } catch (Exception e){
                            throw new IllegalArgumentException("Class E must contain constructor!");
                        }
                    }
                }
            }
        return graph;
    }
}
