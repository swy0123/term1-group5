package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * 2115. [모의 SW 역량테스트] 벌꿀채취
 * 
 * @author elder
 *
 */
public class swea_2115 {

	static int N, M, C;
	static int[][] map;
	static int[][] max_map;
	static int max_ans = Integer.MIN_VALUE;
	static int temp_max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			max_ans = Integer.MIN_VALUE;
			map = new int[N][N];
			max_map = new int[N][N - M + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// max_map 만들기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					temp_max = 0;
					find_max(i, j, 0, C, 0);

					max_map[i][j] = temp_max;

				}
			}

			// 4중 포문
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					//
					for (int ii = i + 1; ii < N; ii++) {
						for (int jj = 0; jj < N - M + 1; jj++) {
							max_ans = Math.max(max_ans, max_map[i][j] + max_map[ii][jj]);
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + max_ans);

		}
	}

	private static void find_max(int row, int col, int index, int bottle, int value) {
		if (index == M) {
			temp_max = Math.max(temp_max, value);
			return;
		}

		if (bottle - map[row][col + index] >= 0) {
			// row, col , 남은 용량, 품질
			find_max(row, col, index + 1, bottle - map[row][col + index],
					value + map[row][col + index] * map[row][col + index]);
		}

		find_max(row, col, index + 1, bottle, value);
	}

}
