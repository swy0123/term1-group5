package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 백준 1051 숫자 정사각형
 */
public class sat_baek_1051 {

	static int max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
//		for (int[] is : map) {
//			System.out.println(Arrays.toString(is));
//		}
		
		int tmp, lim;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				tmp = map[i][j];
				lim = Math.min(n-i, m-j);
				for(int t=0; t<lim; t++) {
					if(tmp==map[i+t][j] && tmp==map[i][j+t] && tmp==map[i+t][j+t]) {
						max = Math.max((t+1)*(t+1), max);
					}
				}
			}
		}
		System.out.println(max);
		
	}

}
