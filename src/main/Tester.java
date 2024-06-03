package main;

import decomposition.BatageljZaversnik;
import decomposition.Straightforward;
import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;
import graphinput.GraphLoader;
import modelgen.BarabasiAlbert;
import modelgen.ErdosRenyi;
import modelgen.ErdosRenyiT;
import modelgen.PlantedPartition;

import java.util.Map;

public class Tester {

    public static void main(String[] args) {
        GraphLoader gl = new GraphLoader();


//        BarabasiAlbert<Vertex, Edge> bagen = new BarabasiAlbert<>();
        ErdosRenyiT<Integer, String> erdosRenyi = new ErdosRenyiT<>();
//        PlantedPartition<Vertex, Edge> plantedPartition = new PlantedPartition<>();
        //fix barabasi albert
//        UndirectedSparseGraph<Vertex, Edge> graph = bagen.generateBA(10000, 1000, 0.001, 100, Vertex.class, Edge.class);
        UndirectedSparseGraph<Integer, String> graph = erdosRenyi.generateER(10000, 0.001, i -> i, s -> s);
//        UndirectedSparseGraph<Vertex, Edge> graph = plantedPartition.generatePP(1000, 0.1, 0.03, 0.01, 0.001, Vertex.class, Edge.class);

        System.out.println(graph.degree(0));
//        UndirectedSparseGraph<Integer, String> graph = gl.loadLastFMAsia();
        BatageljZaversnik<Integer, String> bz = new BatageljZaversnik<>(graph);
//        Straightforward<Integer, String> sf = new Straightforward<>(graph);
//        System.out.println(sf.getCore(sf.getMaxShellIndex()).getVertices());
        System.out.println(bz.getCore(bz.getMaxShellIndex()).getVertices());

        System.out.println(bz.getMaxShellIndex());
//        System.out.println(graph.getEdges());
    }
}
