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
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(1));
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(9));
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(12));
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(14));
        graph.addEdge(new Edge(), vertexList.get(1), vertexList.get(4));
        graph.addEdge(new Edge(), vertexList.get(1), vertexList.get(8));
        graph.addEdge(new Edge(), vertexList.get(2), vertexList.get(6));
        graph.addEdge(new Edge(), vertexList.get(2), vertexList.get(11));
        graph.addEdge(new Edge(), vertexList.get(3), vertexList.get(7));
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(9));
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(5));
        graph.addEdge(new Edge(), vertexList.get(5), vertexList.get(8));
        graph.addEdge(new Edge(), vertexList.get(5), vertexList.get(7));
        graph.addEdge(new Edge(), vertexList.get(8), vertexList.get(9));
        graph.addEdge(new Edge(), vertexList.get(9), vertexList.get(11));
        graph.addEdge(new Edge(), vertexList.get(10), vertexList.get(13));
        graph.addEdge(new Edge(), vertexList.get(11), vertexList.get(12));
        graph.addEdge(new Edge(), vertexList.get(12), vertexList.get(13));
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
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(0));
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(1));
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(3));
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(5));
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(6));
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(11));
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(14));
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(16));
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(5));
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(6));
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(10));
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(12));
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(13));
        graph.addEdge(new Edge(), vertexList.get(14), vertexList.get(0));
        graph.addEdge(new Edge(), vertexList.get(14), vertexList.get(1));
        graph.addEdge(new Edge(), vertexList.get(13), vertexList.get(5));
        graph.addEdge(new Edge(), vertexList.get(13), vertexList.get(12));
        graph.addEdge(new Edge(), vertexList.get(11), vertexList.get(7));
        graph.addEdge(new Edge(), vertexList.get(10), vertexList.get(9));
        graph.addEdge(new Edge(), vertexList.get(9), vertexList.get(8));
        graph.addEdge(new Edge(), vertexList.get(8), vertexList.get(7));
        graph.addEdge(new Edge(), vertexList.get(7), vertexList.get(6));
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(3));
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(2));
        graph.addEdge(new Edge(), vertexList.get(3), vertexList.get(2));
        graph.addEdge(new Edge(), vertexList.get(2), vertexList.get(0));
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
