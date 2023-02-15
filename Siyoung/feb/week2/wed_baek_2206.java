package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 2206 벽 부수고 이동하기
 */
public class wed_baek_2206 {
	
	static class point{
		int i, j, cnt;
		boolean b;

		public point(int i, int j, boolean b, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.b = b;
			this.cnt = cnt;
		}
		
	}
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	
	static int n, m;
	static int min = -1;
	static int[][] map;
	static boolean[][] v1;
	static boolean[][] v2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		v1 = new boolean[n][m];
		v2 = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		map();
		System.out.println(min);
	}
	
	private static void map() {
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(0, 0, true, 1));
		v1[0][0] = true;
		v1[0][0] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.i == n-1 && p.j == m-1) {
//				System.out.println(p.cnt);
				if(min<0) min = p.cnt;
				else min = Math.min(min, p.cnt);
			}
//			for (int[] i : map) {
//				System.out.println(Arrays.toString(i));
//			}
//			System.out.println(p.cnt);
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<m) {
					if(map[ci][cj] == 0 && p.b && !v1[ci][cj]) {
							v1[ci][cj] = true;
							q.add(new point(ci, cj, p.b, p.cnt+1));
					}
					else if(map[ci][cj] == 1 && p.b && !v1[ci][cj]) {
						v2[ci][cj] = true;
						q.add(new point(ci, cj, false, p.cnt+1));
				
					}
					else if(map[ci][cj] == 0 && !p.b && !v2[ci][cj]) {
						v2[ci][cj] = true;
						q.add(new point(ci, cj, p.b, p.cnt+1));
					}
				}
			}
		}
		
		
		
	}

}
