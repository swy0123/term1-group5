package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다리놓기_1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(m>n) {
				int tmp = n;
				n = m;
				m = tmp; 
			}
			if(n/2<m) {
				m = n-m;
			}
			
			long[][] map = new long[n+1][n+1];
			map[0][0] = 1;
			for(int i=1; i<=n; i++) {
				for(int j=0; j<=n; j++) {
					if(j>0) map[i][j] = map[i-1][j]+map[i-1][j-1];
					else map[i][j] = map[i-1][j];
				}
			}
//			for (long[] is : map) {
//				System.out.println(Arrays.toString(is));
//			}
			
			sb.append(map[n][m]+"\n");
		}
		System.out.println(sb);
	}
}
