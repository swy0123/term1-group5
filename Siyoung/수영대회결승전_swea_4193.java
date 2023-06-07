package se;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영대회결승전_swea_4193 {
	
	static class point{
		int i, j, cnt;

		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int[][] map;
	static int n, si=0, sj=0, ei=0, ej=0, res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ei = Integer.parseInt(st.nextToken());
			ej = Integer.parseInt(st.nextToken());
			res=-1;
			bfs();
			System.out.println("#"+tc+" "+res);
			
		}
	}
	
	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		q.add(new point(si, sj, 0));
		v[si][sj] = true;
		
		L: while(!q.isEmpty()) {
			point p = q.poll();
			
			boolean flag = false;
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && map[ci][cj] != 1 && !v[ci][cj]) {
					if(ci==ei && cj==ej) {
						res=p.cnt+1;
						break L;
					}
					if(map[ci][cj]==0) {
						v[ci][cj] = true;
						q.add(new point(ci, cj, p.cnt+1));
					}
					if(map[ci][cj]==2) {
						if(p.cnt%3==2) {
							v[ci][cj] = true;
							q.add(new point(ci, cj, p.cnt+1));
						}
						else flag = true;
					}
				}
			}
			if(flag) {
				q.add(new point(p.i, p.j, p.cnt+1));
			}
		}
	}
}