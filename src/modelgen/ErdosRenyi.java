package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.apache.commons.collections15.Transformer;

@SuppressWarnings({"unchecked"})
public class ErdosRenyi<V, E> {

    public UndirectedSparseGraph<V, E> generateER(int n, double p, Transformer<Integer, V> vTransformer,
                                                  Transformer<String, E> eTransformer) {
        UndirectedSparseGraph<V, E> graph = new UndirectedSparseGraph<>();
        for (int i = 0; i < n; i++) {
            V v = vTransformer.transform(i);
            graph.addVertex(v);
        }
        Object[] vertices = graph.getVertices().toArray();
        for (int i = 0; i < vertices.length; i++) {
            for (int j = i + 1; j < vertices.length; j++) {
                if (Math.random() <= p) {
                    V from = (V) vertices[i];
                    V to = (V) vertices[j];
                    E edge = eTransformer.transform(from + " - " + to);
                    graph.addEdge(edge, from, to, EdgeType.UNDIRECTED);
                }
            }
        }
        return graph;
    }
}
