package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리_1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n+1][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
		int[][] arr = new int[n+1][3];
		arr[0][0] = map[0][0];
		arr[0][1] = map[0][1];
		arr[0][2] = map[0][2];
		for(int i=1; i<=n; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = Math.min(arr[i-1][(j+1)%3]+map[i][j], arr[i-1][(j+2)%3]+map[i][j]);
			}
		}
//		for (int[] is : arr) {
//			System.out.println(Arrays.toString(is));
//		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			min = Math.min(min, arr[n][i]);
		}
		System.out.println(min);
	}
}
