package modelgen;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.util.ArrayList;
import java.util.List;

public class CustomGraph {

    public UndirectedSparseGraph<Integer, String> getGraph1() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        List<Integer> vertexList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            graph.addVertex(i);
            vertexList.add(i);
        }
        graph.addEdge("0 - 1", vertexList.get(0), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge("0 - 9", vertexList.get(0), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge("0 - 12", vertexList.get(0), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge("0 - 14", vertexList.get(0), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge("1 - 4", vertexList.get(1), vertexList.get(4), EdgeType.UNDIRECTED);
        graph.addEdge("1 - 8", vertexList.get(1), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge("2 - 6", vertexList.get(2), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge("2 - 11", vertexList.get(2), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge("3 - 7", vertexList.get(3), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge("4 - 9", vertexList.get(4), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge("4 - 5", vertexList.get(4), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge("5 - 8", vertexList.get(5), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge("5 - 7", vertexList.get(5), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge("8 - 9", vertexList.get(8), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge("9 - 11", vertexList.get(9), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge("10 - 13", vertexList.get(10), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge("11 - 12", vertexList.get(11), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge("12 - 13", vertexList.get(12), vertexList.get(13), EdgeType.UNDIRECTED);
        return graph;
    }

    public UndirectedSparseGraph<Integer, String> getGraph2() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        List<Integer> vertexList = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            graph.addVertex(i);
            vertexList.add(i);
        }
        graph.addEdge("15 - 0", vertexList.get(15), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 1", vertexList.get(15), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 3", vertexList.get(15), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 5", vertexList.get(15), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 6", vertexList.get(15), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 11", vertexList.get(15), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 14", vertexList.get(15), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 16", vertexList.get(15), vertexList.get(16), EdgeType.UNDIRECTED);
        graph.addEdge("16 - 5", vertexList.get(16), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge("16 - 6", vertexList.get(16), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge("16 - 10", vertexList.get(16), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge("16 - 12", vertexList.get(16), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge("16 - 13", vertexList.get(16), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge("14 - 0", vertexList.get(14), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge("14 - 1", vertexList.get(14), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge("13 - 5", vertexList.get(13), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge("13 - 12", vertexList.get(13), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge("11 - 7", vertexList.get(11), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge("10 - 9", vertexList.get(10), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge("9 - 8", vertexList.get(9), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge("8 - 7", vertexList.get(8), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge("7 - 6", vertexList.get(7), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge("4 - 3", vertexList.get(4), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge("4 - 2", vertexList.get(4), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge("3 - 2", vertexList.get(3), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge("2 - 0", vertexList.get(2), vertexList.get(0), EdgeType.UNDIRECTED);
        return graph;
    }

    public UndirectedSparseGraph<Integer, String> getGraph3() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        List<Integer> vertexList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            graph.addVertex(i);
            vertexList.add(i);
        }
        graph.addEdge("19 - 17", vertexList.get(19), vertexList.get(17), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 15", vertexList.get(19), vertexList.get(15), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 13", vertexList.get(19), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 11", vertexList.get(19), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 9", vertexList.get(19), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 7", vertexList.get(19), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 5", vertexList.get(19), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 3", vertexList.get(19), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge("19 - 1", vertexList.get(19), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 16", vertexList.get(18), vertexList.get(16), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 14", vertexList.get(18), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 12", vertexList.get(18), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 10", vertexList.get(18), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 8", vertexList.get(18), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 6", vertexList.get(18), vertexList.get(6), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 4", vertexList.get(18), vertexList.get(4), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 2", vertexList.get(18), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge("18 - 0", vertexList.get(18), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge("17 - 16", vertexList.get(17), vertexList.get(16), EdgeType.UNDIRECTED);
        graph.addEdge("17 - 10", vertexList.get(17), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge("17 - 2", vertexList.get(17), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge("16 - 14", vertexList.get(16), vertexList.get(14), EdgeType.UNDIRECTED);
        graph.addEdge("16 - 11", vertexList.get(16), vertexList.get(11), EdgeType.UNDIRECTED);
        graph.addEdge("15 - 12", vertexList.get(15), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge("14 - 13", vertexList.get(14), vertexList.get(13), EdgeType.UNDIRECTED);
        graph.addEdge("13 - 12", vertexList.get(13), vertexList.get(12), EdgeType.UNDIRECTED);
        graph.addEdge("12 - 9", vertexList.get(12), vertexList.get(9), EdgeType.UNDIRECTED);
        graph.addEdge("12 - 7", vertexList.get(12), vertexList.get(7), EdgeType.UNDIRECTED);
        graph.addEdge("11 - 10", vertexList.get(11), vertexList.get(10), EdgeType.UNDIRECTED);
        graph.addEdge("10 - 8", vertexList.get(10), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge("10 - 5", vertexList.get(10), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge("10 - 4", vertexList.get(10), vertexList.get(4), EdgeType.UNDIRECTED);
        graph.addEdge("9 - 8", vertexList.get(9), vertexList.get(8), EdgeType.UNDIRECTED);
        graph.addEdge("6 - 5", vertexList.get(6), vertexList.get(5), EdgeType.UNDIRECTED);
        graph.addEdge("6 - 3", vertexList.get(6), vertexList.get(3), EdgeType.UNDIRECTED);
        graph.addEdge("6 - 1", vertexList.get(6), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge("5 - 0", vertexList.get(5), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge("3 - 2", vertexList.get(3), vertexList.get(2), EdgeType.UNDIRECTED);
        graph.addEdge("3 - 1", vertexList.get(3), vertexList.get(1), EdgeType.UNDIRECTED);
        graph.addEdge("3 - 0", vertexList.get(3), vertexList.get(0), EdgeType.UNDIRECTED);
        graph.addEdge("1 - 0", vertexList.get(1), vertexList.get(0), EdgeType.UNDIRECTED);
        return graph;
    }
}
