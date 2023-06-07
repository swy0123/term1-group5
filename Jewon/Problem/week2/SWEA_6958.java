package IM;

import java.util.Scanner;

/**
 * SWEA 6958. 동철이의 프로그래밍 대회 D3
 * 
 * @author SSAFY
 *
 */
public class SWEA_6958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					if (sc.nextInt() == 1) {
						sum++;
					}
				}

				if (sum > max) {
					cnt = 1;
					max = sum;
				} else if (sum == max) {
					cnt++;
				}
			}

			System.out.println("#" + test_case + " " + cnt + " " + max);
		}
	}

}
