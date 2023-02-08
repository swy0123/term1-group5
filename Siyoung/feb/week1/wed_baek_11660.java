package algorithm.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 11659 구간 합 구하기 5
 */
public class wed_baek_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x1, y1, x2, y2;
		int[][] map = new int[n][n];
		int[][] sum = new int[n+1][n+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum[0][0] = 0;
		for(int i=1; i<n+1; i++) {
			sum[i][0] = sum[i-1][0] + map[i-1][0];
			sum[0][i] = sum[0][i-1] + map[0][i-1];
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i-1][j-1];
			}
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]);
		}
		
	}

}


