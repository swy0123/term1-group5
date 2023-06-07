package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불_4179 {
	
	static class point{
		int i, j, cnt;
		boolean fire = false;
		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		public point(int i, int j, boolean fire) {
			super();
			this.i = i;
			this.j = j;
			this.fire = fire;
		}
	}
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static char[][] map;
	static int n, m, res, si, sj;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					si = i;
					sj = j;
				}
			}
		}
		
		res = Integer.MAX_VALUE;
		bfs();
		if(res != Integer.MAX_VALUE) System.out.println(res);
		else System.out.println("IMPOSSIBLE");
		
	}
	
	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 'F') {
					q.add(new point(i, j, true));
				}
			}
		}
		q.add(new point(si, sj, 0));
		
		L: while(!q.isEmpty()) {
			point p = q.poll();
			for(int d=0; d<4; d++) {
				int ni=p.i+di[d];
				int nj=p.j+dj[d];
				if(!p.fire) {
					if(ni<0 || ni>=n || nj<0 || nj>=m) {
						res = Math.min(res, p.cnt+1);
						break L;
					}
				}
				if(ni>=0 && ni<n && nj>=0 && nj<m && map[ni][nj] != '#') {
					if(p.fire && map[ni][nj]!='F') {
						map[ni][nj] = 'F';
						q.add(new point(ni, nj, true));
					}
					if(!p.fire && map[ni][nj]=='.') {
						map[ni][nj] = 'J';
						q.add(new point(ni, nj, p.cnt+1));
					}
				}
			}
		}
	}

}
