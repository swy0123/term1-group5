package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_2178 미로 탐색
 * 
 * @author SSAFY
 *
 */
public class boj_2178 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = sb.charAt(j) - '0';
			}
		}

		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0));
		visited[0][0] = true;

		int level = 1;
		int size = 0;
		outer: while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				if (p.row == N - 1 && p.col == M - 1) {
					break outer;
				}

				for (int d = 0; d < dir.length; d++) {
					int nr = p.row + dir[d][0];
					int nc = p.col + dir[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (!visited[nr][nc] && map[nr][nc] != 0) {
							q.offer(new Point(nr, nc));
							visited[nr][nc] = true;
						}
					}
				}
			}
			level++;
		}

		System.out.println(level);
	}

}
