package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_12100 2048 (Easy)
 * 
 * @author SSAFY
 *
 */
public class boj_12100 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int N;
	static int Ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		move(map, 0);
//		move(map, 1);
//		move(map, 2);
//		move(map, 3);
//		print(map);
//		Ans = Math.max(Ans, find_max(map));
		dfs(map, 0);

		System.out.println(Ans);
	}

	private static void print(int[][] map) {
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	private static void dfs(int[][] map, int cnt) {
		if (cnt == 5) {
//			print(map);
			Ans = Math.max(Ans, find_max(map));
			return;
		}

		for (int d = 0; d < dir.length; d++) {
			// map clone
			int[][] map_clone = clone(map);
			move(map_clone, d);
			dfs(map_clone, cnt + 1);
		}
	}

	private static int find_max(int[][] map) {
		int max = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] > max) {
					max = map[i][j];
				}
			} 
		}

		return max;
	}

	private static void move(int[][] map, int d) {
		boolean[][] change = new boolean[N][N];
		switch (d) {
		case 0:
			for (int row = 0 + 1; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (map[row][col] == 0)
						continue;

					int nr = row;
					int nc = col;
					int temp = map[row][col];
					while (true) {
						nr += dir[d][0];
						nc += dir[d][1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (map[nr][nc] == 0)
								continue;

							if (map[nr][nc] == map[row][col]) {
								if (!change[nr][nc]) {
									map[nr][nc] *= 2;
									change[nr][nc] = true; //
									map[row][col] = 0;
								} else {
									map[row][col] = 0;
									map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								}
								break;
							}

							if (map[nr][nc] != map[row][col]) {
								map[row][col] = 0;
								map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								break;
							}
						} else {
							map[row][col] = 0;
							map[nr - dir[d][0]][nc - dir[d][1]] = temp;
							break;
						}
					}
				}
			}
			break;
		case 1:
			for (int row = N - 2; row >= 0; row--) {
				for (int col = 0; col < N; col++) {
					if (map[row][col] == 0)
						continue;

					int nr = row;
					int nc = col;
					int temp = map[row][col];
					while (true) {
						nr += dir[d][0];
						nc += dir[d][1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (map[nr][nc] == 0)
								continue;

							if (map[nr][nc] == map[row][col]) {
								if (!change[nr][nc]) {
									map[nr][nc] *= 2;
									change[nr][nc] = true;
									map[row][col] = 0;
								} else {
									map[row][col] = 0;
									map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								}
								break;
							}

							if (map[nr][nc] != map[row][col]) {
								map[row][col] = 0;
								map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								break;
							}
						} else {
							map[row][col] = 0;
							map[nr - dir[d][0]][nc - dir[d][1]] = temp;
							break;
						}
					}
				}
			}
			break;
		case 2:
			for (int col = 0 + 1; col < N; col++) {
				for (int row = 0; row < N; row++) {
					if (map[row][col] == 0)
						continue;

					int nr = row;
					int nc = col;
					int temp = map[row][col];
					while (true) {
						nr += dir[d][0];
						nc += dir[d][1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (map[nr][nc] == 0)
								continue;

							if (map[nr][nc] == map[row][col]) {
								if (!change[nr][nc]) {
									map[nr][nc] *= 2;
									change[nr][nc] = true;
									map[row][col] = 0;
								} else {
									map[row][col] = 0;
									map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								}
								break;
							}

							if (map[nr][nc] != map[row][col]) {
								map[row][col] = 0;
								map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								break;
							}
						} else {
							map[row][col] = 0;
							map[nr - dir[d][0]][nc - dir[d][1]] = temp;
							break;
						}
					}

				}
			}
			break;
		case 3:
			for (int col = N - 2; col >= 0; col--) {
				for (int row = 0; row < N; row++) {
					if (map[row][col] == 0)
						continue;

					int nr = row;
					int nc = col;
					int temp = map[row][col];
					while (true) {
						nr += dir[d][0];
						nc += dir[d][1];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (map[nr][nc] == 0)
								continue;

							if (map[nr][nc] == map[row][col]) {
								if (!change[nr][nc]) {
									map[nr][nc] *= 2;
									change[nr][nc] = true;
									map[row][col] = 0;
								} else {
									map[row][col] = 0;
									map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								}
								break;
							}

							if (map[nr][nc] != map[row][col]) {
								map[row][col] = 0;
								map[nr - dir[d][0]][nc - dir[d][1]] = temp;
								break;
							}
						} else {
							map[row][col] = 0;
							map[nr - dir[d][0]][nc - dir[d][1]] = temp;
							break;
						}
					}

				}
			}
			break;
		}
	}

	private static int[][] clone(int[][] map) {
		int[][] map_clone = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map_clone[i][j] = map[i][j];
			}
		}
		return map_clone;
	}

}
