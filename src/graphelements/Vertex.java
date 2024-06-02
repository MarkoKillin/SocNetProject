package graphelements;

public class Vertex {

    public int idVertex;

    public Vertex(int idVertex) {
        this.idVertex = idVertex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex v) {
            return this.idVertex == v.idVertex;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vertex [" + idVertex + "]";
    }
}
