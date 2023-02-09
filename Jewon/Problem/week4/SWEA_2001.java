package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * SWEA_2001 파리 퇴치 D2
 * 
 * @author elder
 *
 */
public class SWEA_2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int max = Integer.MIN_VALUE;

			int[][] arr = new int[N][N];

			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < arr.length - M + 1; i++) {
				for (int j = 0; j < arr.length - M + 1; j++) {
					int sum = 0;
					for (int ii = i; ii < i + M; ii++) {
						for (int jj = j; jj < j + M; jj++) {
							sum += arr[ii][jj];
						}
					}
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

}
