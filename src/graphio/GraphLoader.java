package graphio;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphLoader {

    public UndirectedSparseGraph<Integer, String> loadAstroPh() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/CA-AstroPh.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                String[] vertices = line.split("\t");
                Integer from = Integer.parseInt(vertices[0]);
                Integer to = Integer.parseInt(vertices[1]);
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(from + " - " + to, from, to, EdgeType.UNDIRECTED);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }

    public UndirectedSparseGraph<Integer, String> loadDBLP() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/cit-DBLP.edges"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("%"))
                    continue;
                String[] vertices = line.split(" ");
                Integer from = Integer.parseInt(vertices[0]);
                Integer to = Integer.parseInt(vertices[1]);
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(from + " - " + to, from, to, EdgeType.UNDIRECTED);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }

    public UndirectedSparseGraph<Integer, String> loadHighEnergyPhysicsColaboration() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/CA-HepTh.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#"))
                    continue;
                String[] vertices = line.split("\t");
                Integer from = Integer.parseInt(vertices[0]);
                Integer to = Integer.parseInt(vertices[1]);
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(from + " - " + to, from, to, EdgeType.UNDIRECTED);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }

    public UndirectedSparseGraph<Integer, String> loadLastFMAsia() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/lastfm_asia_edges.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("node"))
                    continue;
                String[] vertices = line.split(",");
                Integer from = Integer.parseInt(vertices[0]);
                Integer to = Integer.parseInt(vertices[1]);
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(from + " - " + to, from, to, EdgeType.UNDIRECTED);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }
}
