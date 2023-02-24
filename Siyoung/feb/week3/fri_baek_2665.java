package algorithm.week3.fri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 백준 2665 미로만들기
 */
public class fri_baek_2665 {
	
	static class point{
		int i, j, dis, cnt;

		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	static int n, map[][], cnt;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
//		min = Integer.MAX_VALUE;
		cnt = 0;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
//		boolean[][] v = new boolean[n][n];
//		v[0][0] = true;
//		find(0, 0, 0, v);
		
		while(!flag) {
			round();
			cnt++;
		}
		
//		System.out.println(cnt);
	}
	
	private static void round() {
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		q.add(new point(0, 0, 0));
		v[0][0] = true;
		
		L: while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				
				if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj]) {
					if(ci == n-1 && cj == n-1) {
						System.out.println(cnt);
						flag = true;					
						break L;
					}
					if(map[ci][cj] == 1) {
						v[ci][cj] = true;
						q.add(new point(ci, cj, p.cnt));
					}
					if(map[ci][cj] == 0) {
						v[ci][cj] = true;
						map[ci][cj] = 1;
					}
				}
			}
		}
		
		
	}
	
//	private static void find(int i, int j, int cnt, boolean[][] v) {
//		if(i == n-1 && j == n-1) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		if(cnt >= min) return;
//		
//		for(int d=0; d<4; d++) {
//			int ci = i+di[d];
//			int cj = j+dj[d];
//			
//			if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj] && cnt+1 < min) {
//				if(map[ci][cj] == 0 && !v[ci][cj]) {
//					v[ci][cj] = true;
//					find(ci, cj, cnt+1, v);
//					v[ci][cj] = false;
//				}
//				else {
//					v[ci][cj] = true;
//					find(ci, cj, cnt, v);
//					v[ci][cj] = false;
//				}
//			}
//		}
//		
//	}

	
}
