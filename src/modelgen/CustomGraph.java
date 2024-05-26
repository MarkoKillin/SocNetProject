package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;

import java.util.ArrayList;
import java.util.List;

public class CustomGraph {

    public UndirectedSparseGraph<Vertex, Edge> getGraph1() {
        UndirectedSparseGraph<Vertex, Edge> graph = new UndirectedSparseGraph<>();
        List<Vertex> vertexList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Vertex v = new Vertex(Integer.toString(i));
            graph.addVertex(v);
            vertexList.add(v);
        }
        //draw graphs in gephy and test shell
        return graph;
    }

    public UndirectedSparseGraph<Vertex, Edge> getGraph2() {
        UndirectedSparseGraph<Vertex, Edge> graph = new UndirectedSparseGraph<>();
        List<Vertex> vertexList = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            Vertex v = new Vertex(Integer.toString(i));
            graph.addVertex(v);
            vertexList.add(v);
        }
        return graph;
    }

    public UndirectedSparseGraph<Vertex, Edge> getGraph3() {
        UndirectedSparseGraph<Vertex, Edge> graph = new UndirectedSparseGraph<>();
        List<Vertex> vertexList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Vertex v = new Vertex(Integer.toString(i));
            graph.addVertex(v);
            vertexList.add(v);
        }
        return graph;
    }
}
