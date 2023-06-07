package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 외판원순회_2098 {
	static int n, min, inf=Integer.MAX_VALUE/100;
	static int[][] dist, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		dist = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[1<<n][n];
		for(int i=0; i<1<<n; i++) {
			Arrays.fill(dp[i], -1);
		}
		
//		for (int[] is : dp) {
//			System.out.println(Arrays.toString(is));
//		}
		
		min = tsp(1, 0);
		System.out.println(min);
	}
	
	private static int tsp(int v, int city) {
		if(v == (1<<n)-1) {
			if(dist[city][0] == 0) return inf;
			return dist[city][0];
		}
		
		if(dp[v][city]!=-1) {
			return dp[v][city];
		}
		dp[v][city] = inf;
		for(int i=0; i<n; i++) {
			if((v & (1<<i))!=0) continue;
			if(dist[city][i]==0)continue;
			int res = tsp(v|(1<<i), i) + dist[city][i];
			dp[v][city] = Math.min(res, dp[v][city]);
		}
		
		return dp[v][city];
	}
}
