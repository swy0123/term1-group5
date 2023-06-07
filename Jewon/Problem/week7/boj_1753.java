package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * boj_1753 최단경로 골드4
 * 
 * @author SSAFY
 *
 */
public class boj_1753 {
	static int V, E;
	static int start;

	static class Vertex implements Comparable<Vertex> {
		int end, weight;

		public Vertex(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Vertex [end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	static List<Vertex>[] adjList;
	static boolean[] visited;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		visited = new boolean[V + 1];
		adjList = new List[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Vertex>();
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[a].add(new Vertex(b, weight));
		}

		// 다익스트라
		dist[start] = 0;
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		q.offer(new Vertex(start, 0));

		while (!q.isEmpty()) {
			Vertex v = q.poll();

			if (visited[v.end]) {
				continue;
			}

			visited[v.end] = true;
			for (Vertex next : adjList[v.end]) {
				if (!visited[next.end] && dist[next.end] > dist[v.end] + next.weight) {
					q.offer(new Vertex(next.end , dist[v.end] + next.weight));
					dist[next.end] = dist[v.end] + next.weight;
				}
			}
		}

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}

}
