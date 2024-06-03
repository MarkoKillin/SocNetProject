package metrics;

import decomposition.BatageljZaversnik;
import edu.uci.ics.jung.algorithms.cluster.WeakComponentClusterer;
import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.scoring.ClosenessCentrality;
import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import graphelements.Edge;
import graphelements.Vertex;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphMetrics {
    public void calculateMetrics(UndirectedSparseGraph<Vertex, Edge> graph, String exportPath) {
        UndirectedSparseGraph<Vertex, Edge> giantComponent = new UndirectedSparseGraph<>();
        for (Vertex v : graph.getVertices())
            giantComponent.addVertex(v);
        for (Edge e : graph.getEdges())
            giantComponent.addEdge(e, graph.getIncidentVertices(e), EdgeType.UNDIRECTED);
        //called giantComponent, but it will become it
        BatageljZaversnik<Vertex, Edge> batageljZaversnik = new BatageljZaversnik<>(giantComponent);
        Map<Vertex, Integer> shellIndecies = batageljZaversnik.getShellIndecies();
        WeakComponentClusterer<Vertex, Edge> wcc = new WeakComponentClusterer<>();
        Set<Set<Vertex>> components = wcc.transform(giantComponent);
        Set<Set<Vertex>> toRemove = components.parallelStream().sorted((x, y) -> y.size() - x.size()).skip(1).collect(Collectors.toSet());
        for (Set<Vertex> vertices : toRemove) {
            for (Vertex vertex : vertices) {
                giantComponent.removeVertex(vertex);
            }
        }
        //giantComponent is now a giantComponent
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(exportPath + ".csv")))) {
            for (int i = 0; i < batageljZaversnik.getMaxShellIndex(); i++) {
                UndirectedSparseGraph<Vertex, Edge> core = batageljZaversnik.getCore(i);
                int numberOfVertices = core.getVertexCount();
                int numberOfEdges = core.getEdgeCount();
                double graphDensity = ((double) numberOfEdges * 2) / ((double) numberOfVertices * (numberOfVertices - 1));
                int numOfConnectedComponents = components.size();
                double percentageOfVerticesInGiantComponent = (double) giantComponent.getVertexCount() / (double) graph.getVertexCount() * 100;
                double percentageOfEdgesInGiantComponent = (double) giantComponent.getEdgeCount() / (double) graph.getEdgeCount() * 100;
                //calculate
                double smallWorldCoefOfGiantComponent = smallworld(giantComponent);
                int diameterOfGiantComponent = diameter(giantComponent);
                double clusteringCoef = clusteingCoef(giantComponent);
                double[] spearman = calculateSpearmanCorelations(giantComponent, batageljZaversnik.getShellIndecies());
                double spearmanShellDegree = spearman[0];
                double spearmanShellBetweenness = spearman[1];
                double spearmanShellCloseness = spearman[2];
                double spearmanShellEigenvector = spearman[3];
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(",")
                        .append(numberOfVertices).append(",")
                        .append(numberOfEdges).append(",")
                        .append(graphDensity).append(",")
                        .append(numOfConnectedComponents).append(",")
                        .append(percentageOfVerticesInGiantComponent).append(",")
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


    private double[] calculateSpearmanCorelations(UndirectedSparseGraph<Vertex, Edge> giantComponent, Map<Vertex, Integer> shellIndecies) {
        double[] res = new double[4];
        BetweennessCentrality<Vertex, Edge> betweennessCentrality = new BetweennessCentrality<>(giantComponent);
        ClosenessCentrality<Vertex, Edge> closenessCentrality = new ClosenessCentrality<>(giantComponent);
        EigenvectorCentrality<Vertex, Edge> eigenvectorCentrality = new EigenvectorCentrality<>(giantComponent);
        eigenvectorCentrality.evaluate();
        double[] shel = new double[giantComponent.getVertexCount()];
        double[] degs = new double[giantComponent.getVertexCount()];
        double[] betw = new double[giantComponent.getVertexCount()];
        double[] clos = new double[giantComponent.getVertexCount()];
        double[] eige = new double[giantComponent.getVertexCount()];
        Object[] array = giantComponent.getVertices().toArray();
        for (int i = 0; i < array.length; i++) {
            Vertex v = (Vertex) array[i];
            shel[i] = shellIndecies.get(v);
            degs[i] = giantComponent.degree(v);
            betw[i] = betweennessCentrality.getVertexScore(v);
            clos[i] = closenessCentrality.getVertexScore(v);
            eige[i] = eigenvectorCentrality.getVertexScore(v);
        }
        SpearmansCorrelation sc = new SpearmansCorrelation();
        res[0] = sc.correlation(shel, degs);
        res[1] = sc.correlation(shel, betw);
        res[2] = sc.correlation(shel, clos);
        res[3] = sc.correlation(shel, eige);
        return res;
    }

    private double clusteingCoef(UndirectedSparseGraph<Vertex, Edge> giantComponent) {
        return 0;
    }

    private int diameter(UndirectedSparseGraph<Vertex, Edge> giantComponent) {
        return 0;
    }

    private double smallworld(UndirectedSparseGraph<Vertex, Edge> giantComponent) {
        return 0.0;
    }
}

