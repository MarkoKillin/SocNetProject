package metrics;

import decomposition.BatageljZaversnik;
import edu.uci.ics.jung.algorithms.cluster.WeakComponentClusterer;
import edu.uci.ics.jung.algorithms.metrics.Metrics;
import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.algorithms.scoring.ClosenessCentrality;
import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.algorithms.shortestpath.DistanceStatistics;
import edu.uci.ics.jung.algorithms.shortestpath.UnweightedShortestPath;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import org.apache.commons.math3.stat.correlation.SpearmansCorrelation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class GraphMetrics {
    public void calculateMetrics(UndirectedSparseGraph<Integer, String> graph, String exportPath) {
        UndirectedSparseGraph<Integer, String> giantComponent = new UndirectedSparseGraph<>();
        for (Integer v : graph.getVertices())
            giantComponent.addVertex(v);
        for (String edge : graph.getEdges())
            giantComponent.addEdge(edge, graph.getIncidentVertices(edge), EdgeType.UNDIRECTED);

        BetweennessCentrality<Integer, String> betweennessCentrality = new BetweennessCentrality<>(giantComponent);
        System.out.println("betweenness done ---- ");
        ClosenessCentralityCustom closenessCentrality = new ClosenessCentralityCustom(giantComponent);
        System.out.println("closeness done ---- ");
        EigenvectorCentrality<Integer, String> eigenvectorCentrality = new EigenvectorCentrality<>(giantComponent);
        eigenvectorCentrality.acceptDisconnectedGraph(true);
        eigenvectorCentrality.evaluate();
        System.out.println("eigenvector done ---- ");

        //called giantComponent, but it will become it
        BatageljZaversnik<Integer, String> batageljZaversnik = new BatageljZaversnik<>(giantComponent);
        Map<Integer, Integer> shellIndecies = batageljZaversnik.getShellIndecies();

        exportDegreeDistribution(giantComponent, exportPath);
        exportVertexMetrics(giantComponent, betweennessCentrality, closenessCentrality, eigenvectorCentrality, shellIndecies, exportPath);

        //calculating spearman corelations
        double[] spearman = calculateSpearmanCorelations(giantComponent, batageljZaversnik.getShellIndecies(), betweennessCentrality,
                closenessCentrality, eigenvectorCentrality);
        double spearmanShellDegree = spearman[0];
        double spearmanShellBetweenness = spearman[1];
        double spearmanShellCloseness = spearman[2];
        double spearmanShellEigenvector = spearman[3];


        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./exportedMetrics/" + exportPath + ".csv")))) {
            //these correlation metrics don't require calculating for each core
            pw.println(spearmanShellDegree + "," + spearmanShellBetweenness + "," + spearmanShellCloseness + "," + spearmanShellEigenvector);
            for (int i = 0; i < batageljZaversnik.getMaxShellIndex(); i++) {
                UndirectedSparseGraph<Integer, String> core = batageljZaversnik.getCore(i);
                WeakComponentClusterer<Integer, String> wcc = new WeakComponentClusterer<>();
                Set<Set<Integer>> components = wcc.transform(core);
                Set<Set<Integer>> toRemove = components.parallelStream().sorted((x, y) -> y.size() - x.size()).skip(1).collect(Collectors.toSet());
                for (Set<Integer> vertices : toRemove) {
                    for (Integer vertex : vertices) {
                        giantComponent.removeVertex(vertex);
                    }
                }
                //giantComponent is now a giantComponent
                int numberOfVertices = core.getVertexCount();
                int numberOfEdges = core.getEdgeCount();
                double graphDensity = ((double) numberOfEdges * 2) / ((double) numberOfVertices * (numberOfVertices - 1));
                int numOfConnectedComponents = components.size();
                double percentageOfVerticesInGiantComponent = (double) giantComponent.getVertexCount() / (double) graph.getVertexCount() * 100;
                double percentageOfEdgesInGiantComponent = (double) giantComponent.getEdgeCount() / (double) graph.getEdgeCount() * 100;
                //calculate
                double smallWorldCoefOfGiantComponent = smallworld(giantComponent);
                double diameterOfGiantComponent = DistanceStatistics.diameter(core);
                double clusteringCoef = clusteingCoef(giantComponent);
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
                        .append(clusteringCoef).append(",");
                pw.println(sb);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + exportPath + ".csv");
        }
    }

    private void exportDegreeDistribution(UndirectedSparseGraph<Integer, String> giantComponent, String exportPath) {
        Map<Integer, Integer> degreeDistribution = new HashMap<>();
        for (Integer vertex : giantComponent.getVertices()) {
            int degree = giantComponent.degree(vertex);
            if (degreeDistribution.containsKey(degree))
                degreeDistribution.put(degree, degreeDistribution.get(degree) + 1);
            else
                degreeDistribution.put(degree, 1);
        }
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./exportedMetrics/" + exportPath + "_degree_distribution.csv")))) {
            for (Map.Entry<Integer, Integer> entry : degreeDistribution.entrySet()) {
                pw.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + exportPath + "_vertices.csv");
        }
    }

    private void exportVertexMetrics(UndirectedSparseGraph<Integer, String> giantComponent, BetweennessCentrality<Integer, String> betweennessCentrality,
                                     ClosenessCentralityCustom closenessCentrality, EigenvectorCentrality<Integer, String> eigenvectorCentrality,
                                     Map<Integer, Integer> shellIndecies, String exportPath) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./exportedMetrics/" + exportPath + "_vertices.csv")))) {
            for (Integer vertex : giantComponent.getVertices()) {
                pw.println(shellIndecies.get(vertex) + "," + giantComponent.degree(vertex) + "," + betweennessCentrality.getVertexScore(vertex) +
                        "," + closenessCentrality.getClosenessMap().get(vertex) + "," + eigenvectorCentrality.getVertexScore(vertex));
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + exportPath + "_vertices.csv");
        }
    }


    private double[] calculateSpearmanCorelations(UndirectedSparseGraph<Integer, String> giantComponent, Map<Integer, Integer> shellIndecies,
                                                  BetweennessCentrality<Integer, String> betweennessCentrality,
                                                  ClosenessCentralityCustom closenessCentrality,
                                                  EigenvectorCentrality<Integer, String> eigenvectorCentrality) {
        double[] res = new double[4];

        int size = giantComponent.getVertexCount();
        double[] shel = new double[size];
        double[] degs = new double[size];
        double[] betw = new double[size];
        double[] clos = new double[size];
        double[] eige = new double[size];
        Object[] array = giantComponent.getVertices().toArray();
        for (int i = 0; i < array.length; i++) {
            Integer v = (Integer) array[i];
            shel[i] = shellIndecies.get(v);
            degs[i] = giantComponent.degree(v);
            betw[i] = betweennessCentrality.getVertexScore(v);
            clos[i] = closenessCentrality.getClosenessMap().get(v);
            eige[i] = eigenvectorCentrality.getVertexScore(v);
        }
        SpearmansCorrelation sc = new SpearmansCorrelation();
        res[0] = sc.correlation(shel, degs);
        res[1] = sc.correlation(shel, betw);
        res[2] = sc.correlation(shel, clos);
        res[3] = sc.correlation(shel, eige);
        return res;
    }

    private double clusteingCoef(UndirectedSparseGraph<Integer, String> graph) {
        Map<Integer, Double> clusteringCoefficients = Metrics.clusteringCoefficients(graph);
        double sum = clusteringCoefficients.values().parallelStream().reduce(0.0, Double::sum);
        return sum / (double) graph.getVertexCount();
    }

    private double smallworld(UndirectedSparseGraph<Integer, String> graph) {
        double sum = 0.0;
        for (Integer vertex : graph.getVertices()) {
            sum += calculateDistance(graph, vertex);
        }
        return sum / ((double) graph.getVertexCount() * (graph.getVertexCount() - 1));
    }

    private double calculateDistance(UndirectedSparseGraph<Integer, String> graph, Integer vertex) {
        double distance = 0.0;
        UnweightedShortestPath<Integer, String> uwsp = new UnweightedShortestPath<>(graph);
        Map<Integer, Number> distanceMap = uwsp.getDistanceMap(vertex);
        for (Map.Entry<Integer, Number> entry : distanceMap.entrySet()) {
            distance += entry.getValue().doubleValue();
        }
        return distance;
    }

}

