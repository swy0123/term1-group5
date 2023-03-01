package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * boj_1674 도시 분할 계획 골드 4
 * 
 * @author elder
 *
 */
public class boj_1674 {

	static int N;
	static int M;

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
			return Integer.compare(this.weight, o.weight);
		}

	}

	static List<Vertex>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[a].add(new Vertex(b, weight));
			list[b].add(new Vertex(a, weight));
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.offer(new Vertex(1, 0));

		while (!q.isEmpty()) {
			Vertex v = q.poll();

			if (visit[v.end]) {
				continue;
			}

			sum += v.weight;
			max = Math.max(max, v.weight);
			visit[v.end] = true;
			for (Vertex next : list[v.end]) {
				if (!visit[next.end]) {
					q.offer(next);
				}
			}
		}

		System.out.println(sum - max);
	}

}
