package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 19238 스타트 택시
 */
public class fri_baek_19238 {

	static class point{
		int i, j, dist;
		long f;
		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public point(int i, int j, int dist, long f) {
			super();
			this.i = i;
			this.j = j;
			this.dist = dist;
			this.f = f;
			
		}
	}
	
	static int[] di = {-1, 0, 0, 1};
	static int[] dj = {0, -1, 1, 0};
	
	static int n, m, map[][][];
	static long fuel;
	static point[] start;
	static point[] end;
	static boolean flag = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		
		map = new int[n][n][3];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		int si, sj;
		st = new StringTokenizer(br.readLine());
		si = Integer.parseInt(st.nextToken())-1;
		sj = Integer.parseInt(st.nextToken())-1;
		
		start = new point[m+3];
		end = new point[m+3];
		
		int a, b, c, d;
		int idx=2;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			d = Integer.parseInt(st.nextToken())-1;
			start[idx] = new point(a, b);
			end[idx] = new point(c, d);
			map[a][b][1] = idx;
			map[c][d][2] = -idx;
			idx++;
		}
		
		int cnt = 0;
		while(cnt < m) {
			flag = false;
			int tmp = moveToStart(si, sj);
			if(tmp>1) {
				moveToEnd(tmp);
				si = end[tmp].i;
				sj = end[tmp].j;
			}
			if(!flag) break;
			cnt++;
		}
		

		if(!flag) System.out.println(-1);
		else System.out.println(fuel);
	}
	
	private static int moveToEnd(int idx) {
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		q.add(new point(start[idx].i, start[idx].j, 0, fuel));
		L:while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci=p.i+di[d];
				int cj=p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj] && map[ci][cj][0] != 1) {
					int dist = p.dist+1;
					long cf = p.f;
					flag = false;
					//목적지에 도착
					if(ci==end[idx].i && cj==end[idx].j) {
						if(fuel < dist) continue;
						fuel = cf+dist;
						map[ci][cj][2] = 0;
						flag = true;
						v[ci][cj] = true;
						break L;
					}
					if(dist>=cf) {
						continue;
					}
					v[ci][cj] = true;
					q.add(new point(ci, cj, dist, cf));
				}
			}
		}
		
		return idx;
	}
	
	
	private static int moveToStart(int si, int sj) {
		if(map[si][sj][1]>1) {
			int num = map[si][sj][1];
			map[si][sj][1] = 0;
			return num;
		}
		ArrayList<point> tmp = new ArrayList<>();
		int lim = 0;
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		q.add(new point(si, sj, 0, fuel));
		v[si][sj] = true;
		int idx = 0;
		L:while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci=p.i+di[d];
				int cj=p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj] && map[ci][cj][0] != 1) {
					int dist = p.dist+1;
					long cf = p.f;
					flag = false;
					//승객에게 도착

					if(lim>0 && dist>lim) continue;
					if(map[ci][cj][1] > 1) {
						fuel = cf-dist;
						tmp.add(new point(ci, cj, dist, cf));
						v[ci][cj] = true;
						flag = true;
						lim = dist;
						continue;
					}
					if(dist>=cf) {
						continue;
					}
					v[ci][cj] = true;
					q.add(new point(ci, cj, dist, cf));
				}
			}
		}
		int mi = Integer.MAX_VALUE, mj = Integer.MAX_VALUE;
		for (int k=0; k<tmp.size(); k++) {
			if(tmp.get(k).i==mi) {
				if(tmp.get(k).j<mj) {
					mj = tmp.get(k).j;
				}
			}
			if(tmp.get(k).i<mi) {
				mi = tmp.get(k).i;
				mj = tmp.get(k).j;
			}
			
		}
		if(mi>=n || mj>=n) return 0;
		int res = map[mi][mj][1]; 
		map[mi][mj][1] = 0;
		return res;
	}

}
