package metrics;

import decomposition.BatageljZaversnik;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphelements.Edge;
import graphelements.Vertex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class GraphMetrics {
    public void calculateAndExportMetrics(UndirectedSparseGraph<Vertex, Edge> graph, String exportPath) {
        BatageljZaversnik<Vertex, Edge> batageljZaversnik = new BatageljZaversnik<>(graph);
        Map<Vertex, Integer> shellIndecies = batageljZaversnik.getShellIndecies();
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(exportPath + ".csv")));
            for (int i = 0; i < batageljZaversnik.getMaxShellIndex(); i++) {
                UndirectedSparseGraph<Vertex, Edge> core = batageljZaversnik.getCore(i);
                int numberOfVertices = core.getVertexCount();
                int numberOfEdges = core.getEdgeCount();
                //calculate
                double graphDensity = 0;
                int numOfConnectedComponents = 0;
                double percentageOfNodesInGiantComponent = 0;
                double percentageOfEdgesInGiantComponent = 0;
                double smallWorldCoefOfGiantComponent = 0;
                int diameterOfGiantComponent = 0;
                double clusteringCoef = 0;
                double spearmanShellDegree = 0;
                double spearmanShellBetweenness = 0;
                double spearmanShellCloseness = 0;
                double spearmanShellEigenvector = 0;
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(",")
                        .append(numberOfVertices).append(",")
                        .append(numberOfEdges).append(",")
                        .append(graphDensity).append(",")
                        .append(numOfConnectedComponents).append(",")
                        .append(percentageOfNodesInGiantComponent).append(",")
                        .append(percentageOfEdgesInGiantComponent).append(",")
                        .append(smallWorldCoefOfGiantComponent).append(",")
                        .append(diameterOfGiantComponent).append(",")
                        .append(clusteringCoef).append(",")
                        .append(spearmanShellDegree).append(",")
                        .append(spearmanShellBetweenness).append(",")
                        .append(spearmanShellCloseness).append(",")
                        .append(spearmanShellEigenvector);
                pw.println(sb);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + exportPath);
        }
    }
}
