package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings({"unchecked"})
public class ErdosRenyi<V, E> {

    public UndirectedSparseGraph<V, E> generateER(int n, double p, Class<V> vClass, Class<E> eClass) {
        UndirectedSparseGraph<V, E> graph = new UndirectedSparseGraph<>();
        try {
            for (int i = 0; i < n; i++) {
                V v = vClass.getDeclaredConstructor().newInstance();
                graph.addVertex(v);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Class V must contain constructor!");
        }
        Object[] vertices = graph.getVertices().toArray();
        for (int i = 0; i < vertices.length; i++) {
            for (int j = i + 1; j < vertices.length; j++) {
                if (Math.random() <= p) {
                    try {
                        E edge = eClass.getDeclaredConstructor().newInstance();
                        graph.addEdge(edge, (V) vertices[i], (V) vertices[j], EdgeType.UNDIRECTED);
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Class E must contain constructor!");
                    }
                }
            }
        }

        return graph;
    }
}
