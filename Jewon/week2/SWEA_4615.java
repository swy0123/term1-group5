package week2;

import java.util.Scanner;

// SWEA 4615. 재미있는 오셀로 게임
public class SWEA_4615 {
	// 1 2 3
	// 4 0 5
	// 6 7 8

	static int[][] delta = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 0 빈 1 흑 2 백
			int[][] map = new int[N][N];
			map[N / 2][N / 2] = 2;
			map[N / 2 - 1][N / 2 - 1] = 2;
			map[N / 2][N / 2 - 1] = 1;
			map[N / 2 - 1][N / 2] = 1;

			int[] colors = { 0, 2, 2 };

			int row;
			int col;
			int color;
			int M = sc.nextInt();

			for (int i = 0; i < M; i++) {
				row = sc.nextInt() - 1;
				col = sc.nextInt() - 1;
				color = sc.nextInt();
				map[row][col] = color;
				colors[color]++;

				// 팔방 탐색
				for (int d = 0; d < delta.length; d++) {
					int idx = 1;

					// 좌표가 안에 있는가?
					while (row + idx * delta[d][0] >= 0 && row + idx * delta[d][0] < N && col + idx * delta[d][1] >= 0
							&& col + idx * delta[d][1] < N
							&& (map[row + idx * delta[d][0]][col + idx * delta[d][1]] != 0)) {

						// 놓은돌과 같은색이면
						if (map[row + idx * delta[d][0]][col + idx * delta[d][1]] == color) {

							// 상대 돌 바꾸기
							for (int j = 1; j < idx; j++) {
								colors[map[row + j * delta[d][0]][col + j * delta[d][1]]]--;
								map[row + j * delta[d][0]][col + j * delta[d][1]] = color;
								colors[color]++;
							}
							break;
						}
						idx++;
					}
				}
			}

			System.out.println("#" + test_case + " " + colors[1] + " " + colors[2]);
		}
	}

}
