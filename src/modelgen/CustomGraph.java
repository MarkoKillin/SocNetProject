package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
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
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(0), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(1), vertexList.get(4), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(1), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(2), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(2), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(3), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(5), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(5), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(8), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(9), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(10), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(11), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(12), vertexList.get(13), EdgeType.UNDIRECTED);
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
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(16), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(14), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(14), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(13), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(13), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(11), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(10), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(9), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(8), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(7), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(4), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(3), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(2), vertexList.get(0), EdgeType.UNDIRECTED);
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
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(17), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(15), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(19), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(16), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(4), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(18), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(17), vertexList.get(16), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(17), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(17), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(16), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(15), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(14), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(13), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(12), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(12), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(11), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(10), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(10), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(10), vertexList.get(4), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(9), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(6), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(6), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(6), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(5), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(3), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(3), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(3), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge(new Edge(), vertexList.get(1), vertexList.get(0), EdgeType.UNDIRECTED);
        return graph;
    }
}
