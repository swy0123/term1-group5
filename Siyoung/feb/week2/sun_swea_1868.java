package feb.week2.sat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * swea 1868. 파핑파핑 지뢰찾기
 */
public class sun_swea_1868 {
	static class point{
		int i, j;

		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "point [i=" + i + ", j=" + j + "]";
		}
		
	}
	
	static int cnt;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)	{
			int n = Integer.parseInt(br.readLine());
			
			char[][] map = new char[n][n];
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<n; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			cnt = 0;
			fill(map, n);
			
		

			System.out.println("#"+test_case+" "+cnt);
		}
	}
	
	private static void fill(char[][] map, int n){
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == '*') continue;
				check : for(int di=-1; di<=1; di++) {
					for(int dj=-1; dj<=1; dj++) {
						if(di == 0 && di == dj) continue;
						int ci = i+di;
						int cj = j+dj;
						if(ci>=0 && ci<n && cj>=0 && cj<n) {
							if(map[ci][cj] == '*') {
								map[i][j] = 'c';
								break check;
							}
						}
					}
				}
			}
		}
//		for (char[] cs : map) {
//			System.out.println(Arrays.toString(cs));
//		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == '.') {
					bfs(map, n, i, j);
					cnt++;
				}
				
			}
		}
//		System.out.println();
//		for (char[] cs : map) {
//			System.out.println(Arrays.toString(cs));
//		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'c') {
					cnt++;
				}
			}
		}
	}
	
	private static void bfs(char[][] map, int n, int i, int j){
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		q.add(new point(i, j));
		v[i][j] = true;
		map[i][j] = 'd';
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int di=-1; di<=1; di++) {
				for(int dj=-1; dj<=1; dj++) {
					if(di == 0 && di == dj) continue;
					int ci = p.i+di;
					int cj = p.j+dj;
					if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj]) {
						if(map[ci][cj] == '.') {
							q.add(new point(ci, cj));
							v[ci][cj] = true;
							map[ci][cj] = 'd';
						}
						else if(map[ci][cj] == 'c') {
							v[ci][cj] = true;
							map[ci][cj] = 'd';
						}
					}
				}
			}
			
		}
		
	}

}
