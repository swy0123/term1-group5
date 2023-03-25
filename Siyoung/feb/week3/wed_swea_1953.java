package algorithm.week3.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * swea 1953. [모의 SW 역량테스트] 탈주범 검거
 */
public class wed_swea_1953 {
	
	static class point{
		int i, j, cnt;

		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
	
	//상하좌우
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int[][] pipe = {
			{0, 1, 2, 3},
			{0, 1},
			{2, 3},
			{0, 3},
			{1, 3},
			{1, 2},
			{0, 2}
	};
	static int[][] map;
	static int n, m, r, c, l, cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			cnt = 0;
			map = new int[n][m];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			solve(r, c);
			System.out.println("#"+test_case+" "+cnt);
		}

	}
	
	
	private static void solve(int i, int j) {
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][m];
		
		q.add(new point(i, j, l));
		v[i][j] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			if(p.cnt==1) continue;
			
			if(map[p.i][p.j]> 0) {
				for (int d :pipe[map[p.i][p.j]-1]) {
					int ci = p.i+di[d];
					int cj = p.j+dj[d];
					if(ci>=0 && ci<n && cj>=0 && cj<m && !v[ci][cj]) {
						if(map[ci][cj]>0) {
							if(d == 0) {
								if(map[ci][cj] == 1 || map[ci][cj] == 2 || map[ci][cj] == 5 || map[ci][cj] == 6) {
									q.add(new point(ci, cj, p.cnt-1));
									v[ci][cj] = true;
								}
							}
							if(d == 1) {
								if(map[ci][cj] == 1 || map[ci][cj] == 2 || map[ci][cj] == 4 || map[ci][cj] == 7) {
									q.add(new point(ci, cj, p.cnt-1));
									v[ci][cj] = true;
								}
							}
							if(d == 2) {
								if(map[ci][cj] == 1 || map[ci][cj] == 3 || map[ci][cj] == 4 || map[ci][cj] == 5) {
									q.add(new point(ci, cj, p.cnt-1));
									v[ci][cj] = true;
								}
							}
							if(d == 3) {
								if(map[ci][cj] == 1 || map[ci][cj] == 3 || map[ci][cj] == 6 || map[ci][cj] == 7) {
									q.add(new point(ci, cj, p.cnt-1));
									v[ci][cj] = true;
								}
							}
						}
					}
				}
			}
		}
		
		for (boolean[] bs : v) {
//			System.out.println(Arrays.toString(bs));
			for (boolean bs2 : bs) {
				if(bs2) cnt++;
			}
		}
		
	}
}
