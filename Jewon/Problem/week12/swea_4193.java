package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_4193 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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

	static int[][] map;
	static int N;
	static Point start, end;
	static int Ans = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			Ans = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			start = new Point(a, b);

			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			end = new Point(c, d);

			bfs(start, end);
			System.out.println("#" + test_case + " " + Ans);
		}
	}

	private static void bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(start);
		boolean[][] visit = new boolean[N][N];
		visit[start.row][start.col] = true;
		int time = 0;
		outer: while (!q.isEmpty()) {
			int size = q.size();
			boolean flag = true;

			if ((time + 1) % 3 == 0) {
				flag = false;
			}

			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				if (p.row == end.row && p.col == end.col) {
					Ans = time;
					break outer;
				}

				for (int j = 0; j < dir.length; j++) {
					int nr = p.row + dir[j][0];
					int nc = p.col + dir[j][1];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) {
						if (map[nr][nc] == 2 && flag) {
							// 소용돌이 인가.
							q.offer(p);
						} else {
							// 물인가
							if (!visit[nr][nc]) {
								visit[nr][nc] = true;
								q.offer(new Point(nr, nc));
							}
						}
					}
				}
//				System.out.println(Arrays.toString(q.toArray()));
			}

			time++;

		}

	}

}
