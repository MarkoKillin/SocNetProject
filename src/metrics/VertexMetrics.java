package metrics;

import decomposition.BatageljZaversnik;
import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.scoring.ClosenessCentrality;
import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class VertexMetrics {
    /**
     * Method used for calculating and exporting metrics for every Vertex. Metrics are:
     * shell index, degree, betweenness, closeness, eigenvector
     *
     * @param graph      graph used for metrics
     * @param exportPath name of file without extension
     */
    public void calculateAndExportMetrics(UndirectedSparseGraph<Vertex, Edge> graph, String exportPath) {
        BatageljZaversnik<Vertex, Edge> batageljZaversnik = new BatageljZaversnik<>(graph);
        Map<Vertex, Integer> shellIndecies = batageljZaversnik.getShellIndecies();
        BetweennessCentrality<Vertex, Edge> betweenness = new BetweennessCentrality<>(graph);
        ClosenessCentrality<Vertex, Edge> closeness = new ClosenessCentrality<>(graph);
        EigenvectorCentrality<Vertex, Edge> eigenvector = new EigenvectorCentrality<>(graph);
        eigenvector.evaluate();
        //shell index, degree, betweenness, closeness, eigenvector
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(exportPath + ".csv")));
            for (Vertex vertex : graph.getVertices()) {
                StringBuilder sb = new StringBuilder();
                sb.append(shellIndecies.get(vertex)).append(",")
                        .append(graph.degree(vertex)).append(",")
                        .append(betweenness.getVertexScore(vertex)).append(",")
                        .append(closeness.getVertexScore(vertex)).append(",")
                        .append(eigenvector.getVertexScore(vertex)).append(",");
                pw.println(sb);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + exportPath);
        }


    }
}
