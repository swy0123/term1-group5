package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int[][] map;

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

	static List<Point> processors;
	static int max_cores = Integer.MIN_VALUE;
	static int min_lines = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			max_cores = Integer.MIN_VALUE;
			min_lines = Integer.MAX_VALUE;
			processors = new ArrayList<>();
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						processors.add(new Point(i, j));
					}
				}
			}
			dfs(0, 0);
			if (min_lines == Integer.MAX_VALUE) {
				System.out.println("#" + test_case + " " + 0);
			} else {
				System.out.println("#" + test_case + " " + min_lines);
			}
		}
	}

	private static void dfs(int index, int cores) {
		if (index == processors.size()) {
			if (cores > max_cores) {
				max_cores = cores;
				min_lines = line_size();
			} else if (cores == max_cores) {
				min_lines = Math.min(min_lines, line_size());
			}

			return;
		}

		// 남은 인덱스 수가
		// processors.size() - index
		if (max_cores > processors.size() - index + cores) {
			return;
		}

		dfs(index + 1, cores);

		int row = processors.get(index).row;
		int col = processors.get(index).col;

		for (int i = 0; i < dir.length; i++) {
			// 한칸씩 그림
			int temp = 1;
			int nr;
			int nc;

			// 전선을 끝으로 보냄
			while (true) {
				nr = row + dir[i][0] * temp;
				nc = col + dir[i][1] * temp;

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] == 0) {
						map[nr][nc] = 2;
						temp++;
					} else if (map[nr][nc] == 1 || map[nr][nc] == 2) {
						break;
					} else if (nr == N - 1 || nc == N - 1 || nr == 0 || nc == 0) {
						dfs(index + 1, cores + 1);
						break;
					}
				}

				if (nr == N - 1 || nc == N - 1 || nr == 0 || nc == 0) {
					dfs(index + 1, cores + 1);
					break;
				}

			}

			// 전선을 다시 감음
			while (true) {
				temp--;
				nr = row + dir[i][0] * temp;
				nc = col + dir[i][1] * temp;

				if (map[nr][nc] == 2) {
					map[nr][nc] = 0;
				}

				if (map[nr][nc] == 1) {
					break;
				}
			}
		}

	}

	private static int line_size() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) {
					sum++;
				}
			}
		}

		return sum;
	}

}
