import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class Edge implements Comparable<Edge>{
		int s, e, c;

		public Edge(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.c, o.c);
		}
	}
	
	static int V, E;
	static int[] parents;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < E; i++) {
			edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		Collections.sort(edges);
        
		int sum = 0, cnt = 0;
		for (Edge edge : edges) {
			if (union(edge.s, edge.e)) {
				sum += edge.c;
				cnt++;	
			}
			if (cnt == V - 1) break;
		}
		System.out.println(sum);
		sc.close();
	}

	private static int find(int s) {
		if (parents[s] == s) return s;
		else return parents[s] = find(parents[s]);
	}

	private static boolean union(int s, int e) {
		int ps = find(s);
		int pe = find(e);
		if (ps == pe) return false;
		parents[pe] = ps;
		return true;
	}
}
