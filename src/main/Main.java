package main;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphio.GraphLoader;
import metrics.GraphMetrics;

public class Main {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        GraphLoader gl = new GraphLoader();
        UndirectedSparseGraph<Integer, String> graph = gl.loadLastFMAsia();
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        GraphMetrics m = new GraphMetrics();
        m.calculateMetrics(graph, "LastFmAsia");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);
    }
}
