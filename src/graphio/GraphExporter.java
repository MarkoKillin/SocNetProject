package graphio;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GraphExporter {
    public void exportGraphAsCSV(UndirectedSparseGraph<Integer, String> graph, String fileName) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./exportedGraphs/" + fileName + ".csv")))) {
            for (String edge : graph.getEdges()) {
                String[] vertices = edge.split(" - ");
                pw.println(vertices[0] + "," + vertices[1]);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName + ".csv");
        }
    }
}
