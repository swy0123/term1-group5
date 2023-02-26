package feb.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 15683 감시
 */
public class sun_baek_15683 {
	
	static class point{
		int i, j, type;
		
		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		public point(int i, int j, int type) {
			super();
			this.i = i;
			this.j = j;
			this.type = type;
		}
		
	}
	
	static int[][][] types = {
			{},
			{{0}, {1}, {2}, {3}},
			{{0, 1}, {2, 3}},
			{{0, 3}, {1, 3}, {1, 2}, {0, 2}},
			{{0, 2, 3}, {0, 1, 3}, {1, 2, 3}, {0, 1, 2}},
			{{0, 1, 2, 3}}
	};
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, m, map[][], res;
	static ArrayList<point> cctv;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		cctv = new ArrayList<>();
		res = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j]<6) {
					cctv.add(new point(i, j, map[i][j]));
				}
			}
		}
		solve(0);
		System.out.println(res);
		
	}
	
	private static void solve(int idx) {
		if(idx == cctv.size()) {
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}System.out.println();
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 0) cnt++;
				}
			}
			res = Math.min(res, cnt);
			return;
		}
		
		point p = cctv.get(idx);
		
		for (int[] tmp : types[p.type]) {
			ArrayList<point> cur = new ArrayList<>();
			int ci, cj;
			for (int d : tmp) {
				ci = p.i + di[d];
				cj = p.j + dj[d];
				while(ci>=0 && ci<n && cj>=0 && cj<m && map[ci][cj]!=6) {
					if(map[ci][cj] == 0) {
						cur.add(new point(ci, cj));
						map[ci][cj] = -1;
					}
					ci += di[d];
					cj += dj[d];
				}
			}
			solve(idx+1);
			for (point point: cur) {
				map[point.i][point.j] = 0;
			}
		}
		
	}
}
