package graphelements;

public class GraphData {
    int kcore;
    int numOfVertices;
    int numOfEdges;
    double graphDensity;
    int numOfConnectedComponents;
    double percentageOfNodesInGiantComponent;
    double percentageOfEdgesInGiantComponent;
    double smallWorldCoefOfGiantComponent;
    int diameterOfGiantComponent;
    double clusteringCoef;
    double spearmanShellDegree;
    double spearmanShellBetweenness;
    double spearmanShellCloseness;
    double spearmanShellEigenvector;

    public GraphData(int kcore, int numOfVertices, int numOfEdges,
                     double graphDensity, int numOfConnectedComponents, double percentageOfNodesInGiantComponent,
                     double percentageOfEdgesInGiantComponent, double smallWorldCoefOfGiantComponent,
                     int diameterOfGiantComponent, double clusteringCoef, double spearmanShellDegree, double spearmanShellBetweenness,
                     double spearmanShellCloseness, double spearmanShellEigenvector) {
        this.kcore = kcore;
        this.numOfVertices = numOfVertices;
        this.numOfEdges = numOfEdges;
        this.graphDensity = graphDensity;
        this.numOfConnectedComponents = numOfConnectedComponents;
        this.percentageOfNodesInGiantComponent = percentageOfNodesInGiantComponent;
        this.percentageOfEdgesInGiantComponent = percentageOfEdgesInGiantComponent;
        this.smallWorldCoefOfGiantComponent = smallWorldCoefOfGiantComponent;
        this.diameterOfGiantComponent = diameterOfGiantComponent;
        this.clusteringCoef = clusteringCoef;
        this.spearmanShellDegree = spearmanShellDegree;
        this.spearmanShellBetweenness = spearmanShellBetweenness;
        this.spearmanShellCloseness = spearmanShellCloseness;
        this.spearmanShellEigenvector = spearmanShellEigenvector;
    }
}
