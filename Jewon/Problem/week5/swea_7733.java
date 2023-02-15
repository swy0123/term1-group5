package pkg02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * swea_7733 치즈 도둑 D4
 * 
 * @author SSAFY
 *
 */

public class swea_7733 {
	static int N;
	static int[][] map;
	static boolean[][] visit;

	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static public class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int maxScore = 0;
			int ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxScore = Math.max(maxScore, map[i][j]);
				}
			}

			//
			for (int score = 1; score <= maxScore; score++) {
				visit = new boolean[N][N];
				int cnt = 0;
				// 전체 탐색
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 방문 하지 않고 먹었지 않은것이면
						if (visit[i][j] == false && map[i][j] > score) {
							bfs(i, j, score);
							cnt++;
						}
					}
				}
				ans = Math.max(ans, cnt);
			}

			System.out.println("#" + test_case + " " + ans);

		}
	}

	private static void bfs(int row, int col, int score) {
		Queue<Point> q = new LinkedList<Point>();

		q.offer(new Point(row, col));
		visit[row][col] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dir.length; i++) {
				int nr = p.x + dir[i][0];
				int nc = p.y + dir[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > score && visit[nr][nc] == false) {
					q.offer(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}

	}

}
