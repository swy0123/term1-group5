package baek;

import java.io.*;
import java.util.*;
/*
 * 백준 14502 연구소
 */
public class thu_baek_14502 {
	static class point{
		int i, j;

		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, m, map[][], max;
	static ArrayList<point> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) arr.add(new point(i, j));
			}
		}
		max = 0;
		solve(0, 0, 0);
		System.out.println(max);
	}
	
	private static void solve(int i, int j, int idx) {
		if(idx == 3) {
			int cur = bfs();
			max = Math.max(max, cur);
			return;
		}
		
		for(int ci=i; ci<n; ci++) {
			for(int cj=0; cj<m; cj++) {
				if(ci==i && cj<j) continue;
				if(map[ci][cj]==0) {
					map[ci][cj] = 1;
					solve(ci, cj, idx+1);
					map[ci][cj] = 0;
				}
			}
		}
	}
	
	private static int bfs() {
		int[][] tmp = new int[n][m];
		for(int i=0; i<n; i++) {
			tmp[i] = map[i].clone();
		}
		
		Queue<point> q = new LinkedList<>();
		q.addAll(arr);
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<m && tmp[ci][cj]==0) {
					tmp[ci][cj] = 2;
					q.add(new point(ci, cj));
				}
			}
		}
		int sum = 0;
		for (int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(tmp[i][j]==0) sum++;
			}
		}
		return sum;
	}
	

}
