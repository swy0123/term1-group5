package week9;

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
 * boj_1504 특정한 최단 경로
 * 
 * @author elder
 *
 */
public class boj_1504 {
	static int N, E;
	static List<Vertex>[] adjList;

	static class Vertex implements Comparable<Vertex> {
		int end;
		long weight;

		public Vertex(int end, Long weight) {
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
			return Long.compare(this.weight, o.weight);
		}
	}

	static int savepoint1;
	static int savepoint2;
	static final long INF = Long.MAX_VALUE;
	static long ans = 0;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			adjList[a].add(new Vertex(b, weight));
			adjList[b].add(new Vertex(a, weight));
		}

//		for (int i = 1; i < adjList.length; i++) {
//			System.out.println(Arrays.toString(adjList[i].toArray()));
//		}

		st = new StringTokenizer(br.readLine());
		savepoint1 = Integer.parseInt(st.nextToken());
		savepoint2 = Integer.parseInt(st.nextToken());

		// s -> savepoint1
		long a = dijkstra(1, savepoint1);
		long b = dijkstra(1, savepoint2);
		long a_b = dijkstra(savepoint1, savepoint2);
		long s_n = dijkstra(1, N);
		
		if (a == INF || b == INF || a_b == INF || s_n == INF) {
			flag = true;
		}
		
		// 1 -> a -> b -> N
		long case_1 = a + a_b + (dijkstra(savepoint2, N));

		// 1-> b -> a -> N
		long case_2 = b + a_b + (dijkstra(savepoint1, N));
		
		ans = Math.min(case_1, case_2);
		// s-> savepoint2
		if(flag) {
			System.out.println(-1);
		}else {
			System.out.println(ans);			
		}

	}

	private static long dijkstra(int start, int end) {
		long[] dist = new long[N + 1];
		boolean[] visit = new boolean[N + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.offer(new Vertex(start, 0l));

		while (!q.isEmpty()) {
			Vertex v = q.poll();

			if (visit[v.end]) {
				continue;
			}

			visit[v.end] = true;
			for (Vertex next : adjList[v.end]) {
				if (!visit[next.end] && dist[next.end] > dist[v.end] + next.weight) {
					dist[next.end] = dist[v.end] + next.weight;
					q.offer(new Vertex(next.end, dist[next.end]));
				}
			}
		}

		return dist[end];
	}

}
