package graphelements;

public class Edge {

    public String dataEdge;

    public Edge(String dataEdge) {
        this.dataEdge = dataEdge;
    }

    public Edge() {
        this("");
    }

    @Override
    public String toString() {
        return "Edge [" + dataEdge + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge e) {
            return this.dataEdge.equals(e.dataEdge);
        }
        return false;
    }
}
