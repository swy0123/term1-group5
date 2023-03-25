package algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 1753 최단경로
 */
public class thu_baek_1763 {
	
	static class node implements Comparable<node>{
		int end, weight;

		public node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static ArrayList<node>[] arr;
	static int n, m, s, dist[];
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		s = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		v = new boolean[n+1];
		dist = new int[n+1];
		
		int from, to, w;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr[from].add(new node(to, w));
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<node> pq = new PriorityQueue<>();
		dist[s] = 0;
		pq.add(new node(s, 0));
		while(!pq.isEmpty()) {
			int ci = pq.poll().end;
			
			if(v[ci]) continue;
			v[ci] = true;
			
			for (node next : arr[ci]) {
				if(dist[next.end] > dist[ci]+next.weight) {
					dist[next.end] = dist[ci] + next.weight;
					
					pq.add(new node(next.end, dist[next.end]));
				}
			}
		}

		for(int i=1; i<=n; i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
		
	}

}
