package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.apache.commons.collections15.Transformer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BarabasiAlbert<V, E> {

    public UndirectedSparseGraph<V, E> generateBA(int n, int m0, double p, int m, Transformer<Integer, V> vTransformer,
                                                  Transformer<String, E> eTransformer) {
        ErdosRenyi<V, E> er = new ErdosRenyi<>();
        UndirectedSparseGraph<V, E> graph = er.generateER(m0, p, vTransformer, eTransformer);

        List<V> degs = new ArrayList<>();
        for (V vertex : graph.getVertices()) {
            for (int j = 0; j < graph.degree(vertex); j++) {
                degs.add(vertex);
            }
        }

        for (int i = m0; i < n; i++) {
            V vertex = vTransformer.transform(i);
            graph.addVertex(vertex);
            for (int j = 0; j < m; j++) {
                int old = (int) (Math.random() * degs.size());
                V to = degs.get(old);
                E edge = eTransformer.transform(vertex + " - " + to);
                graph.addEdge(edge, vertex, to, EdgeType.UNDIRECTED);
                degs.add(to);
            }
            for (int j = 0; j < m; j++) {
                degs.add(vertex);
            }
        }
        return graph;
    }
}
