import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST extends Graph{
    public MST(Graph graph){
        super();
        this.vertices = graph.vertices;
        initilizeMST(graph);
    }
    private void initilizeMST(Graph graph){
        ArrayDeque<Edge> minSpanTree = new ArrayDeque <Edge>();

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        for (Edge e : graph.edges){
            priorityQueue.add(e);
        }

        UnionFind unionFind = new UnionFind(this);

        while (!priorityQueue.isEmpty() && minSpanTree.size() < vertices.size() -1 ){
            Edge edge = priorityQueue.poll();
            String u = edge.dst;
            String w = edge.src;
            if(!unionFind.isConnected(u, w)){
                unionFind.union(u, w);
                minSpanTree.addLast(edge);
                addEdge(edge);
            }
        }
    }


}
