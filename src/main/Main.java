package main;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphio.GraphExporter;
import graphio.GraphLoader;
import metrics.DecompositionMetrics;
import metrics.GraphMetrics;
import modelgen.BarabasiAlbert;
import modelgen.CustomGraph;
import modelgen.ErdosRenyi;
import modelgen.PlantedPartition;

public class Main {
    public static void main(String[] args) {
        //comparing Batagelj-Zaversnik and Straighforward on custom graphs
//        CustomGraph cgraph = new CustomGraph();
//        GraphExporter graphexp = new GraphExporter();
//        DecompositionMetrics dm = new DecompositionMetrics();
//        UndirectedSparseGraph<Integer, String> cg1 = cgraph.getGraph1();
//        UndirectedSparseGraph<Integer, String> cg2 = cgraph.getGraph2();
//        UndirectedSparseGraph<Integer, String> cg3 = cgraph.getGraph3();
//        graphexp.exportGraphAsCSV(cg1, "customgraph1");
//        graphexp.exportGraphAsCSV(cg2, "customgraph2");
//        graphexp.exportGraphAsCSV(cg3, "customgraph3");
//        dm.exportDecompositionAsCSV(cg1, "customgraph1");
//        dm.exportDecompositionAsCSV(cg2, "customgraph2");
//        dm.exportDecompositionAsCSV(cg3, "customgraph3");
//        System.out.println("Exported.");


        //first network
//        long time = System.currentTimeMillis();
//        GraphLoader gl = new GraphLoader();
//        UndirectedSparseGraph<Integer, String> graph = gl.loadLastFMAsia();
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "LastFmAsia");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //second network
//        long time = System.currentTimeMillis();
//        GraphLoader gl = new GraphLoader();
//        UndirectedSparseGraph<Integer, String> graph = gl.loadHighEnergyPhysicsColaboration();
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "Physics");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //third network not completed
//        long time = System.currentTimeMillis();
//        GraphLoader gl = new GraphLoader();
//        UndirectedSparseGraph<Integer, String> graph = gl.loadAstroPh();
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "AstroPhysics");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //fourth network current
//        long time = System.currentTimeMillis();
//        GraphLoader gl = new GraphLoader();
//        UndirectedSparseGraph<Integer, String> graph = gl.loadDBLP();
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "DBLP");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //erdos-renyi network
        long time = System.currentTimeMillis();
        ErdosRenyi<Integer, String> er = new ErdosRenyi<>();
        UndirectedSparseGraph<Integer, String> graph = er.generateER(2000, 0.01, i -> i, s -> s);
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        GraphMetrics m = new GraphMetrics();
        m.calculateMetrics(graph, "ErdosRenyi2k");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //barabasi-albert network
//        long time = System.currentTimeMillis();
//        BarabasiAlbert<Integer, String> ba = new BarabasiAlbert<>();
//        UndirectedSparseGraph<Integer, String> graph = ba.generateBA();
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "BarabasiAlbert3k");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //plantedpartition network
//        long time = System.currentTimeMillis();
//        PlantedPartition<Integer, String> pp = new PlantedPartition<>();
//        UndirectedSparseGraph<Integer, String> graph = pp.generatePP();
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "PlantedPartition");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);
    }
}
