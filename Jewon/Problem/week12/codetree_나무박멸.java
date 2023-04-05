package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 나무박멸
 * 
 * @author elder
 *
 */

// 제초제의 경우 k의 범위만큼 대각선 ,벽이 있는 경우 가로막혀서 전파되지 않습니다.
// 1. 인접한 네 개의 칸 중 나무가 있는 칸의 수만큼 나무가 성장
// 2. 기존에 있었던 나무들은 인접한 4개의 칸 중 벽, 다른 나무, 제초제 모두 없는 칸에 번식을 진행
//  - 각 칸의 나무 그루 수에서 총 번식이 가능한 칸의 개수만큼 나누어진 그루 수만큼 번식
public class codetree_나무박멸 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] cross_dir = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
	static int N, M, K, C;
	static int[][] map;

	static class Point {
		int row, col, val;

		public Point(int row, int col, int val) {
			super();
			this.row = row;
			this.col = col;
			this.val = val;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", val=" + val + "]";
		}

	}

	static int[][] jecho;
	static long kill_tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 년도수
		K = Integer.parseInt(st.nextToken()); // 확산 범위
		C = Integer.parseInt(st.nextToken()); // 제초제 수명
		kill_tree = 0;
		map = new int[N][N];
		jecho = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start
		for (int year = 0; year < M; year++) {
			// 1. 나무 성장
			grow(map);
			// 2. 번식
			breeding(map);
			// 3. 제초
			herbicide(map);
			// 4. 제초 수명 줄여주기
			herbicide_kill(jecho);

		}

		System.out.println(kill_tree);
	}

	private static void herbicide_kill(int[][] jecho) {
		for (int row = 0; row < jecho.length; row++) {
			for (int col = 0; col < jecho[row].length; col++) {
				if (jecho[row][col] > 0) {
					jecho[row][col]--;
				}
			}
		}
	}

	private static void herbicide(int[][] map) {
		// find max jecho!!
		int max_num = -1;
		Point max_point = new Point(-1, -1, 0);
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 0 || map[row][col] == -1)
					continue;

				int sum = map[row][col];

				outer: for (int d = 0; d < cross_dir.length; d++) {
					for (int x = 1; x <= K; x++) {
						int nr = row + (cross_dir[d][0] * x);
						int nc = col + (cross_dir[d][1] * x);

						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (map[nr][nc] != 0 && map[nr][nc] != -1) {
								sum += map[nr][nc];
							} else {
								continue outer;
							}
						}
					}
				}

				if (max_num < sum) {
					max_num = sum;
					max_point.row = row;
					max_point.col = col;
				} // 행이 작은 순서대로, 만약 행이 같은 경우에는 열이 작은 칸에 제초제
			}
		}

		// 제초할곳이 없다면
		if (max_num == -1) {
			return;
		}

		// 제초제를 뿌리고 박멸하자
		int row = max_point.row;
		int col = max_point.col;
		kill_tree += map[row][col];
		map[row][col] = 0;
		jecho[row][col] = C + 1;

		outer: for (int d = 0; d < cross_dir.length; d++) {
			for (int x = 1; x <= K; x++) {
				int nr = row + (cross_dir[d][0] * x);
				int nc = col + (cross_dir[d][1] * x);

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] != -1 && map[nr][nc] != 0) {
						kill_tree += map[nr][nc];
						map[nr][nc] = 0;
						jecho[nr][nc] = C + 1;
					} else {
						jecho[nr][nc] = C + 1;
						continue outer;
					}
				}
			}
		}
	}

	private static void breeding(int[][] map) {
		int[][] temp_map = new int[N][N];

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (map[row][col] == 0 || map[row][col] == -1)
					continue;

				// 빈 땅수 찾기
				int cnt = 0;
				for (int d = 0; d < dir.length; d++) {
					int nr = row + dir[d][0];
					int nc = col + dir[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] == 0 && jecho[nr][nc] == 0) {
							cnt++;
						}
					}
				}

				// 심어주기
				if (cnt > 0) {
					int seeding = map[row][col] / cnt;
					for (int d = 0; d < dir.length; d++) {
						int nr = row + dir[d][0];
						int nc = col + dir[d][1];

						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (map[nr][nc] == 0 && jecho[nr][nc] == 0) {
								temp_map[nr][nc] += seeding;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] += temp_map[i][j];
			}
		}
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	private static void grow(int[][] map) {
		Queue<Point> q = new LinkedList<Point>();

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				if (map[row][col] == 0 || map[row][col] == -1)
					continue;

				// 주변 나무수 구하기
				int cnt = 0;
				for (int d = 0; d < dir.length; d++) {
					int nr = row + dir[d][0];
					int nc = col + dir[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (map[nr][nc] != 0 && map[nr][nc] != -1) {
							cnt++;
						}
					}
				}

				if (cnt > 0) {
					q.offer(new Point(row, col, cnt));
				}
			}
		}

		int size = q.size();
		for (int i = 0; i < size; i++) {
			Point p = q.poll();

			map[p.row][p.col] += p.val;
		}
	}

}
