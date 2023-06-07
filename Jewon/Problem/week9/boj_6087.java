import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6087 { 
	static Point startPoint, endPoint;
	static int W, H;
	static int curve_Ans = Integer.MAX_VALUE;
	static char[][] map;
	static int[][][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] next_dir = { { 0, 2, 3 }, { 1, 2, 3 }, { 2, 0, 1 }, { 3, 0, 1 } };

	static class Point implements Comparable<Point> {
		int row;
		int col;
		int dir;
		int curve;

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", dir=" + dir + ", curve=" + curve + "]";
		}

		public Point(int row, int col, int dir, int curve) {
			super();
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.curve = curve;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.curve, o.curve);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new char[H][W];

		for (int i = 0; i < H; i++) {
			StringBuilder sb = new StringBuilder(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = sb.charAt(j);
				if (map[i][j] == 'C') {
					if (startPoint == null) {
						startPoint = new Point(i, j, -1, 0);
					} else if (endPoint == null) {
						endPoint = new Point(i, j, -1, 0);
					}
				}
			}
		}

//		PriorityQueue<Point> q = new PriorityQueue<>();
		Queue<Point> q = new ArrayDeque();
		q.add(startPoint);

		visited = new int[H][W][4];

		visited[startPoint.row][startPoint.col][0] = 1;
		visited[startPoint.row][startPoint.col][1] = 1;
		visited[startPoint.row][startPoint.col][2] = 1;
		visited[startPoint.row][startPoint.col][3] = 1;

		int size = 0;
		while (!q.isEmpty()) {
			size = q.size();

			for (int i = 0; i < size; i++) {
				Point p = q.poll();

				if (p.curve >= curve_Ans) {
					continue;
				}

				if (p.row == endPoint.row && p.col == endPoint.col) {
					curve_Ans = Math.min(curve_Ans, p.curve);
//					System.out.println(p + "==");
					continue;
				}

				if (p.dir == -1) {
					for (int d = 0; d < dir.length; d++) {
						int nr = p.row + dir[d][0];
						int nc = p.col + dir[d][1];

						if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != '*') {

							if (visited[nr][nc][d] == 0) {
								visited[nr][nc][d] = p.curve;
								q.offer(new Point(nr, nc, d, p.curve));
							}
						}
					}
				} else {
					for (int d = 0; d < next_dir[p.dir].length; d++) {
						int nr = p.row + dir[next_dir[p.dir][d]][0];
						int nc = p.col + dir[next_dir[p.dir][d]][1];
						int plus = 0;
						if (d != 0) {
							plus = 1;
						}

						if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != '*') {
							if (visited[nr][nc][next_dir[p.dir][d]] == 0) {
								visited[nr][nc][next_dir[p.dir][d]] = p.curve + plus;
								q.offer(new Point(nr, nc, next_dir[p.dir][d], p.curve + plus));
							} else if (visited[nr][nc][next_dir[p.dir][d]] > p.curve + plus) {
								visited[nr][nc][next_dir[p.dir][d]] = p.curve + plus;
								q.offer(new Point(nr, nc, next_dir[p.dir][d], p.curve + plus));
							}
						}
					}
				}

			}
//			System.out.println(Arrays.toString(q.toArray()));
		}
		System.out.println(curve_Ans);
	}

}
