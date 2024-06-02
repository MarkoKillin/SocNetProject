package main;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;
import graphinput.GraphLoader;

public class Tester {

    public static void main(String[] args) {
        GraphLoader gl = new GraphLoader();
        UndirectedSparseGraph<Vertex, Edge> graph = gl.loadGeneralRelativityColaboration();
        System.out.println(graph.getEdges());
    }
}
