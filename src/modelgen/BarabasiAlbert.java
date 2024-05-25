package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BarabasiAlbert<V, E> {

    public UndirectedSparseGraph<V, E> generateBA(int n, int m0, int p, int m, Class<V> vClass, Class<E> eClass) {
        ErdosRenyi<V, E> er = new ErdosRenyi<>();
        UndirectedSparseGraph<V, E> graph = er.generateER(m0, p, vClass, eClass);

        List<Integer> degs = new ArrayList<>();
        int ix = 0;
        for (V vertex : graph.getVertices()) {
            for (int j = 0; j < graph.degree(vertex); j++) {
                degs.add(ix);
            }
            ix++;
        }
        for (int i = m0; i < n; i++) {
            try {
                V vertex = vClass.getDeclaredConstructor().newInstance();
                graph.addVertex(vertex);
            } catch (Exception e) {
                throw new IllegalArgumentException("Class V must contain constructor!");
            }
            Object[] vertices = graph.getVertices().toArray();
            for (int j = 0; j < m; j++) {
                int old = (int) (Math.random() * degs.size());
                try {
                    E edge = eClass.getDeclaredConstructor().newInstance();
                    graph.addEdge(edge, (V) vertices[i], (V) vertices[old]);
                } catch (Exception e) {
                    throw new IllegalArgumentException("Class E must contain constructor!");
                }
                degs.add(old);
            }
            for (int j = 0; j < m; j++) {
                degs.add(i);
            }
        }
        return graph;
    }
}
