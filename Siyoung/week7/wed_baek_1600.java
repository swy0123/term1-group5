package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 1600 말이 되고픈 원숭이
 */
public class wed_baek_1600 {
	
	static class point{
		int i, j, cnt, res;

		//cnt : 말 이동 가능 횟수, res : 현재 이동 횟수
		public point(int i, int j, int cnt, int res) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.res = res;
		}
		
	}
	
	static int[] hi = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hj = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	
	
	static int w, h, k, res, map[][];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new int[h][w];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//이동거리, 도착여부
		res = 0;
		flag = false;
		bfs();
		if(flag) System.out.println(res);
		else System.out.println(-1);

	}
	
	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		boolean[][][] v = new boolean[h][w][k+1];
		q.add(new point(0, 0, 0, 0));
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.i == h-1 && p.j == w-1) {
				flag = true;
				res = p.res;
				break;
			}
			
			if(p.cnt<k) {
				L:for(int d=0; d<8; d++) {
					int ci = p.i+hi[d];
					int cj = p.j+hj[d];
					if(ci>=0 && ci<h && cj>=0 && cj<w && map[ci][cj]==0) {
						for(int i=0; i<=p.cnt; i++) {
							if(v[ci][cj][p.cnt+1]) continue L;
						}
						q.add(new point(ci, cj, p.cnt+1, p.res+1));
						v[ci][cj][p.cnt+1] = true;
					}
				}
			}
			L:for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<h && cj>=0 && cj<w && map[ci][cj]==0) {
					for(int i=0; i<=p.cnt; i++) {
						if(v[ci][cj][p.cnt]) continue L;
					}
					q.add(new point(ci, cj, p.cnt, p.res+1));
					v[ci][cj][p.cnt] = true;
				}
			}
			
		}
	}
}
