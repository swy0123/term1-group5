package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 7576 토마토
 */
public class tue_baek_7576 {
	
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] v;
	static int m, n, day;
	static class point{
		int i, j, cnt;

		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		v = new boolean[n][m];
		day = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if(bfs()) System.out.println(day);
		else System.out.println(-1);
		
	}
	
	private static boolean bfs() {
		Queue<point> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && !v[i][j]) {
					q.add(new point(i, j, 0));
					v[i][j] = true;
				}
			}
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			
			
			point p = q.poll();
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(p.i +" "+ p.j + " "+p.cnt);
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if (ci >= 0 && ci < n && cj >= 0 && cj < m && !v[ci][cj] && map[ci][cj] == 0) {
					v[ci][cj] = true;
					map[ci][cj] = 1;
					q.add(new point(ci, cj, p.cnt+1));
					day = Math.max(day, p.cnt+1);
				}
			}
		}
		
		for (int[] a : map) {
			for (int b : a) {
				if(b==0) return false; 
			}
		}
		return true;
		
	}

}
