package graphelements;

public class Edge {
    private static int count = 0;
    public int idEdge;

    public Edge(int idEdge) {
        this.idEdge = idEdge;
    }

    public Edge() {
        this(count++);
    }

    @Override
    public String toString() {
        return "Edge [" + idEdge + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge e) {
            return this.idEdge == e.idEdge;
        }
        return false;
    }
}
