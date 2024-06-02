package graphelements;

public class VertexData {
    int shellIndex;
    int degree;
    double betweenness;
    double closeness;
    double eigenvector;

    public VertexData(int shellIndex, int degree, double betweenness, double closeness, double eigenvector) {
        this.shellIndex = shellIndex;
        this.degree = degree;
        this.betweenness = betweenness;
        this.closeness = closeness;
        this.eigenvector = eigenvector;
    }
}
