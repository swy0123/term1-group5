package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static class node{
		int i, j;
		public node(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int n, m;
	static int[][] map, dist;
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dist = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		solve(new node(n-1, m-1));
		
//		for (int[] ii : dist) {
//			System.out.println(Arrays.toString(ii));
//		}
		System.out.println(dist[n-1][m-1]);
		
	}
	
	private static int solve(node cn) {
		if(cn.i==0 && cn.j==0) {
			return 1;
		}

		int i = cn.i;
		int j = cn.j;
		if(dist[i][j] == -1) dist[i][j] = 0; 
		for(int d=0; d<4; d++) {
			int ci = i+di[d];
			int cj = j+dj[d];
			if(ci>=0 && ci<n && cj>=0 && cj<m && map[ci][cj]>map[i][j]) {
				if(dist[ci][cj]==-1) {
					dist[i][j] += solve(new node(ci, cj));
				}
				else dist[i][j] += dist[ci][cj];
			}
		}
		return dist[i][j];
	}
}
