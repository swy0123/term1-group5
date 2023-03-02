package algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 백준 17396 백도어
 */
public class thu_baek_17396 {
	
	static class node implements Comparable<node>{
		int end;
		long weight;

		public node(int end, long weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(node o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	

	static int[] sight;
	static long[] dist;
	static ArrayList<node>[] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		sight = new int[n];
		dist = new long[n];
		v = new boolean[n];
		arr = new ArrayList[n];
		for(int i=0; i<n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			sight[i] = Integer.parseInt(st.nextToken());
		}
		
		int from, to;
		long w;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr[from].add(new node(to, w));
			arr[to].add(new node(from, w));
		}
		
		Arrays.fill(dist, Long.MAX_VALUE);
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		dist[0] = 0;
		pq.add(new node(0, 0));
		while(!pq.isEmpty()) {
			int ci = pq.poll().end;
			
			if(v[ci]) continue;
			v[ci] = true;
			if(ci!=n-1&&sight[ci]==1) continue;
			
			for (node next : arr[ci]) { 
				if(dist[next.end] > dist[ci]+next.weight) {
					dist[next.end] = dist[ci]+next.weight;
					
					pq.add(new node(next.end, dist[next.end]));
				}
				
			}
		}
		
		if(dist[n-1]==Long.MAX_VALUE) System.out.println("-1");
		else System.out.println(dist[n-1]);

	}

}
