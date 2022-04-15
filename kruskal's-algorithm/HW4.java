import java.util.*;

public class HW4 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Graph graph = new Graph();
				
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] parts = line.split(" ");
			if (parts[0].equals("end")) break;
			String src = parts[0];
			String dst = parts[1];
			int cost = Integer.parseInt(parts[2]);
			int latency = Integer.parseInt(parts[3]);
			
			graph.addVertex(src);
			graph.addVertex(dst);
			Edge edge = new Edge(src, dst, cost, latency);
			graph.addEdge(edge);
		}
		
		//System.out.println(Arrays.deepToString(graph.asArray(false)));
		//System.out.println(Arrays.deepToString(graph.asArray(true)));
		
		HW4 hw4 = new HW4();
		scan.close();
		
		System.out.println(hw4.totalLinkCost(graph));
		System.out.println(hw4.cheapestNetwork(graph));
		System.out.println(hw4.savedAmount(graph));
	
	}
	
	// You can add any methods you need, both to this file and Graph.java file

	// The method for task 1 
	int totalLinkCost(Graph graph) {
		int[][] matrix = graph.asArray(false);
		int sum = 0;
		for (int i = 1; i < matrix.length; i++){
			for (int j = 0; j < i; j++){
				sum += matrix[i][j];
			}
		}
		return sum;
	}

	// The method for task 2 
	int cheapestNetwork(Graph graph) {
		ArrayDeque<Edge> minSpanTree = new ArrayDeque <Edge>();

		PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
		for (Edge e : graph.edges){
			priorityQueue.add(e);
		}

		UnionFind unionFind = new UnionFind(graph);

		while (!priorityQueue.isEmpty() && minSpanTree.size() < graph.vertices.size() -1 ){
			Edge edge = priorityQueue.poll();
			String u = edge.dst;
			String w = edge.src;
			if(!unionFind.isConnected(u, w)){
				unionFind.union(u, w);
				minSpanTree.addLast(edge);
			}
		}
		int totalCost = 0;
		for (Edge e : minSpanTree){
			totalCost += e.cost;
		}

		return totalCost;
	}

	// The method for task 3 
	int savedAmount(Graph graph) {
		int totalCost = totalLinkCost(graph);
		int minCost = cheapestNetwork(graph);
		return totalCost - minCost;
	}
}
