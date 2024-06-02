package main;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;
import graphinput.GraphLoader;
import modelgen.BarabasiAlbert;
import modelgen.ErdosRenyi;

public class Tester {

    public static void main(String[] args) {
//        GraphLoader gl = new GraphLoader();
//        UndirectedSparseGraph<Vertex, Edge> graph = gl.loadGeneralRelativityColaboration();
//        System.out.println(graph.getEdges());

        BarabasiAlbert<Vertex, Edge> bagen = new BarabasiAlbert<>();
        ErdosRenyi<Vertex, Edge> erdosRenyi = new ErdosRenyi<>();
        //fix barabasi albert
//        UndirectedSparseGraph<Vertex, Edge> graph = bagen.generateBA(10000, 1000, 0.001, 100, Vertex.class, Edge.class);
        UndirectedSparseGraph<Vertex, Edge> graph = erdosRenyi.generateER(30000, 0.001, Vertex.class, Edge.class);
        System.out.println(graph.getVertices());
    }
}
