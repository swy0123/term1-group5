package algorithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 2667 단지번호붙이기
 */
public class tue_baek_2667 {
	static int[][] map;
	static boolean[][] v;
	static int n;
	
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Point {
		int r, c, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n][n];
		ArrayList<Integer> home = new ArrayList<>();
		String str;
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !v[i][j]) {
					home.add(bfs(i, j));
				}
			}
		}
		
		System.out.println(home.size());
		int[] arr = new int[home.size()];
		for(int i=0; i<home.size(); i++) {
			arr[i] = home.get(i);
		}
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
	
	
	private static int bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i, j));
		int cnt = 0;
		v[i][j] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			cnt++;
//			System.out.println(p.r +" "+p.c+" "+cnt);
			
			for(int d=0; d<4; d++) {
				int cr = p.r+dr[d];
				int cc = p.c+dc[d];
				if (cr >= 0 && cr < n && cc >= 0 && cc < n && !v[cr][cc] && map[cr][cc] == 1) {
					v[cr][cc] = true;
					
					q.add(new Point(cr, cc));
				}
			}
		}
//		System.out.println();
		return cnt;
	}
	

}
