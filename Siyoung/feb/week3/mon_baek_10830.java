package algorithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 10830 행렬 제곱
 */
public class mon_baek_10830 {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		int[][] map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		int[][] test1 = {{199, 290}, {435, 634}};
//		int[][] test2 = {{1, 2}, {3, 4}};
		for (int[] is : merge(map, b)) {
			for (int is2 : is) {
				System.out.print(is2+" ");
			}
			System.out.println();
		}
	}
	
	private static int[][]  merge(int[][] map, long b){
		if(b==1) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] >= 1000) {
						map[i][j]%=1000;
					}
				}
			}
			
			return map;
		}
		
		if(b%2==0) return merge(mul(map, map), b/2);
		else return mul(merge(mul(map, map), b/2), map);
	}
	
	private static int[][] mul(int[][] map1, int map2[][]){
		int[][] tmp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp[i][j] = 0;
				for(int k=0; k<n; k++) {
					 tmp[i][j] += map1[i][k]*map2[k][j];
				}
				if(tmp[i][j] >= 1000) {
					tmp[i][j]%=1000;
				}
			}
		}
		
//		for (int[] is : tmp) {
//			System.out.println(Arrays.toString(is));
//		}
		
		return tmp;
		
	}
	

}
