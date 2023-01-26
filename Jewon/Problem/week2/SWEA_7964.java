package week2;

import java.util.Scanner;

/**
 * SWEA 7964. 부먹왕국의 차원 관문 D3
 * 
 * @author elder
 *
 */
public class SWEA_7964 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int city = sc.nextInt();
			int dist = sc.nextInt();
			int stack = 0;
			int cnt = 0;

			for (int i = 0; i < city; i++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					stack++;
				} else {
					stack = 0;
				}

				if (stack == dist) {
					stack = 0;
					cnt++;
				}
			}
			System.out.println("#" + test_case + " " + cnt);

		}
	}

}
