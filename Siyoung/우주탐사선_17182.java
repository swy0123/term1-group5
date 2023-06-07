package se;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 우주탐사선_17182 {
	static int n, s, res, map[][], inf=99999999;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(i==k) continue;
				for(int j=0; j<n; j++) {
					if(i==j || k==j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		res = Integer.MAX_VALUE;
		boolean[] v = new boolean[n];
		v[s] = true;
		solve(s, 0, 0, v);
		System.out.println(res);
	}
	
	private static void solve(int start, int depth, int dist, boolean[] v) {
		if(depth == n-1) {
			res = Math.min(res, dist);
//			System.out.println(res +" "+dist);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!v[i]) {
				v[i] = true;
				solve(i, depth+1, dist+map[start][i], v);
				v[i] = false;
			}
		}
	}
}
