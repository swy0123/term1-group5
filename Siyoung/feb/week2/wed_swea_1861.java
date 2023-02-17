package feb.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * swea 1861. 정사각형 방
 */
public class wed_swea_1861 {
	static class point{
		int i, j, num;

		public point(int i, int j, int num) {
			super();
			this.i = i;
			this.j = j;
			this.num = num;
		}
	}
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int n, max, num;

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			max = 0;
			num = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] != -1) {
						map = bfs(map, i, j);
					}
				}
			}
			
			System.out.println("#"+test_case+" "+num+" "+max);
		}
	}
	
	private static int[][] bfs(int[][] map, int i, int j){
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];

		int cur = 1;
		q.add(new point(i, j, map[i][j]));
		v[i][j] = true;
		int cnum = map[i][j];
		map[i][j] = -1;
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj]) {
					if(Math.abs(map[ci][cj]-p.num) == 1) {
						q.add(new point(ci, cj, map[ci][cj]));
						cur++;
						v[ci][cj] = true;
						cnum = Math.min(cnum, map[ci][cj]);
						map[ci][cj] = -1;
					}
				}
			}
		}
		if(cur == max) {
			num = Math.min(cnum, num);
		}
		if(cur > max) {
			max = cur;
			num = cnum;
		}
		
		return map;
		
	}

}
