package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_2206 벽 부수고 이동하기 골드 3
 * 
 * @author SSAFY
 *
 */
public class boj_2206 {
	static int N;
	static int M;
	static int[][] map;

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Point {
		int row;
		int col;
		int status;

		public Point(int row, int col, int status) {
			super();
			this.row = row;
			this.col = col;
			this.status = status;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", status=" + status + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = sb.charAt(j) - '0';
			}
		}

		int ans = bfs();

		System.out.println(ans);
	}

	private static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][][] visit = new boolean[2][N][M];

		q.offer(new Point(0, 0, 1));
		visit[0][0][0] = visit[1][0][0] = true;

		boolean flag = false;

		int level = 1;
		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();
//			System.out.println(Arrays.toString(q.toArray()));
			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				if (p.row == N - 1 && p.col == M - 1) {
					return level;
				}

				for (int j = 0; j < dir.length; j++) {
					int nr = p.row + dir[j][0];
					int nc = p.col + dir[j][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

						if (p.status == 1 && visit[0][nr][nc] == false) {
							
							if (map[nr][nc] == 1) {
								q.offer(new Point(nr, nc, 0));
								flag = true;
							}

							if (map[nr][nc] == 0) {
								q.offer(new Point(nr, nc, 1));
								visit[0][nr][nc] = true;
								
								if (!flag) {
									visit[1][nr][nc] = true;
								}
							}
						}

						if (p.status == 0 && visit[1][nr][nc] == false) {

							if (map[nr][nc] == 0) {
								q.offer(new Point(nr, nc, p.status));
								visit[1][nr][nc] = true;
							}
						}

					}
				}

			}
			level++;
		}

		return -1;
	}

}
