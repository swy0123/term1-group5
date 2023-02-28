import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	static class Node implements Comparable<Node>{
		int e;
		long c;

		public Node(int e, long c) {
			super();
			this.e = e;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.c, o.c);
		}
	}
	
	static int V, E;
	static long[] dist;
	static boolean[] v;
	static List<Node>[] edges;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			V = sc.nextInt();
			E = sc.nextInt();
			edges = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				edges[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				edges[a].add(new Node(b, c));
				edges[b].add(new Node(a, c));
			}
			
			dist = new long[V + 1];
			v = new boolean[V + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(1, 0));
			dist[1] = 0;
			long sum = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (v[cur.e]) continue;
				v[cur.e] = true;
				sum += cur.c;
				for (Node next : edges[cur.e]) {
					if (!v[next.e] && next.c < dist[next.e]) {
						dist[next.e] = next.c;
						pq.offer(next);
					}
				}
			}
			
			System.out.println("#" + testCase + " " + sum);
		}
	}
}
