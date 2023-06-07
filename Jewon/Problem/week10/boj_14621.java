package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * boj_14621 나만 안되는 연애 골드3
 * 
 * @author elder
 *
 */
public class boj_14621 {

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int N, M;
	static char[] node_sex;
	static boolean[] visited;
	static int Ans_dist;
	static int nodes[];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Ans_dist = 0;
		cnt = 0;
		node_sex = new char[N];
		visited = new boolean[N];
		nodes = new int[N];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			node_sex[i] = st.nextToken().charAt(0);
		}

		PriorityQueue<Edge> q = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
				
			q.offer(new Edge(a, b, c));
		}
		
		int size = q.size();
		
		for (int i = 0; i < size; i++) {
			Edge e = q.poll();
			
			if(node_sex[e.start] == node_sex[e.end]) {
				continue;
			}
			
			if(!union(e.start, e.end, e.weight)) {
				continue;
			}
			
			cnt++;
			if(cnt == N-1) break;	
		}
		
		if(cnt == N-1) System.out.println(Ans_dist);
		else System.out.println(-1);
	}

	private static boolean union(int start, int end, int weight) {
		int pa = find(start);
		int pb = find(end);

		if (pa == pb) {
			return false;
		} else {
			nodes[pb] = pa;
			Ans_dist += weight;
			return true;
		}

	}

	private static int find(int node) {
		if (nodes[node] == node)
			return node;
		else
			return nodes[node] = find(nodes[node]);
	}

}
