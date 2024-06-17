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

    public UndirectedSparseGraph<Integer, String> loadFacebookPages() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/fb-pages-public-figure.edges"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("%"))
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

    public UndirectedSparseGraph<Integer, String> loadHepPh() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/CA-HepPh.txt"));
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

    public UndirectedSparseGraph<Integer, String> loadEpinions() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/soc-epinions.mtx"));
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

    public UndirectedSparseGraph<Integer, String> loadGemsec() {
        UndirectedSparseGraph<Integer, String> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/soc-gemsec-RO.edges"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("%"))
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
