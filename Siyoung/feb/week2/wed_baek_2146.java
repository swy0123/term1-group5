package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 2146 다리 만들기
 */
public class wed_baek_2146 {

	static class point{
		int i, j, cnt;

		public point(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};
	static int[][] map;
	static int n;
	static int min = Integer.MAX_VALUE;
	static int num = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
//		v = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1) {
					labeling(i, j);
					num++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] > 1) {
					for(int d=0; d<4; d++) {
						int ci = i+di[d];
						int cj = j+dj[d];
						if(ci>=0 && ci<n && cj>=0 && cj<n && map[ci][cj]==0) {
//							System.out.println(i+" "+j +" " + map[i][j]);
							bfs(new boolean[n][n], i, j, map[i][j]);
							break;
						}
					}
				}
			}
		}

//		for (int[] i : map) {
//			System.out.println(Arrays.toString(i));
//		}
		System.out.println(min);
	}
	
	//섬 별로 번호 생성
	private static void labeling(int i, int j) {
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		v[i][j] = true;
		map[i][j] = num;
		
		q.add(new point(i, j, 0));
		
		while(!q.isEmpty()) {
			point p = q.poll();
			
			for(int d=0; d<4; d++) {
				int ci = p.i+di[d];
				int cj = p.j+dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && map[ci][cj]==1 && !v[ci][cj]) {
					v[ci][cj] = true;
					map[ci][cj] = num;
					q.add(new point(ci, cj, 0));
				}
			}
		}
		
	}
	
	//자신과 번호 다른 섬만 인식
	private static void bfs(boolean[][] v, int i, int j, int num) {
		Queue<point> q = new LinkedList<>();
		v[i][j] = true;
		q.add(new point(i, j, 0));
		while(!q.isEmpty()) {			
			point p = q.poll();
			if(p.cnt > min) break;
//			System.out.println(p.i+" "+p.j +" " + map[p.i][p.j]);
			
			for(int d=0; d<4; d++) {
				int ci = p.i + di[d];
				int cj = p.j + dj[d];
				if(ci>=0 && ci<n && cj>=0 && cj<n && !v[ci][cj]) {
//					System.out.println(ci +" " + cj);
					if(map[ci][cj] == 0) {
//						System.out.println("0 : "+map[ci][cj]);
						v[ci][cj] = true;
						q.add(new point(ci, cj, p.cnt+1));
					}
					if(map[ci][cj] > 1 && map[ci][cj]!=num) {
//						System.out.println("n : "+map[ci][cj]);
						v[ci][cj] = true;
//						System.out.println(min);
//						System.out.println(p.cnt);
						min = Math.min(min, p.cnt);
						return;
					}
				}
			}
		}
	}
	
	//섬에서 0인 공간으로 bfs
	

}
