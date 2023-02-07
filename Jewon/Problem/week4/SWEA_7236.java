package week4;

import java.util.Scanner;

/**
 * 
 * SWEA_7236 저수지의 물의 총 깊이 구하기 D3
 * 
 * @author elder
 *
 */
public class SWEA_7236 {
	static int[][] delta = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int W = 0;

			char[][] map = new char[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[i][j] == 'W') {
						// 깊이 탐색
						int cnt = 0;
						for (int idx = 0; idx < delta.length; idx++) {
							if (i + delta[idx][0] >= 0 && i + delta[idx][0] < N && j + delta[idx][1] >= 0
									&& j + delta[idx][1] < N) {
								if (map[i + delta[idx][0]][j + delta[idx][1]] == 'W') {
									cnt++;
								}
							}
						}

						if (cnt == 0)
							cnt = 1;

						W = Math.max(W, cnt);
					}
				}
			}

			System.out.println("#" + test_case + " " + W);
		}
	}

}
