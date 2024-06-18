package metrics;

import decomposition.BatageljZaversnik;
import decomposition.Straightforward;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class DecompositionMetrics {
    /**
     * Method for testing Batagelj-Zaversnik against Straightforward algorithm, it prints if vertex has different shell indicies
     * @param graph for decomposition
     * @param fileName save name
     */
    public void exportDecompositionAsCSV(UndirectedSparseGraph<Integer, String> graph, String fileName) {
        BatageljZaversnik<Integer, String> bz = new BatageljZaversnik<>(graph);
        Straightforward<Integer, String> sf = new Straightforward<>(graph);
        Map<Integer, Integer> shellIndeciesBZ = bz.getShellIndecies();
        Map<Integer, Integer> shellIndeciesSF = sf.getShellIndecies();
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./exportedComparison/" + fileName + ".csv")))) {
            for (Integer vertex : graph.getVertices()) {
                if (shellIndeciesBZ.get(vertex).intValue() != shellIndeciesSF.get(vertex).intValue()) {
                    System.out.println("Vertex " + vertex + " has different shell indicies.");
                }
                pw.println(vertex + "," + shellIndeciesBZ.get(vertex) + "," + shellIndeciesSF.get(vertex));
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName + ".csv");
        }
    }

}
