package algorithm.week3.wed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * swea 5644. [모의 SW 역량테스트] 무선 충전
 */

public class wed_swea_5644 {
	static class point{
		int i, j, ap, cnt;
		public point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		public point(int i, int j, int ap, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.ap = ap;
			this.cnt = cnt;
		}
		
	}
	static int[] di = {0, -1, 0, 1 , 0};
	static int[] dj = {0, 0, 1, 0 , -1};
	
	static int[][][] map;
	static int m, a, max;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			
			int[] arr1 = new int[m];
			int[] arr2 = new int[m];
			int[][] ap = new int[a][4];
			map = new int[10][10][a];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<a; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					ap[i][j] = Integer.parseInt(st.nextToken());
					if(j==0 || j==1) ap[i][j]-=1;
				}
			}
			
			for(int i=0; i<a; i++) {
				fill(ap[i], i);
			}
//			for (int[][] is : map) {
//				for (int[] is2 : is) {
//					System.out.print(Arrays.toString(is2));
//				}
//				System.out.println();
//			}

			max = 0;
			maxValue(arr1, arr2);
			
			System.out.println("#"+test_case+" "+ max);
			
			
		}
	}
	
	private static void maxValue(int[] arr1, int[] arr2) {
		int[] pos = new int[2];
		
		point p1 = new point(0, 0);
		point p2 = new point(9, 9);
		
		for(int i=0; i<=m; i++) {
			int[] cur1 = new int[a];
			int[] cur2 = new int[a];
			
			for(int c=0; c<a; c++) {
				cur1[c] = map[p1.i][p1.j][c];
			}
			for(int c=0; c<a; c++) {
				cur2[c] = map[p2.i][p2.j][c];
			}
			
			max += cal(cur1, cur2);
			
			if(i==m) break;
			
			p1 = new point(p1.i+di[arr1[i]], p1.j+dj[arr1[i]]);
			p2 = new point(p2.i+di[arr2[i]], p2.j+dj[arr2[i]]);
			
		}
		
	}
	
	private static int cal(int[] arr1, int[] arr2) {
		int res = 0;
		for(int i=0; i<a; i++) {
			for(int j=0; j<a; j++) {
				if(i == j && arr1[i]>0) {
					res = Math.max(res, arr1[i]);
					continue;
				}
				res = Math.max(res, arr1[i]+arr2[j]);
			}
		}
//		System.out.println(res);
		return res;		
	}
	
	
	private static void fill(int[] list, int num) {
		Queue<point> q = new LinkedList<>();
		boolean[][] v = new boolean[10][10];
		q.add(new point(list[1], list[0], num, list[2]));
		map[list[1]][list[0]][num] = list[3];
		v[list[1]][list[0]] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.cnt<=0) continue;
			
			for(int d=1; d<5; d++) {
				int ci = p.i + di[d];
				int cj = p.j + dj[d];
				if(ci>=0 && ci<10 && cj>=0 && cj<10 && !v[ci][cj]) {
					map[ci][cj][num] = list[3];
					v[ci][cj] = true;
					q.add(new point(ci, cj, num, p.cnt-1));
				}
			}
			
		}
	}

}
