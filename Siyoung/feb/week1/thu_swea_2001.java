package algorithm.week1.thu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * swea 2001. 파리 퇴치
 */
public class thu_swea_2001 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T;
		T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int sum = 0;
			int cur;
			for(int i=0; i<n-m+1; i++) {
				for(int j=0; j<n-m+1; j++) {
					cur = 0;
					for(int ci=i; ci<i+m; ci++) {
						for(int cj=j; cj<j+m; cj++) {
							cur += map[ci][cj];
						}
					}
					sum = Math.max(sum, cur);
				}
			}
			
			System.out.println("#"+test_case +" "+sum);
			
			
		}
	}

}
