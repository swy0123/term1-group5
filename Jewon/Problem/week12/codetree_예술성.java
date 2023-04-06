package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class codetree_예술성 {
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

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int[][] map;
	static int[][] group;
	static boolean[][] group_visit;

	static int Ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		for (int round = 0; round < 4; round++) {
			// init
			int[][] group = new int[N][N];
			group_visit = new boolean[N][N];
			List<Point> start_p = new ArrayList<>();
			// group labeling
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!group_visit[i][j]) {
						group_bfs(group, group_visit, i, j, cnt++);
						start_p.add(new Point(i, j));
					}
				}
			}

			// find value;
			int[] group_num = new int[cnt];
			int[] group_cnt = new int[cnt];
			int[][] value_list = new int[cnt][cnt];
			calc(group, value_list, start_p, group_cnt, group_num);

//			System.out.println(Arrays.toString(group_num));
//			print(value_list);

			// calc Artistry
			int Artistry = 0; // warning long

			for (int i = 1; i < cnt; i++) {
				for (int j = i + 1; j < cnt; j++) {
					if (value_list[i][j] != 0) {
						Artistry += (group_cnt[i] + group_cnt[j]) * group_num[i] * group_num[j] * value_list[i][j];
					}
				}
			}
			
			
//			System.out.println(Artistry);
			Ans += Artistry;
			// 회전
			if(round == 3) {
				break;
			}
			map = rotate(map);
//			print(map);
		}
			System.out.println(Ans);
	}

	private static int[][] rotate(int[][] map) {
		// +
		int[][] temp = new int[N][N];
		int mid = N / 2;

		for (int row = 0; row < N; row++) {
			temp[mid][row] = map[row][mid];
		}

		for (int col = 0; col < N; col++) {
			int val = mid - col;
			temp[mid + val][col + val] = map[mid][col];
		}

		// [] [] [] []
		// 0 >= ~ < N/2 N/2+1 ~ N
		for (int row = 0; row < N / 2; row++) {
			for (int col = 0; col < N / 2; col++) {
				temp[col][(N / 2 - 1) - row] = map[row][col];
				temp[col][(N / 2 - 1) - row + (N / 2 + 1)] = map[row][col + (N / 2 + 1)];
				temp[col + (N / 2 + 1)][(N / 2 - 1) - row] = map[row + (N / 2 + 1)][col];
				temp[col + (N / 2 + 1)][(N / 2 - 1) - row + (N / 2 + 1)] = map[row + (N / 2 + 1)][col + (N / 2 + 1)];
			}
		}

		return temp;
	}

	private static void calc(int[][] group, int[][] value_list, List<Point> start_p, int[] group_cnt, int[] group_num) {
		int size = start_p.size();

		for (int round = 0; round < size; round++) {
			boolean[][] visit = new boolean[N][N];
			int cnt = 1;
			Point start = start_p.get(round);
			group_num[round + 1] = map[start.row][start.col];
			Queue<Point> q = new LinkedList<>();
			visit[start.row][start.col] = true;
			q.offer(start);

			while (!q.isEmpty()) {
				Point p = q.poll();

				for (int d = 0; d < dir.length; d++) {
					int nr = p.row + dir[d][0];
					int nc = p.col + dir[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
						// round + 1 인가?

						if (group[nr][nc] == round + 1) {
							visit[nr][nc] = true;
							cnt++;
							q.offer(new Point(nr, nc));
						} else {
							value_list[round + 1][group[nr][nc]]++;
						}
						// 아니면
					}
				}
			}
			group_cnt[round + 1] = cnt;
		}
	}

	private static void print(int[][] map) {
		System.out.println();
		for (int row = 0; row < map.length; row++) {
			System.out.println(Arrays.toString(map[row]));
		}
	}

	private static void group_bfs(int[][] group, boolean[][] group_visit, int row, int col, int num) {
		Queue<Point> q = new LinkedList();
		q.offer(new Point(row, col));
		group_visit[row][col] = true;
		group[row][col] = num;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < dir.length; d++) {
				int nr = p.row + dir[d][0];
				int nc = p.col + dir[d][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !group_visit[nr][nc]) {
					if (map[row][col] == map[nr][nc]) {
						group_visit[nr][nc] = true;
						group[nr][nc] = num;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
	}

}
