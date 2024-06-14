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
    public void exportDecompositionAsCSV(UndirectedSparseGraph<Integer, String> graph, String fileName) {
        BatageljZaversnik<Integer, String> bz = new BatageljZaversnik<>(graph);
        Straightforward<Integer, String> sf = new Straightforward<>(graph);
        Map<Integer, Integer> shellIndeciesBZ = bz.getShellIndecies();
        Map<Integer, Integer> shellIndeciesSF = sf.getShellIndecies();
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./exportedComparison/" + fileName + ".csv")))) {
            for (Integer vertex : graph.getVertices()) {
                pw.println(vertex + "," + shellIndeciesBZ.get(vertex) + "," + shellIndeciesSF.get(vertex));
            }
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName + ".csv");
        }
    }

}
