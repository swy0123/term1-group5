package se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 소문난칠공주_1941 {
	static class point{
		int i, j, cnt;
		
		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	static char[][] map;
	static int ret;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		ret = 0;
		v = new boolean[25];
		com(0, 0);
		
		System.out.println(ret);
	}
	
	private static void com(int idx, int cnt) {
		if(cnt == 7) {			
			int res=0;
			ArrayList<point> arr = new ArrayList<>();
			for(int i=0; i<25; i++) {
				if(v[i]) {
					int r=i/5;
					int c=i%5;
					arr.add(new point(r, c));
					if(map[r][c]=='S')res++;
				}
			}
			if(res>=4 && check(arr)) {
				ret++;
			}
			return;
		}
		if(idx>24) { 
			return;
		}
		v[idx] = true;
		com(idx+1, cnt+1);
		v[idx] = false;
		com(idx+1, cnt);
	}
	
	private static boolean check(ArrayList<point> arr) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(arr.get(0).i, arr.get(0).j));
		boolean[] v2 = new boolean[7];
		v2[0] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			point p = q.poll();
			for(int d=0; d<4; d++) {
				int ni = p.i+di[d];
				int nj = p.j+dj[d];
				if(ni>=0 && ni<5 && nj>=0 && nj<5) {
					for(int i=1; i<7; i++) {
						if(v2[i]) continue;
						if(ni== arr.get(i).i && nj== arr.get(i).j) {
							v2[i] = true;
							cnt++;
							q.add(new point(ni, nj));
						}
					}
				}
			}
		}
		if(cnt==7) return true;
		else return false;
	}
	
}

