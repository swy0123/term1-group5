package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * boj_13905 세부 골드 4
 * 
 * @author elder
 *
 */

// prim
public class boj_13905 {

	static int S;
	static int E;
	static int N;
	static int M;

	static class Vertex implements Comparable<Vertex> {
		int end;
		int weight;

		public Vertex(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.weight, this.weight);
		}

		@Override
		public String toString() {
			return "Vertex [end=" + end + ", weight=" + weight + "]";
		}

	}

	static List<Vertex>[] adjList;
	static boolean[] visit;
	static int max_weight = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// 숭이 -> 혜빈이 금 빼뺴로
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("boj_13905.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1];
		adjList = new ArrayList[N + 1];

		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[h1].add(new Vertex(h2, weight));
			adjList[h2].add(new Vertex(h1, weight));
		}
		
		for (int i = 1; i < adjList.length; i++) {
			System.out.println(Arrays.toString(adjList[i].toArray()));
		}
		
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.offer(new Vertex(S, Integer.MAX_VALUE));
		
		while (!q.isEmpty()) {
			Vertex v = q.poll();
			
			max_weight = Math.min(max_weight, v.weight);

			if (v.end == E) { // 도착

				if (max_weight == Integer.MAX_VALUE) {
					max_weight = 0;
				}

				System.out.println(max_weight);
				System.exit(0);
			}

			// 방문 했더라면
			if (visit[v.end]) {
				continue;
			}

			// 방문후 주변을 큐에 담아버림
			visit[v.end] = true;
			for (Vertex next : adjList[v.end]) {
				if (!visit[next.end]) {
					q.offer(next);
				}
			}
			
			System.out.println(v.end + " , "+ v.weight + " : " + Arrays.toString(q.toArray()));
		}
	}

}
