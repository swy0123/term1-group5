package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 전기가부족해_10423 {
	static class node implements Comparable<node>{
		int end, w;

		public node(int end, int w) {
			super();
			this.end = end;
			this.w = w;
		}
		@Override
		public int compareTo(node o) {
			return this.w-o.w;
		}
	}
	
	static ArrayList<node>[] arr;
	static int n, m, k, gen[];
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		gen = new int[k];
		v = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			gen[i] = Integer.parseInt(st.nextToken());
//			v[gen[i]] = true;
		}
		
		arr = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int from, to, w;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			arr[from].add(new node(to, w));
			arr[to].add(new node(from, w));
		}
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		for(int i=0; i<k; i++) {
			pq.add(new node(gen[i], 0));
		}
		
		int res = 0;
		while(!pq.isEmpty()) {
			node cn = pq.poll();
			
			if(v[cn.end]) continue;
			v[cn.end] = true;
//			System.out.println(cn.w);
			res += cn.w;
			for (node next : arr[cn.end]) {
				pq.add(next);
			}
		}
		
		System.out.println(res);
	}
}
