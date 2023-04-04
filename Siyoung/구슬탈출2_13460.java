package se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출2_13460 {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, m, hi, hj, res;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		hi = -1;
		hj = -1;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'O') {
					hi = i;
					hj = j;
				}
			}
		}
		res = 11;
		solve(1, 5);
		if(res<11)System.out.println(res);
		else System.out.println(-1);
	}
	
	//백트래킹
	private static void solve(int cnt, int dir) {
		if(cnt > 10) {
			return;
		}
		
		int ri=0, rj=0, bi=0, bj=0;
		char[][] tmp = new char[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp[i][j] = map[i][j];
				if(map[i][j]=='R') {
					ri = i;
					rj = j;
				}
				if(map[i][j]=='B') {
					bi = i;
					bj = j;
				}
			}
		}
		
		for(int d=0; d<4; d++) {
			if(d == dir) continue;
			
			int state = moveBall(ri, rj, bi, bj, d);
			
			
			if(state == 0) {
//				System.out.println("goal" + cnt);
//				for (char[] is : map) {
//					System.out.println(Arrays.toString(is));
//				}
				res = Math.min(res, cnt);
				return;
			}
			if(state == 1) solve(cnt+1, d);
			
			
			for(int i=0; i<n; i++) {
				map[i] = tmp[i].clone();
			}
		}
		
	}
	
	private static int moveBall(int ri, int rj, int bi, int bj, int d) {
		boolean b, r;
		b = moveBlue(bi, bj, d);
		r = moveRed(ri, rj, d);
		if(!b) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]=='B') {
						bi = i;
						bj = j;
					}
				}
			}
			b = moveBlue(bi, bj, d);
		}
		if(r && !b) return 0;
		if(!r && !b) return 1;
		else return 2;
		
	}
	private static boolean moveRed(int ri, int rj, int d) {
		int ci=ri, cj=rj;
		map[ri][rj] = '.';
		boolean flag = false;
		while(true) {
			int ni = ci+di[d];
			int nj = cj+dj[d];
			if(ni>0 && ni<n-1 && nj>0 && nj<m-1) {
				if(map[ni][nj]=='.') {
					ci = ni;
					cj = nj;
					continue;
				}
				else if(map[ni][nj]=='O') {
					flag = true;
				}
			}
			break;
		}
		if(!flag) map[ci][cj] = 'R';
		return flag;
	}
	
	private static boolean moveBlue(int bi, int bj, int d) {
		int ci=bi, cj=bj;
		map[bi][bj] = '.';
		boolean flag = false;
		while(true) {
			int ni = ci+di[d];
			int nj = cj+dj[d];
			if(ni>0 && ni<n-1 && nj>0 && nj<m-1) {
				if(map[ni][nj]=='.') {
					ci = ni;
					cj = nj;
					continue;
				}
				else if(map[ni][nj]=='O') {
					flag = true;
				}
			}
			
			break;
		}
		if(!flag) map[ci][cj] = 'B';
		return flag;
	}
}

