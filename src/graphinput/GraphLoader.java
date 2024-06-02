package graphinput;

import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphLoader {

    public UndirectedSparseGraph<Vertex, Edge> loadErdos992Network() {
        UndirectedSparseGraph<Vertex, Edge> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/ca-Erdos992.mtx"));
            String line;
            while ((line = br.readLine()) != null) {
                if(line.startsWith("%"))
                    continue;
                String[] vertices = line.split(" ");
                Vertex from = new Vertex(Integer.parseInt(vertices[0]));
                Vertex to = new Vertex(Integer.parseInt(vertices[1]));
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(new Edge(), from, to);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }

    public UndirectedSparseGraph<Vertex, Edge> loadGeneralRelativityColaboration() {
        UndirectedSparseGraph<Vertex, Edge> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/CA-GrQc.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if(line.startsWith("#"))
                    continue;
                String[] vertices = line.split("\t");
                Vertex from = new Vertex(Integer.parseInt(vertices[0]));
                Vertex to = new Vertex(Integer.parseInt(vertices[1]));
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(new Edge(), from, to);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }

    public UndirectedSparseGraph<Vertex, Edge> loadHighEnergyPhysicsColaboration() {
        UndirectedSparseGraph<Vertex, Edge> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/CA-HepTh.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if (line.startsWith("#"))
                    continue;
                String[] vertices = line.split("\t");
                Vertex from = new Vertex(Integer.parseInt(vertices[0]));
                Vertex to = new Vertex(Integer.parseInt(vertices[1]));
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(new Edge(), from, to);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }

    public UndirectedSparseGraph<Vertex,Edge> loadLastFMAsia(){
        UndirectedSparseGraph<Vertex,Edge> graph = new UndirectedSparseGraph<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("./data/lastfm_asia_edges.csv"));
            String line;
            while ((line = br.readLine()) != null){
                if(line.startsWith("node"))
                    continue;
                String[] vertices = line.split(",");
                Vertex from = new Vertex(Integer.parseInt(vertices[0]));
                Vertex to = new Vertex(Integer.parseInt(vertices[1]));
                graph.addVertex(from);
                graph.addVertex(to);
                graph.addEdge(new Edge(), from, to);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return graph;
    }
}
