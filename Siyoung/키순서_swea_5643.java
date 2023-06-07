package se;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_swea_5643 {
	
	static int[][] map;
	static int n, m, inf = 999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			
			
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(map[i], inf);
				map[i][i] = 0;
			}
			
			int from, to;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				from = Integer.parseInt(st.nextToken())-1;
				to = Integer.parseInt(st.nextToken())-1;
				map[from][to] = 1;
//				map[to][from] = 1;
			}
			for (int[] tmp : map) {
				System.out.println(Arrays.toString(tmp));
			}System.out.println();
			for(int k=0; k<n; k++) {
				for(int i=0; i<n; i++) {
					if(i==k) continue;
					for(int j=0; j<n; j++) {
						if(i==j || j==k) continue;
						map[i][j] = Math.max(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}
			
			for (int[] tmp : map) {
				System.out.println(Arrays.toString(tmp));
			}
			
			int res = 0;
			for(int j=0; j<n; j++) {
				int zeroCnt = 0;
				for(int i=0; i<n; i++) {
					if(map[i][j]==0) zeroCnt++;
					if(zeroCnt>1)continue;
				}
				if(zeroCnt==1) res++;
			}
			System.out.println(res);
			
			System.out.println("#"+tc+" "+res);
			
		}
	}
	
}