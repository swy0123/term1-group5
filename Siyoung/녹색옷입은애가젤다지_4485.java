package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지_4485 {
	static class node implements Comparable<node>{
		int i, j, w;

		public node(int i, int j, int w) {
			super();
			this.i = i;
			this.j = j;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return this.w-o.w;
		}
		
	}

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int n;
	
	static ArrayList<node>[][] map;
	static int val, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			map = new ArrayList[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = new ArrayList<>();
				}
			}
			val = 0;
			max = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					int w = Integer.parseInt(st.nextToken());
					if(i==0 && j==0) val = w;
					for(int d=0; d<4; d++) {
						int ci = i+di[d];
						int cj = j+dj[d];
						if(ci>=0 && ci<n && cj>=0 && cj<n) {
							map[ci][cj].add(new node(i, j, w));
						}
					}
				}
			}
			dijk();
			System.out.println("Problem "+tc+": "+max);
			tc++;
		}
	}
	
	private static void dijk() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		int[][] dist = new int[n][n];
		for (int[] is : dist) {
			Arrays.fill(is, Integer.MAX_VALUE);
		}
		pq.add(new node(0, 0, val));
		dist[0][0] = val;
		
		while(!pq.isEmpty()) {
			node cn = pq.poll();
			
			if(cn.i==n-1 && cn.j==n-1) break;
			
			for (node next : map[cn.i][cn.j]) {
				if(dist[next.i][next.j]>dist[cn.i][cn.j]+next.w) {
					dist[next.i][next.j] = dist[cn.i][cn.j]+next.w;
					pq.add(new node(next.i, next.j, dist[next.i][next.j]));
				}
				
			}
		}
//		for (int[] is : dist) {
//			System.out.println(Arrays.toString(is));
//		}

		max = Math.max(dist[n-1][n-1], max);
		
	}
}
