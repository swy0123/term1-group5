package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 정수삼각형_1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] arr = new int[n][n];
		arr[0][0] = map[0][0];
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j-1>=0) arr[i][j] = Math.max(arr[i-1][j-1]+map[i][j], arr[i-1][j]+map[i][j]);
				else arr[i][j] = arr[i-1][j]+map[i][j];
			}
		}
		int max = 0;
		for (int is : arr[n-1]) {
			max = Math.max(max, is);
		}
		System.out.println(max);
		
	}
}
