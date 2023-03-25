package week7;

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
 * boj_17396 백도어 골드 5
 * 
 * @author elder
 *
 */
public class boj_17396 {

	static int N, M;

	static class Vertex implements Comparable<Vertex> {
		int end;
		long weigth;

		public Vertex(int end, long weigth) {
			super();
			this.end = end;
			this.weigth = weigth;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weigth, o.weigth);
		}

	}

	static List<Vertex>[] adjList;
	static boolean[] is_available;
	static boolean[] visited;
	static long[] dist;
	static final long INF = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		is_available = new boolean[N];
		visited = new boolean[N];
		adjList = new List[N];
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new long[N];
		Arrays.fill(dist, INF);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0) { // 0 이면 볼수 있다.
				is_available[i] = true;
			} else {
				is_available[i] = false;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());

			adjList[a].add(new Vertex(b, weight));
			adjList[b].add(new Vertex(a, weight));
		}

		// dijkstra
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.offer(new Vertex(0, 0));
		dist[0] = 0;

		while (!q.isEmpty()) {
			Vertex v = q.poll();

			if (visited[v.end]) {
				continue;
			}

			visited[v.end] = true;

			for (Vertex next : adjList[v.end]) {
				if (!visited[next.end] && is_available[next.end] && dist[next.end] > dist[v.end] + next.weigth) {
					dist[next.end] = dist[v.end] + next.weigth;
					q.offer(new Vertex(next.end, dist[next.end]));
				}

				if (next.end == N - 1) {
					dist[next.end] = Math.min(dist[next.end], dist[v.end] + next.weigth);
				}
			}
//			System.out.println(Arrays.toString(dist));
		}

		System.out.println(dist[N - 1] == INF ? -1 : dist[N - 1]);
	}

}
