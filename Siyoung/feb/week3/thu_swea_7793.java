package algorithm.week3.thu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * swea 7793. 오! 나의 여신님
 */
public class thu_swea_7793 {
	
	static class point{
		int i, j, cnt;
		boolean isS;

		public point(int i, int j, int cnt, boolean isS) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.isS = isS;
		}
	}
	
	static int[] di = {-1, 1, 0, 0}; 
	static int[] dj = {0, 0, -1, 1}; 

	static int n, m, map[][], min;
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			min = Integer.MAX_VALUE;
			
			int si=-1, sj=-1;
			ArrayList<point> demon = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				String str = br.readLine();
				for(int j=0; j<m; j++) {
					if(str.charAt(j)=='D') {
						map[i][j] = 3;
					}
					else if(str.charAt(j)=='S') {
						map[i][j] = 1;
						si = i;
						sj = j;
					}
					else if(str.charAt(j)=='*') {
						map[i][j] = 2;
						demon.add(new point(i, j, 0, false));
					}
					else if(str.charAt(j)=='X') {
						map[i][j] = -1;
					}
					else {
						map[i][j] = 0;
					}
				}
			}
			bfs(si, sj, demon);
			
			if(min == Integer.MAX_VALUE) System.out.println("#"+test_case+" GAME OVER");
			else System.out.println("#"+test_case+" "+min);
			
		}
	}
	
	private static void bfs(int si, int sj, ArrayList<point> demon) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(si, sj, 0, true));
		for (point p : demon) {
			q.add(p);
		}
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.isS && map[p.i][p.j]==2) continue;
			
			for(int d=0; d<4; d++) {
				int ci=p.i+di[d];
				int cj=p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<m) {
					if(p.isS && map[ci][cj] == 3) {
						min = Math.min(min, p.cnt+1);
						break;
					}
					if(p.isS && (map[ci][cj]==0)) {
						q.add(new point(ci, cj, p.cnt+1, true));
						map[ci][cj] = 1;
						
					}
					if(!p.isS && (map[ci][cj]==1 || map[ci][cj]==0)) {
						q.add(new point(ci, cj, p.cnt+1, false));
						map[ci][cj] = 2;
					}
				}
				
			}
		}
		
	}

}
