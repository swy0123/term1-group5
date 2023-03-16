package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 1504 특정한 최단 경로
 */
public class thu_baek_1504 {
	static class node implements Comparable<node>{
		int end, w;

		public node(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}
	
	static ArrayList<node>[] arr;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int from, to, weight;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			arr[from].add(new node(to, weight));
			arr[to].add(new node(from, weight));
		}
		st = new StringTokenizer(br.readLine());
		int tmp1 = Integer.parseInt(st.nextToken());
		int tmp2 = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		int start, end;
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(tmp1, 0));
		dist[tmp1] = 0;

		while(!pq.isEmpty()) {
			node cn = pq.poll();
			if(cn.end == tmp2) break;
			for (node next : arr[cn.end]) {
				if(dist[next.end] > dist[cn.end]+next.w) {
					dist[next.end] = dist[cn.end]+next.w;
					pq.add(new node(next.end, dist[next.end]));
				}
			}
		}
		
		sum = dist[tmp2];
		
		int sum1 = 0;
		int sum2 = 0;
		start = 0;
		end = 0;
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq = new PriorityQueue<>();
		pq.add(new node(1, 0));
		dist[1] = 0;

		while(!pq.isEmpty()) {
			node cn = pq.poll();
			for (node next : arr[cn.end]) {
				if(dist[next.end] > dist[cn.end]+next.w) {
					dist[next.end] = dist[cn.end]+next.w;
					pq.add(new node(next.end, dist[next.end]));
				}
			}
		}
		sum1 = dist[tmp1];
		sum2 = dist[tmp2];
		
		int sum11 = 0;
		int sum22 = 0;
		start = 0;
		end = 0;
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq = new PriorityQueue<>();
		pq.add(new node(n, 0));
		dist[n] = 0;

		while(!pq.isEmpty()) {
			node cn = pq.poll();
			for (node next : arr[cn.end]) {
				if(dist[next.end] > dist[cn.end]+next.w) {
					dist[next.end] = dist[cn.end]+next.w;
					pq.add(new node(next.end, dist[next.end]));
				}
			}
		}
		sum11 = dist[tmp2];
		sum22 = dist[tmp1];
		
		long sum111 = sum1 + sum11 + sum;
		long sum222 = sum2 + sum22 + sum;
		
		int res = Math.min(sum1, sum2);
		if(sum==Integer.MAX_VALUE ||
				((sum1==Integer.MAX_VALUE||sum11==Integer.MAX_VALUE) 
						&& (sum2==Integer.MAX_VALUE||sum22==Integer.MAX_VALUE))) {
			System.out.println(-1);
		}
		else {
			System.out.println(Math.min(sum111, sum222));
		}
	}
}