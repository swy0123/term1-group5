package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_1941_2 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static boolean[][] visit;
	static int Ans = 0;

	static class Point {
		int row, col;

		public Point() {
			super();
		}

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

	static Point temp_point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		visit = new boolean[5][5];
		temp_point = new Point();
		for (int i = 0; i < 5; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = sb.charAt(j);
			}
		}

		dfs(0, 0, 0);

		System.out.println(Ans);
	}

	private static void dfs(int start, int depth, int S) {
		if (depth - S >= 4) {
			return;
		}

		if (depth == 7) {
			if (S >= 4 && check()) {
				Ans++;
			}
			return;
		}

		for (int i = start; i < 5 * 5; i++) {
			int row = i / 5;
			int col = i % 5;

			if (!visit[row][col]) {
				visit[row][col] = true;
				temp_point.row = row;
				temp_point.col = col;
				if (map[row][col] == 'S') {
					dfs(i + 1, depth + 1, S + 1);
				} else {
					dfs(i + 1, depth + 1, S);
				}
				visit[row][col] = false;
			}

		}

	}

	private static boolean check() {
		int cnt = 1;
		boolean[][] visit_temp = new boolean[5][5];
		visit_temp[temp_point.row][temp_point.col] = true;

		Queue<Point> q = new LinkedList<Point>();
		q.offer(temp_point);

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dir.length; i++) {
				int nr = p.row + dir[i][0];
				int nc = p.col + dir[i][1];
				if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visit_temp[nr][nc] && visit[nr][nc]) {
					cnt++;
					visit_temp[nr][nc] = true;
					q.offer(new Point(nr, nc));
				}
			}
		}

		if (cnt == 7) {
			return true;
		} else {
			return false;
		}
	}

}
