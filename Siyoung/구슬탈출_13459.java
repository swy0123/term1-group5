package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 구슬탈출_13459 {
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static char[][] map;
	static int n, m;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		flag = false;
		solve(1, 5);
		if(!flag) System.out.println(0);
	}
	
	private static void solve(int cnt, int dir) {
		if(cnt>10) {
			
			return;
		}
		
		char[][] tmp = new char[n][m];
		int ri=0, rj=0, bi=0, bj=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp[i][j] = map[i][j];
				if(map[i][j] == 'B') {
					bi = i;
					bj = j;
				}
				if(map[i][j] == 'R') {
					ri = i;
					rj = j;
				}
			}
		}

//		for (char[] i : map) {
//			System.out.println(Arrays.toString(i));
//		}System.out.println();
		
		for(int d=0; d<4; d++) {
			if(d==dir) continue;
			int state = moveBall(bi, bj, ri, rj, d);
			if(state == 0) {
				System.out.println(1);
				System.exit(0);
				return;
			}
			if(state == 1) {
				solve(cnt+1, d);
			}
			for(int i=0; i<n; i++) {
				map[i] = tmp[i].clone();
			}
		}
	}

	//공 옮기기
	private static int moveBall(int bi, int bj, int ri, int rj, int d) {
		boolean b = moveBlue(bi, bj, d);
		boolean r = moveRed(ri, rj, d);
		if(!b) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j] == 'B') {
						bi = i;
						bj = j;
					}
				}
			}
			b = moveBlue(bi, bj, d);
		}
		
		//빨강만 빠짐 : 통과
		if(r && !b) return 0;
		//둘 다 안빠짐: 계속
		if(!r && !b) return 1;
		//실패
		return 2;
	}

	private static boolean moveBlue(int bi, int bj, int d) {
		int ci=bi;
		int cj=bj;
		map[ci][cj] = '.';
		while(true) {
			int ni = ci+di[d];
			int nj = cj+dj[d];
			if(ni>0 && ni<n-1 && nj>0 && nj<m-1) {
				if(map[ni][nj]=='.') {
					ci=ni;
					cj=nj;
					continue;
				}
				if(map[ni][nj]=='O') {
					return true;
				}
			}
			break;
		}
		map[ci][cj] = 'B';
		return false;
	}
	private static boolean moveRed(int ri, int rj, int d) {
		int ci=ri;
		int cj=rj;
		map[ci][cj] = '.';
		while(true) {
			int ni = ci+di[d];
			int nj = cj+dj[d];
			if(ni>0 && ni<n-1 && nj>0 && nj<m-1) {
				if(map[ni][nj]=='.') {
					ci=ni;
					cj=nj;
					continue;
				}
				if(map[ni][nj]=='O') {
					return true;
				}
			}
			break;
		}
		map[ci][cj] = 'R';
		return false;
	}
}
