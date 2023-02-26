package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * boj_15683 감시 골드 4
 * @author elder
 *
 */
public class boj_15683 {
	// 상 우 하 좌
	static int[][] dir = { {}, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][][] camera = { {},{ { 1 }, { 2 }, { 3 }, { 4 } }, { { 1, 3 }, { 2, 4 } },
			{ { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } }, { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 1 }, { 4, 1, 2 } },
			{ { 1, 2, 3, 4 } } };

	static int N;
	static int M;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;

	static class Point {
		int row;
		int col;
		int num;

		public Point(int row, int col, int num) {
			super();
			this.row = row;
			this.col = col;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", num=" + num + "]";
		}

	}

	static List<Point> cameras;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cameras = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cameras.add(new Point(i, j, map[i][j]));
				}
			}
		}

		dfs(0);

		System.out.println(ans);
	}
	
	static List<Integer> list = new ArrayList<>(); 
	
	private static void dfs(int depth) {
		if (depth == cameras.size()) {
			for (int i = 0; i < depth; i++) {
				Point p = cameras.get(i);
				fill_map(p.row, p.col, camera[p.num][list.get(i)], -1);
			}
			
			int size = check_size();
			
			ans = Math.min(ans, size);
			for (int i = 0; i < depth; i++) {
				Point p = cameras.get(i);
				fill_map(p.row, p.col, camera[p.num][list.get(i)], 0);
			}
			return;
		}

		Point p = cameras.get(depth);

		for (int i = 0; i < camera[p.num].length; i++) { // p.num - 1 : 카메라 , camera[][]
			list.add(i);
			dfs(depth + 1);
			list.remove(list.size()-1);
		}

	}

	private static int check_size() {
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	private static void fill_map(int row, int col, int[] camera_dir, int fill) {
		for (int i = 0; i < camera_dir.length; i++) {
			int cnt = 1;
			while (true) {
				int nr = row + dir[camera_dir[i]][0] * cnt;
				int nc = col + dir[camera_dir[i]][1] * cnt;

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if ((map[nr][nc] == -1 || map[nr][nc] == 0) && fill == -1) {
						map[nr][nc] = -1;
					} else if ((map[nr][nc] == -1 || map[nr][nc] == 0) && fill == 0) {
						map[nr][nc] = 0;
					} else if (map[nr][nc] == 6) {
						break;
					}
				} else {
					break;
				}

				cnt++;
			}
		}
	}

}
