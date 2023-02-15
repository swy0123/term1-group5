package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 4963 섬의 개수
 */
public class tue_baek_4963 {
	
	static class point{
		int i, j;

		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int w, h, res;
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			res = 0;
			
			if(w == 0 && h == 0) break;
			
			int[][] map = new int[h][w];
			boolean[][] v = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !v[i][j]) {
						v = bfs(map, v, i, j);
//						for (boolean[] o : v) {
//							System.out.println(Arrays.toString(o));
//						}
//						System.out.println();
						res++;
					}
				}
			}
			System.out.println(res);
			
		}
	}
	
	private static boolean[][] bfs(int[][] map, boolean[][] v, int i, int j){
		point p = new point(i, j);
		v[i][j] = true;
		
		Queue<point> q = new LinkedList<>();
		q.add(p);
		
		while(!q.isEmpty()) {
			point cp = q.poll();
			
			for(int ci=-1; ci<=1; ci++) {
				for(int cj=-1; cj<=1; cj++) {
					if(ci == 0 && cj == 0) continue;
					int cr = cp.i+ci;
					int cc = cp.j+cj;
					if(cr>=0 && cr<map.length && cc>=0 && cc<map[0].length) {
						if(map[cr][cc] == 1 && !v[cr][cc]) {
							map[cr][cc] = 0;
							v[cr][cc] = true;
							q.add(new point(cr, cc));
						}
					}
					
				}
			}
			
		}
		return v;
		
	}
	

}
