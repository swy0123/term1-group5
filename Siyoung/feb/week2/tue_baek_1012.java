package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 1012 유기농 배추
 */
public class tue_baek_1012 {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int n, m, k, res, ci, cj;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			res = 0;
			int[][] map = new int[n][m];
			boolean[][] v = new boolean[n][m];
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				cj = Integer.parseInt(st.nextToken());
				ci = Integer.parseInt(st.nextToken());
				map[ci][cj] = 1;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						map = bfs(map, v, i, j);
						res++;
					}
				}
			}
			System.out.println(res);
		}
		
		
		
	}
	
	
	private static int[][] bfs(int[][] map, boolean[][] v, int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		v[i][j] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
//			System.out.println(p.r +" "+p.c+" "+cnt);
			
			for(int d=0; d<4; d++) {
				int cr = p.r+dr[d];
				int cc = p.c+dc[d];
				if (cr >= 0 && cr < map.length && cc >= 0 && cc < map[0].length && !v[cr][cc] && map[cr][cc] == 1) {
					v[cr][cc] = true;
					
					q.add(new Point(cr, cc));
				}
			}
		}
		return map;
	}

}
