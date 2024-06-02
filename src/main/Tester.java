package main;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;
import graphinput.GraphLoader;
import modelgen.BarabasiAlbert;
import modelgen.ErdosRenyi;
import modelgen.PlantedPartition;

public class Tester {

    public static void main(String[] args) {
        GraphLoader gl = new GraphLoader();
        UndirectedSparseGraph<Vertex, Edge> graph = gl.loadLastFMAsia();
//        System.out.println(graph.getEdges());


//        BarabasiAlbert<Vertex, Edge> bagen = new BarabasiAlbert<>();
//        ErdosRenyi<Vertex, Edge> erdosRenyi = new ErdosRenyi<>();
//        PlantedPartition<Vertex, Edge> plantedPartition = new PlantedPartition<>();
        //fix barabasi albert
//        UndirectedSparseGraph<Vertex, Edge> graph = bagen.generateBA(10000, 1000, 0.001, 100, Vertex.class, Edge.class);
//        UndirectedSparseGraph<Vertex, Edge> graph = erdosRenyi.generateER(10000, 0.001, Vertex.class, Edge.class);
//        UndirectedSparseGraph<Vertex, Edge> graph = plantedPartition.generatePP(1000, 0.1, 0.03, 0.01, 0.001, Vertex.class, Edge.class);

        System.out.println(graph.getEdges());
    }
}
