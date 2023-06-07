package se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055 {
	static class point{
		int i, j, cnt;
		boolean water = false;
		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		public point(int i, int j, boolean water) {
			super();
			this.i = i;
			this.j = j;
			this.water = water;
		}
		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + ", cnt=" + cnt + ", water=" + water + "]";
		}
		
	}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int r, c, si, sj, ei, ej, res; 
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					si = i;
					sj = j;
				}
			}
		}

		res = -1;
		bfs();
		if(res > 0) System.out.println(res);
		else System.out.println("KAKTUS");
	}
	
	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]=='*') {
					q.add(new point(i, j, true));
				}
			}
		}
		q.add(new point(si, sj, 0));
		
		L: while(!q.isEmpty()) {
			point p = q.poll();
//			System.out.println(p);
//			for (char[] po : map) {
//				System.out.println(Arrays.toString(po));
//			}
			for(int d=0; d<4; d++) {
				int ni = p.i+di[d];
				int nj = p.j+dj[d];
//				System.out.println(ni+" "+nj+" "+(p.cnt+1));
				if(ni>=0 && ni<r && nj>=0 && nj<c && map[ni][nj]!='X') {
					if(p.water && map[ni][nj]!='D' && map[ni][nj]!='*') {
						map[ni][nj] = '*';
						q.add(new point(ni, nj, true));
					}
					if(!p.water) {
						if(map[ni][nj]=='D') {
							res = p.cnt+1;
//							System.out.println(res);
							break L;
						}
						if(map[ni][nj]=='.') {
							map[ni][nj] = 'S';
							q.add(new point(ni, nj, p.cnt+1));
						}
					}
				}
			}
		}
		
	}
	
}

