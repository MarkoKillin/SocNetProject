package main;

import decomposition.BatageljZaversnik;
import decomposition.Straightforward;
import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphio.GraphExporter;
import graphio.GraphLoader;
import metrics.GraphMetrics;
import modelgen.BarabasiAlbert;
import modelgen.ErdosRenyi;

public class Tester {

    public static void main(String[] args) {
//        GraphLoader gl = new GraphLoader();


//        BarabasiAlbert<Integer, String> bagen = new BarabasiAlbert<>();
//        PlantedPartition<Vertex, Edge> plantedPartition = new PlantedPartition<>();
        //fix barabasi albert
//        UndirectedSparseGraph<Integer, String> graph = bagen.generateBA(10000, 1000, 0.001, 100, i -> i, e -> e);
//        UndirectedSparseGraph<Integer, String> graph = erdosRenyi.generateER(3000, 0.001, i -> i, s -> s);
//        UndirectedSparseGraph<Vertex, Edge> graph = plantedPartition.generatePP(1000, 0.1, 0.03, 0.01, 0.001, Vertex.class, Edge.class);

//        System.out.println(graph.degree(0));
//        UndirectedSparseGraph<Integer, String> graph = gl.loadLastFMAsia();
//        BatageljZaversnik<Integer, String> bz = new BatageljZaversnik<>(graph);
//        Straightforward<Integer, String> sf = new Straightforward<>(graph);
//        System.out.println(bz.getCore(bz.getMaxShellIndex()).getVertices());
//        System.out.println(bz.getMaxShellIndex());
//
//        System.out.println(sf.getCore(sf.getMaxShellIndex()).getVertices());
//        System.out.println(sf.getMaxShellIndex());
//        long s = System.currentTimeMillis();
//        BetweennessCentrality<Integer, String> bc = new BetweennessCentrality<>(graph);
//        System.out.println((System.currentTimeMillis() - s) / 1000.0);
//        GraphExporter ge = new GraphExporter();
//        ge.exportGraphAsCSV(graph, "test");

//        System.out.println(graph.getEdges());

        long time = System.currentTimeMillis();
        ErdosRenyi<Integer, String> er = new ErdosRenyi<>();
        UndirectedSparseGraph<Integer, String> graph = er.generateER(2000, 0.01, i -> i, s -> s);
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        GraphMetrics m = new GraphMetrics();
        m.calculateMetrics(graph, "ErdosRenyi1k");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);
    }
}
