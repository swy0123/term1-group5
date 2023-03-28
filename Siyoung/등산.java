package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1486 등산
public class 등산 {
	static class node implements Comparable<node>{
		int ti, tj, w;

		public node(int ti, int tj, int w) {
			super();
			this.ti = ti;
			this.tj = tj;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return this.w-o.w;
		}

		@Override
		public String toString() {
			return "node [ti=" + ti + ", tj=" + tj + ", w=" + w + "]";
		}
		
		
	}
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};	
	
	static int n, m, t, d;
	static int[][] map;
	static ArrayList<node>[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				int tmp = str.charAt(j);
				if(tmp>='A' && tmp<='Z') {
					map[i][j] = tmp-'A';
				}
				else map[i][j] = tmp-'a'+26;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int d=0; d<4; d++) {
					int ci = i+di[d];
					int cj = j+dj[d];
					if(ci>=0 && ci<n && cj>=0 && cj<m && (Math.abs(map[ci][cj]-map[i][j])<=t)) {
						int ctime = 1;
						if(map[i][j]<map[ci][cj]) ctime = (int) (Math.pow(map[ci][cj] - map[i][j], 2));
						arr[i][j].add(new node(ci, cj, ctime));
					}
				}
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
////				System.out.println(arr[i][j]);
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();;
//		}
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		boolean[][] v = new boolean[n][m];
		int[][] dist1 = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(dist1[i], Integer.MAX_VALUE);
		}
		pq.add(new node(0, 0, 0));
		dist1[0][0] = 0;
		
		while(!pq.isEmpty()) {
			node n = pq.poll();
			
			if(v[n.ti][n.tj]) continue;
			v[n.ti][n.tj] = true;
			
			for (node next : arr[n.ti][n.tj]) {
				if(dist1[next.ti][next.tj]>dist1[n.ti][n.tj]+next.w) {
					dist1[next.ti][next.tj] = dist1[n.ti][n.tj]+next.w;
					pq.add(next);
				}
			}
		}
		
//		for (int[] is : dist1) {
//			System.out.println(Arrays.toString(is));
//		}
		//----------------------------------------------
		
		arr = new ArrayList[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int d=0; d<4; d++) {
					int ci = i+di[d];
					int cj = j+dj[d];
					if(ci>=0 && ci<n && cj>=0 && cj<m && (Math.abs(map[ci][cj]-map[i][j])<=t)) {
						int ctime = 1;
						if(map[i][j] < map[ci][cj]) ctime = (int) Math.pow(Math.abs(map[i][j] - map[ci][cj]), 2);
						arr[ci][cj].add(new node(i, j, ctime));
					}
				}
			}
		}
		pq = new PriorityQueue<>();
		v = new boolean[n][m];
		int[][] dist2 = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(dist2[i], Integer.MAX_VALUE);
		}
		pq.add(new node(0, 0, 0));
		dist2[0][0] = 0;
		
		while(!pq.isEmpty()) {
			node n = pq.poll();
			
			if(v[n.ti][n.tj]) continue;
			v[n.ti][n.tj] = true;
			
			for (node next : arr[n.ti][n.tj]) {
				if(dist2[next.ti][next.tj]>dist2[n.ti][n.tj]+next.w) {
					dist2[next.ti][next.tj] = dist2[n.ti][n.tj]+next.w;
					pq.add(next);
				}
			}
		}
		
//		for (int[] is : dist2) {
//			System.out.println(Arrays.toString(is));
//		}
		
		int max = 0;
		int[][] dist = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dist1[i][j] == Integer.MAX_VALUE && dist2[i][j] == Integer.MAX_VALUE) continue;
				dist[i][j] = dist1[i][j] + dist2[i][j];
//				System.out.print(dist[i][j]+" ");
				if(dist[i][j]<=d && map[i][j]>max) {
					max = map[i][j];
				}
			}
//			System.out.println();
		}
		System.out.println(max);
		
		
	}
	
}
