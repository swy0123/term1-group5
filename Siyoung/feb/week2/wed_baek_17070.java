package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 17070 파이프 옮기기
 */
public class wed_baek_17070 {
	//아래 대각 오른쪽
	static int[] di = {1, 1, 0};
	static int[] dj = {0, 1, 1};
	
	static class point{
		int i, j, dir;

		public point(int i, int j, int dir) {
			super();
			this.i = i;
			this.j = j;
			this.dir = dir;
//			this.cnt = cnt;
		}
		
	}
	static int n;
	static int cnt = 0;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 1, 2);
		System.out.println(cnt);
	}
	
	
	private static void bfs(int i, int j, int dir) {
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(i, j, dir));
		
		while(!q.isEmpty()) {
			point p = q.poll();
//			System.out.println(p.i+" "+p.j+" "+p.dir);
			if(p.i == n-1 && p.j == n-1) cnt++;
			for(int d=0; d<3; d++) {
				if(d==0 && p.dir==2) continue;
				if(d==2 && p.dir==0) continue;
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				
				
				if(ci>=0 && ci<n && cj>=0 && cj<n && map[ci][cj] == 0) {
					if(d == 1) {
						if(map[p.i][cj] != 0 || map[ci][p.j] != 0) continue; 
					}
					q.add(new point(ci, cj, d));
				}
			}
		}
		
	}

}
