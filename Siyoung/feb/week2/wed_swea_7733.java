package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * swea 7733. 치즈 도둑
 */
public class wed_swea_7733 {
	static class point{
		int i, j, cnt;

		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
	static int[] di = { 1, -1, 0, 0 };
	static int[] dj = { 0, 0, 1, -1 };
	static int max;
	static int n;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			int maxDay = 0;
			max = 0;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, map[i][j]);
				}
			}
			
			for(int day=maxDay; day>=0; day--) {
//				for (int[] is : map) {
//					System.out.println(Arrays.toString(is));
//				}
				check(map, day);
			}
			System.out.println("#"+t+" "+max);
		}
	}
	
	private static void check(int[][] map, int num) {
		int cur = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] > num) {
					map = labeling(map, i, j, num);
					cur++;
				}
			}
		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
//		System.out.println();
		
		max = Math.max(max, cur);
		
	}
	
	private static int[][] labeling(int[][] map, int i, int j, int num) {
		boolean[][] v = new boolean[n][n];
		Queue<point> q = new LinkedList<>();
		q.add(new point(i, j, num));
		v[i][j] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj] && map[ci][cj] > num) {
					map[ci][cj] = num;
					v[ci][cj] = true;
					q.add(new point(ci, cj, num));
				}
			}
		}
		return map;
		
		
	}

}
