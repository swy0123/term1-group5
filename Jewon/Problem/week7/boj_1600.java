package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_1600 말이 되고픈 원숭이 골드 3
 * 
 * @author elder
 *
 */

public class boj_1600 {

	static int K;
	static int W;
	static int H;
	static int[][] map;

	// 상 하 좌 우
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// 말의 짬푸!
	static int[][] jump = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

	static class Point {
		int row;
		int col;
		int jump;

		public Point(int row, int col, int jump) {
			super();
			this.row = row;
			this.col = col;
			this.jump = jump;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", jump=" + jump + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("boj_1600.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//
		bfs(0, 0);

	}

	private static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(row, col, 0));
		boolean[][][] visit = new boolean[K + 1][H][W];
		visit[0][row][col] = true;
		

		int level = 0;
		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				if (p.row == H - 1 && p.col == W - 1) {
					System.out.println(level);
					return;
				}

				outer : for (int d = 0; d < dir.length; d++) {
					int nr = p.row + dir[d][0];
					int nc = p.col + dir[d][1];

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 1) {
						for (int j = 0; j <= p.jump; j++) {
							if (visit[j][nr][nc])
								continue outer;
						}

						q.offer(new Point(nr, nc, p.jump));
						visit[p.jump][nr][nc] = true;
					}
				}

				if (p.jump < K) {
					outer : for (int j = 0; j < jump.length; j++) {
						int nr = p.row + jump[j][0];
						int nc = p.col + jump[j][1];

						if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visit[p.jump][nr][nc] && map[nr][nc] != 1) {
							for (int v = 0; v <= p.jump; v++) {
								if (visit[v+1][nr][nc])
									continue outer;
							}
							q.offer(new Point(nr, nc, p.jump + 1));
							visit[p.jump + 1][nr][nc] = true;
						}
					}
				}
			}
			level++;
//			System.out.println(level + " : " + Arrays.toString(q.toArray()));
		}

		System.out.println(-1);
	}

}
