package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static class node{
		int i, j;
		public node(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	static int n, map[][], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[n][n];
//		dp[0][0] = 1;
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				int ni = i+1;
//				int nj = j+1;
//				if(ni<n) {
//					if(map[ni][j]>map[i][j]) dp[ni][j] = Math.max(dp[ni][j], dp[i][j]+1);
//					else dp[ni][j] = dp[i][j];
//				}
//				if(nj<n) {
//					if(map[i][nj]>map[i][j]) dp[i][nj] = Math.max(dp[i][nj], dp[i][j]+1);
//					else dp[i][nj] = dp[i][j];
//				}
//			}
//		}
//		for (int[] is : dp) {
//			System.out.println(Arrays.toString(is));
//		}
		
		System.out.println(dp[n-1][n-1]);
	}
	
	private static int solve(node cn) {
		if(cn.i==0 && cn.j==0) {
			return 1;
		}
		
		
		return 0;
		
	}
}
