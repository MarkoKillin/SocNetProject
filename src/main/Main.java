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
        GraphLoader gl = new GraphLoader();
        GraphMetrics m = new GraphMetrics();
        CustomGraph cgraph = new CustomGraph();
        GraphExporter graphexp = new GraphExporter();
        DecompositionMetrics dm = new DecompositionMetrics();
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

        //comparing Batagelj-Zaversnik and Straighforward on artificial networks
        ErdosRenyi<Integer, String> er = new ErdosRenyi<>();
        BarabasiAlbert<Integer, String> ba = new BarabasiAlbert<>();
        PlantedPartition<Integer, String> pp = new PlantedPartition<>();
        UndirectedSparseGraph<Integer, String> graphErdos = er.generateER(3000, 0.01, i -> i, s -> s);
        UndirectedSparseGraph<Integer, String> graphBarabasi = ba.generateBA(3000, 30, 0.01, 10, i -> i, e -> e);
        UndirectedSparseGraph<Integer, String> graphPlanted = pp.generatePP(3000, 0.9, 0.02,
                0.001, 0.005, i -> i, s -> s);
        dm.exportDecompositionAsCSV(graphErdos, "Erdos-Renyi");
        System.out.println("Erdos-Renyi done.");
        dm.exportDecompositionAsCSV(graphBarabasi, "Barabasi-Albert");
        System.out.println("Barabasi-Albert done.");
        dm.exportDecompositionAsCSV(graphPlanted, "PlantedPartition");
        System.out.println("PlantedPartition done.");


        //first network
        long time = System.currentTimeMillis();
        UndirectedSparseGraph<Integer, String> graphFacebook = gl.loadFacebookPages();
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        m.calculateMetrics(graphFacebook, "FacebookPages");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //second network
        time = System.currentTimeMillis();
        UndirectedSparseGraph<Integer, String> graphHepPh = gl.loadHepPh();
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        m.calculateMetrics(graphHepPh, "HepPh");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //third network home
        time = System.currentTimeMillis();
        UndirectedSparseGraph<Integer, String> graphAstroPh = gl.loadAstroPh();
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        m.calculateMetrics(graphAstroPh, "AstroPhysics");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //fourth network
        time = System.currentTimeMillis();
        UndirectedSparseGraph<Integer, String> graphDBLP = gl.loadDBLP();
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        m.calculateMetrics(graphDBLP, "DBLP");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //fifth network
        time = System.currentTimeMillis();
        UndirectedSparseGraph<Integer, String> graphEpinions = gl.loadEpinions();
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        m.calculateMetrics(graphEpinions, "Epinions");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //sixth network
        time = System.currentTimeMillis();
        UndirectedSparseGraph<Integer, String> graphGemsec = gl.loadGemsec();
        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
        m.calculateMetrics(graphGemsec, "Gemsec");
        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //erdos-renyi network just for testing and some graphics
//        long time = System.currentTimeMillis();
//        ErdosRenyi<Integer, String> er = new ErdosRenyi<>();
//        UndirectedSparseGraph<Integer, String> graph = er.generateER(3000, 0.01, i -> i, s -> s);
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "ErdosRenyi3k");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //barabasi-albert network just for testing and some graphics
//        long time = System.currentTimeMillis();
//        BarabasiAlbert<Integer, String> ba = new BarabasiAlbert<>();
//        UndirectedSparseGraph<Integer, String> graph = ba.generateBA(3000, 30, 0.01, 10, i -> i, e -> e);
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "BarabasiAlbert3k");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);

        //plantedpartition network just for testing and some graphics
//        long time = System.currentTimeMillis();
//        PlantedPartition<Integer, String> pp = new PlantedPartition<>();
//        UndirectedSparseGraph<Integer, String> graph = pp.generatePP(3000, 0.9, 0.02,
//                0.001, 0.005, i -> i, s -> s);
//        System.out.println("generated in ---- " + (System.currentTimeMillis() - time)/1000.0);
//        GraphMetrics m = new GraphMetrics();
//        m.calculateMetrics(graph, "PlantedPartition");
//        System.out.println("done in ---- " + (System.currentTimeMillis() - time)/1000.0);


    }
}
