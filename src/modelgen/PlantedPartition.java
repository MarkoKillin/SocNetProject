package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class PlantedPartition<V, E> {

    public UndirectedSparseGraph<V, E> generatePP(int n, double z, double p, double q, Class<V> vClass, Class<E> eClass) {
        UndirectedSparseGraph<V, E> graph = new UndirectedSparseGraph<>();
            int i = graph.getVertexCount();
        return graph;
    }
}
