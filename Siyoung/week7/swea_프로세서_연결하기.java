package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_프로세서_연결하기 {

	static class node{
		int i, j;

		public node(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static int n, map[][], min, max;
	static ArrayList<node> arr;
	static boolean isTrue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			n = Integer.parseInt(br.readLine());
			arr = new ArrayList<>();
			map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				L:for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						for(int d=0; d<4; d++) {
							int ci = i+di[d];
							int cj = j+dj[d];
							if(ci<0 || ci>=n || cj<0 || cj>=n) {
								continue L;
							}
						}
						arr.add(new node(i, j));
					}
				}
			}
			
//			System.out.println(arr);
			min = Integer.MAX_VALUE;
			max = 0;
			solve(0, 0);
			System.out.println("#"+test_case+" "+ min);
			
		}
	}
	
	private static void solve(int idx, int cnt) {
		if(idx == arr.size()) {
			if(cnt < max) return;
			if(cnt > max) {
				max = cnt;
				min = Integer.MAX_VALUE;
			}
			int len = 0;
			for (int[] is : map) {
				for (int i : is) {
					if(i==-1) len++;
				}
			}
			min = Math.min(min, len);
			return;
		}
		
//		if(!isTrue) return;
		
		for(int d=0; d<4; d++) {
			int ci = arr.get(idx).i;
			int cj = arr.get(idx).j;
			if(check(ci, cj, d)) {
				fill(ci, cj, d);
				solve(idx+1, cnt+1);
				unfill(ci, cj, d);
			}
			else {
				solve(idx+1, cnt);
			}
		}
		
	}
	
	private static boolean check(int i, int j, int dir) {
		int ci = i+di[dir];
		int cj = j+dj[dir];
		while((ci>=0 && ci<n && cj>=0 && cj<n)) {
			if(map[ci][cj] != 0) return false;
			ci += di[dir];
			cj += dj[dir];
		}
		return true;
	}
	
	private static void fill(int i, int j, int dir) {
		int ci = i+di[dir];
		int cj = j+dj[dir];
		while((ci>=0 && ci<n && cj>=0 && cj<n)) {
			map[ci][cj] = -1;
			ci += di[dir];
			cj += dj[dir];
		}
	}

	private static void unfill(int i, int j, int dir) {
		int ci = i+di[dir];
		int cj = j+dj[dir];
		while((ci>=0 && ci<n && cj>=0 && cj<n)) {
			map[ci][cj] = 0;
			ci += di[dir];
			cj += dj[dir];
		}
	}
}

