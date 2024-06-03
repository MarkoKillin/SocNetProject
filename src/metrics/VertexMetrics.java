package metrics;

import decomposition.BatageljZaversnik;
import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.scoring.ClosenessCentrality;
import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

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
    public void calculateAndExportMetrics(UndirectedSparseGraph<Integer, String> graph, String exportPath) {
        BatageljZaversnik<Integer, String> batageljZaversnik = new BatageljZaversnik<>(graph);
        Map<Integer, Integer> shellIndecies = batageljZaversnik.getShellIndecies();

        BetweennessCentrality<Integer, String> betweenness = new BetweennessCentrality<>(graph);
        ClosenessCentrality<Integer, String> closeness = new ClosenessCentrality<>(graph);
        EigenvectorCentrality<Integer, String> eigenvector = new EigenvectorCentrality<>(graph);
        eigenvector.evaluate();

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(exportPath + ".csv")));
            for (Integer vertex : graph.getVertices()) {
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
