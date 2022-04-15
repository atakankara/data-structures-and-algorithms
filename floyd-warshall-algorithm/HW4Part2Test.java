import java.util.Scanner;

public class HW4Part2Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test_cases = 3;
		
		for (int i = 0; i < test_cases; i++) {
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
			
		System.out.println(hw4.totalTransitTime(graph));
		System.out.println(hw4.cheapestTransitTime(graph));
		System.out.println(hw4.timeIncrease(graph));
		}
		scan.close();
	}
}
