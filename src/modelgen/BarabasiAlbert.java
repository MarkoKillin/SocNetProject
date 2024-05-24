package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.util.ArrayList;
import java.util.List;

public class BarabasiAlbert<V, E> {

    public UndirectedSparseGraph<V, E> generateBA(int n, int m0, int p, int m) {
        ErdosRenyi<V, E> er = new ErdosRenyi<>();
        UndirectedSparseGraph<V, E> graph = er.generateER(m0, p);

        List<Integer> degs = new ArrayList<>();
        int ix = 0;
        for (V vertex : graph.getVertices()) {
            for (int j = 0; j < graph.degree(vertex); j++) {
                degs.add(ix);
            }
            ix++;
        }

        for (int i = m0; i < n; i++) {
            //graph.addVertex(i);
            for (int j = 0; j < m; j++) {
                int old = (int) (Math.random() * degs.size());
                //graph.addEdge(i, old);
                degs.add(old);
            }
            for(int j = 0; j < m; j++) {
                degs.add(i);
            }
        }
        return graph;
    }
}
