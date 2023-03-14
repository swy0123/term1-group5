package baek9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 2468 안전영역
 */
public class tue_baek_2468 {
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
	
	static int n, map[][], max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int h = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				h = Math.max(h, map[i][j]);
			}
		}
		
		max = 0;
		
		for(int i=0; i<h; i++) {
			max = Math.max(max, solve(i));
		}
		System.out.println(max);
	}
	private static void bfs(int i, int j, boolean[][] check) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(i, j));
		check[i][j] = false;
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && check[ci][cj]) {
					q.add(new point(ci, cj));
					check[ci][cj] = false;
				}
			}
		}
	}
	
	private static int solve(int h) {
		int res = 0;
		boolean[][] check = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]>h) {
					check[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j]) {
					bfs(i, j, check);
					res++;
				}
			}
		}
		
		return res;
	}

}
