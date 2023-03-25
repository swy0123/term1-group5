package algorithm.week3.wed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * swea 1949. [모의 SW 역량테스트] 등산로 조성
 */
public class wed_swea_1949 {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, k, max;
	static int[][] map;
	public static void main(String args[]) throws Exception {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			max = 0;
			int highest = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					highest = Math.max(highest, map[i][j]);
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == highest) {
						boolean[][] v = new boolean[n][n];
						v[i][j] = true;
						solve(i, j, v, 1, true, highest);
					}
				}
			}
			
			System.out.println("#"+test_case+" "+max);
		}
	}

	private static void solve(int i, int j, boolean[][] v, int cnt, boolean br, int prev) {
		max = Math.max(max, cnt);

		
		
		for(int d=0; d<4; d++) {
			int ci = i+di[d];
			int cj = j+dj[d];
			if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj]) {
				if(map[ci][cj] < prev) {
					v[ci][cj] = true;
					solve(ci, cj, v, cnt+1, br, map[ci][cj]);
					v[ci][cj] = false;
				}
				else {
					if(br && (map[ci][cj]-k < prev)) {
						v[ci][cj] = true;
						solve(ci, cj, v, cnt+1, false, prev-1);
						v[ci][cj] = false;
					}
				}
				
			}
		}
	}
	
//	private static void solve(int r, int c) {
//		Queue<point> q = new LinkedList<>();
//		int[][] v = new int[n][n];
//		
//		q.add(new point(r, c, 1, false, map[r][c]));
//		v[r][c] = 1;
//		
//		while(!q.isEmpty()) {
//			point p = q.poll();
//			max = Math.max(max, p.cnt);
//			
//			for(int d=0; d<4; d++) {
//				int ci = p.i+di[d];
//				int cj = p.j+dj[d];
//				if(ci>=0 && ci<n && cj>=0 && cj<n) {
//					if(map[ci][cj] < p.h) {
//						if(!p.isC) {
//							if(v[ci][cj] <= p.cnt) {
//								q.add(new point(ci, cj, p.cnt+1, p.isC, map[ci][cj]));
//								
//							}
//							
//							
//						}
//						else {
//							q.add(new point(ci, cj, p.cnt+1, p.isC, map[ci][cj]));
//							v2[ci][cj] = true;
//						}
//					}
//					else {
//						if(!p.isC) {
//							if(map[ci][cj]-k < p.h) {
//								q.add(new point(ci, cj, p.cnt+1, true, p.h-1));
//								v2[ci][cj] = true;
//							}
//						}
//					}
//					
//				}
//			}
//			
//		}
//		
//		for (boolean[] bs : v) {
//			System.out.println(Arrays.toString(bs));
//		}System.out.println(max);
//	}

}
