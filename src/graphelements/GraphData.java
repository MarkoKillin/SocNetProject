package graphelements;

public class GraphData {
    int shellIndex;
    int numOfVertices;
    int numOfEdges;
    double graphDensity;
    int numOfConnectedComponents;
    double percentageOfNodesInGiantComponent;
    double percentageOfEdgesInGiantComponent;
    double smallWorldCoefOfGiantComponent;
    int diameterOfGiantComponent;
    double clusteringCoef;

    public GraphData(int shellIndex, int numOfVertices, int numOfEdges,
                     double graphDensity, int numOfConnectedComponents, double percentageOfNodesInGiantComponent,
                     double percentageOfEdgesInGiantComponent, double smallWorldCoefOfGiantComponent,
                     int diameterOfGiantComponent, double clusteringCoef) {
        this.shellIndex = shellIndex;
        this.numOfVertices = numOfVertices;
        this.numOfEdges = numOfEdges;
        this.graphDensity = graphDensity;
        this.numOfConnectedComponents = numOfConnectedComponents;
        this.percentageOfNodesInGiantComponent = percentageOfNodesInGiantComponent;
        this.percentageOfEdgesInGiantComponent = percentageOfEdgesInGiantComponent;
        this.smallWorldCoefOfGiantComponent = smallWorldCoefOfGiantComponent;
        this.diameterOfGiantComponent = diameterOfGiantComponent;
        this.clusteringCoef = clusteringCoef;
    }
}
