package algorithm.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 17406 배열돌리기4
 */
public class baek_17406 {
	static int k;
	static int[][] order;
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		order = new int[k][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				order[i][j] = Integer.parseInt(st.nextToken());
			}
//			map = rotate(map, order[i][0]-1, order[i][1]-1, order[i][2]);
//			System.out.println();
//			for (int[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
		}
//		for (int[] is : order) {
//			System.out.println(Arrays.toString(is));
//		}
		
		com(map, new boolean[k], new int[k], 0);
		System.out.println(res);

	}
	
	private static void com(int[][] map, boolean[] v, int[] set, int cnt) {
		if(cnt == k) {
//			System.out.println(Arrays.toString(set));
			int sum=0;
			int min = Integer.MAX_VALUE;
			for (int i : set) {
				map = rotate(map, order[i][0]-1, order[i][1]-1, order[i][2]);
			}
			for (int[] i : map) {
				sum = 0;
				for (int j : i) {
					sum+=j;
				}
				min = Math.min(min,  sum);
//				System.out.println(min);
			
			}
			res = Math.min(res,  min);
			return;
		}
		
		for(int i=0; i<v.length; i++) {
			if(!v[i]) {
				v[i] = true;
				set[cnt] = i;
				com(map, v, set, cnt+1);
				v[i] = false;
			}
		}
		
	}
	
	
	private static int[][] rotate(int[][] map, int r, int c, int s){
		
		for(int t = 0; t<s; t++) {
			int tmp = map[r-s+t][c+s-t];
			//윗변 ->
			for(int i=c+s-t; i>c-s+t; i--) {
				map[r-s+t][i] = map[r-s+t][i-1];
			}
			//왼변 ^
			for(int i=r-s+t; i<r+s-t; i++) {
				map[i][c-s+t] = map[i+1][c-s+t];
			}
			//아래 <-
			for(int i=c-s+t; i<c+s-t; i++) {
				map[r+s-t][i] = map[r+s-t][i+1];
			}
			//오른 v
			for(int i=r+s-t; i>r-s+t; i--) {
				map[i][c+s-t] = map[i-1][c+s-t];
			}
			map[r-s+t+1][c+s-t] = tmp;
		}
		
		
		return map;
		
	}
	

}
