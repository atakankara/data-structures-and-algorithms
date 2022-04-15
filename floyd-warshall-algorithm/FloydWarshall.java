import java.util.ArrayList;

public class FloydWarshall {
    private final static int INF = 999999;
    private int V;
    private ArrayList<String>  vertices;
    private ArrayList<Edge> edges;
    private int[][] distanceMatrix ;

    public FloydWarshall(Graph graph){
        this.vertices = graph.vertices;
        this.edges = graph.edges;
        this.V = graph.vertices.size();
        initializeMatrix();
    }

    private void initializeMatrix() {
        distanceMatrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    distanceMatrix[i][j] = 0;
                } else {
                    distanceMatrix[i][j] = INF;
                }

            }
        }
        for (Edge e : edges) {
            int src = vertices.indexOf(e.src);
            int dst = vertices.indexOf(e.dst);
            distanceMatrix[src][dst] = e.latency;
            distanceMatrix[dst][src] = e.latency;
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (distanceMatrix[i][j] > distanceMatrix[i][k] + distanceMatrix[k][j]) {
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                    }
                }
            }
        }
    }

    public int getTotalTime(){
        int total =0;
        for (int i=0; i < V; i++){
            for (int j=0; j < V; j++){
                total += distanceMatrix[i][j];
            }
        }
        return total;
    }
}
