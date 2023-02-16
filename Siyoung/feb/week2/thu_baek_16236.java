package algorithm.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 16236 아기상어
 */
public class thu_baek_16236 {
	
	static class point{
		int i, j, time;

		public point(int i, int j, int time) {
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
		
	}
	static int[] di = {-1, 0, 0, 1};
	static int[] dj = {0, -1, 1, 0};
	static int[][] map;

	static int n, cursize, curtime, exp, si, sj;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int cnt = 0;
		map = new int[n][n];
		cursize = 2;
		curtime = 0;
		exp = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 9) cnt++;
				else if(map[i][j] == 9) {
					si = i;
					sj = j;
				}
			}
		}
		
		for(int i=0; i<cnt; i++) {
			bfs(si, sj);
//			System.out.println("s "+si+" "+sj);
//			for (int[] a : map) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println(curtime +" "+ cursize);
		}

		System.out.println(curtime);
	}

	
	// bfs로 먹을 수 있는 것 확인 후 이동, 상 좌 우 하 순으로 탐색, 
	//칸에 자신보다 큰 수 있으면 못지나감, 동일한 크기는 무시 
	private static void bfs(int i, int j) {
		boolean[][] v = new boolean[n][n];
		Queue<point> q = new LinkedList<>();
		v[i][j] = true;
		map[i][j] = 0;
		q.add(new point(i, j, curtime));
		boolean flag = false;
		boolean levelup = false;
		int tmp = -1;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.time == tmp) break;
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0  && ci<n && cj>=0 && cj<n && !v[ci][cj] && map[ci][cj]<=cursize) {
					v[ci][cj] = true;
					if(map[ci][cj] == 0 || map[ci][cj] == cursize) q.add(new point(ci, cj, p.time+1));
					else if(map[ci][cj]>0 && map[ci][cj]<cursize) {
						if(!flag) {
							si = ci;
							sj = cj;
							exp++;
							if(exp == cursize) {
								exp = 0;
								levelup = true;
							}
							curtime = p.time+1;
							tmp = p.time+1;
							flag = true;
						}
						else if(si>ci) {
							si = ci;
							sj = cj;
						}
						else if(si==ci && sj>cj) {
							si = ci;
							sj = cj;
						}
						
					}
//					System.out.println(ci +" "+ cj +" "+si+" "+sj+"  "+curtime+" "+exp+" "+flag);
						
				}
			}
			
		}
		map[si][sj] = 9;
		if(levelup) cursize++;
	}
	
	
}
