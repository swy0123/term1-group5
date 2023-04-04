package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9205 {
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

	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		outer : for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			List<Point> list = new ArrayList<>();

			int[][] dist = new int[N + 2][N + 2];

			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], INF);
			}

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			// init
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist.length; j++) {
					if (i == j) {
						continue;
					}
					Point start = list.get(i);
					Point end = list.get(j);
					dist[i][j] = Math.abs(start.row - end.row) + Math.abs(start.col - end.col);
				}
			}

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					for (int k = 0; k < N + 2; k++) {
						if (j == k || i == j || i == k)
							continue;

						dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
					}
				}
			}
			
//			for (int i = 0; i < dist.length; i++) {
//				System.out.println(Arrays.toString(dist[i]));
//			}

			// bfs
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(0);
			boolean[][] visit = new boolean[N + 2][N + 2];
//			visit[0] = true;

			while (!q.isEmpty()) {
				int me = q.poll();

				if (me == N + 1) {
					System.out.println("happy");
					continue outer;
				}

				for (int i = 1; i < N + 2; i++) {
					if (me == i) {
						continue;
					}

					if (!visit[me][i] && dist[me][i] <= 50 * 20) {
						visit[me][i] = true;
						visit[i][me] = true;

						q.offer(i);
					}
				}
			}

			System.out.println("sad");
		}
	}

}
