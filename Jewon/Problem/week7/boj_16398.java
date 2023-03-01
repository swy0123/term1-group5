package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * boj_16398 행성 연결 골드 4
 * 
 * @author elder
 *
 */
public class boj_16398 {

	static int N;

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
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("boj_16398.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N];
		visit = new boolean[N];

		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int weight = Integer.parseInt(st.nextToken());
				if (i < j) {
					adjList[i].add(new Vertex(j, weight));
					adjList[j].add(new Vertex(i, weight));
				}
			}
		}

		PriorityQueue<Vertex> q = new PriorityQueue<>();
		q.offer(new Vertex(0, 0));
		long sum = 0;
		while (!q.isEmpty()) {
			Vertex v = q.poll();

			if (visit[v.end]) {
				continue;
			}
			sum += v.weight;
			visit[v.end] = true;
			q.addAll(adjList[v.end]);
		}
		
		System.out.println(sum);
	}

}
