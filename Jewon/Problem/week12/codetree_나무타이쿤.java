package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * codetree_나무타이쿤
 * 
 * @author elder
 *
 */
public class codetree_나무타이쿤 {
	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}

	}

	static int[][] dir = { {}, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int[][] cross_dir = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
	static int N, M;
	static int[][] map;
	static List<Point> Nutrients;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 초기 영양제 설정
		Nutrients = new ArrayList<>();
		Nutrients.add(new Point(N - 1, 0));
		Nutrients.add(new Point(N - 2, 0));
		Nutrients.add(new Point(N - 1, 1));
		Nutrients.add(new Point(N - 2, 1));

		for (int year = 0; year < M; year++) {
			st = new StringTokenizer(br.readLine());
			int n_d = Integer.parseInt(st.nextToken());
			int n_p = Integer.parseInt(st.nextToken());

			// 영양제 위치 이동
			for (int i = 0; i < Nutrients.size(); i++) {
				Nutrients.get(i).row += (dir[n_d][0] * n_p);
				Nutrients.get(i).row %= N;
				if (Nutrients.get(i).row < 0) {
					Nutrients.get(i).row += N;
					Nutrients.get(i).row %= N;
				}

				Nutrients.get(i).col += (dir[n_d][1] * n_p);
				Nutrients.get(i).col %= N;
				if (Nutrients.get(i).col < 0) {
					Nutrients.get(i).col += N;
					Nutrients.get(i).col %= N;
				}
			}

//			System.out.println(Nutrients);
			// 1 증가
			for (int i = 0; i < Nutrients.size(); i++) {
				map[Nutrients.get(i).row][Nutrients.get(i).col]++;
			}

			// 대각선 증가
			for (int i = 0; i < Nutrients.size(); i++) {
				int row = Nutrients.get(i).row;
				int col = Nutrients.get(i).col;

				int cnt = 0;
				for (int ii = 0; ii < cross_dir.length; ii++) {
					int nr = row + cross_dir[ii][0];
					int nc = col + cross_dir[ii][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] >= 1) {
						cnt++;
					}
				}

				map[row][col] += cnt;
			}

			// 높이 자르기
			List<Point> Nutrients_temp = new ArrayList<>();
//			Nutrients = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 2 && check(i, j)) {
						map[i][j] -= 2;
						Nutrients_temp.add(new Point(i, j));
					}
				}
			}
			Nutrients = Nutrients_temp;
//			print();
		}
		int sum = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
//		System.out.println(Nutrients);
		System.out.println(sum);
	}

	private static boolean check(int row, int col) {
		for (int i = 0; i < Nutrients.size(); i++) {
			if (Nutrients.get(i).row == row && Nutrients.get(i).col == col) {
				return false;
			}
		}
		return true;
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
