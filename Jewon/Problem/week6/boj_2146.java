package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * boj_2146 다리 만들기 골드 3
 * 
 * @author SSAFY
 *
 */
public class boj_2146 {

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int map[][];
	static int label = 1;
	static boolean[][] visit;
	static int ans = Integer.MAX_VALUE;

	static class Point implements Comparable<Point>{
		int row;
		int col;
		int dist;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
			this.dist = 0;
		}

		public Point(int row, int col, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", dist=" + dist + "]";
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.dist, o.dist);
		}

	}

	static List<Point> list = new ArrayList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬에 라벨링
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs_label(i, j);
					label++;
				}
			}
		}
//		print();

		// 각 섬의 좌표 하나씩 받기
		int search_label = 1;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == search_label) {
					list.add(new Point(i, j));
					search_label++;

					if (search_label == label) {
						break outer;
					}
				}
			}
		}
//		System.out.println(Arrays.toString(list.toArray()));

		// search ans
		for (int i = 0; i < list.size(); i++) {
			bfs(list.get(i), i + 1);
		}

		if (ans == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(ans);
		}

	}

	private static void bfs(Point point, int start_island) {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[N][N];
//		int min_dist = Integer.MAX_VALUE;
		q.offer(point);

		visit[point.row][point.col] = true;
		int size = 0;

		while (!q.isEmpty()) {
			size = q.size();
			for (int round = 0; round < size; round++) {
				Point p = q.poll();
				
				

				//
				if(p.dist >= ans) {
					continue;
				}
				
				for (int i = 0; i < dir.length; i++) {
					int nr = p.row + dir[i][0];
					int nc = p.col + dir[i][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
						visit[nr][nc] = true;

						if (map[nr][nc] == 0) {
							q.offer(new Point(nr, nc, p.dist + 1));
						} else if (map[nr][nc] == start_island && p.dist == 0) {
							q.offer(new Point(nr, nc, p.dist)); //
						} else if (map[nr][nc] != start_island && map[nr][nc] != 0) {
							ans = Math.min(ans, p.dist);
						}

					}
				}
			}
//			System.out.println(Arrays.toString(q.toArray()));
		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs_label(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();

		q.offer(new Point(i, j));

		while (!q.isEmpty()) {
			Point p = q.poll();
			map[p.row][p.col] = label;

			for (int k = 0; k < dir.length; k++) {
				int nr = p.row + dir[k][0];
				int nc = p.col + dir[k][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1 && !visit[nr][nc]) {
					q.offer(new Point(nr, nc));
					visit[nr][nc] = true;
				}
			}
		}
	}

}
