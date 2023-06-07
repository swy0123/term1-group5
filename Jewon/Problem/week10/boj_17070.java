package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 
 * boj_17070 파이프 옮기기 1
 * 
 */
public class boj_17070 {

	static int[][] dir = { { 1, 0 }, { 1, 1 }, { 0, 1 } };
	static int[][] next_dir = { { 0, 1 }, { 0, 1, 2 }, { 1, 2 } };
	static int N;
	static int[][] map;
	static int[][][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		memo = new int[N][N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[i].length; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}

		System.out.println(DFS(0, 1, 2));
	}

	private static int DFS(int row, int col, int prev) {
		if (row == N - 1 && col == N - 1) {
			return memo[row][col][0] = memo[row][col][1] = memo[row][col][2] = 1;
		}

		if (memo[row][col][prev] != -1) {
			return memo[row][col][prev];
		} else {
			memo[row][col][prev] = 0;
		}

		for (int i = 0; i < next_dir[prev].length; i++) {
			int nr = row + dir[next_dir[prev][i]][0];
			int nc = col + dir[next_dir[prev][i]][1];

			if (check(row, col, next_dir[prev][i])) {
				memo[row][col][prev] += DFS(nr, nc, next_dir[prev][i]);
			}
		}

		return memo[row][col][prev];
	}

	private static boolean check(int row, int col, int prev_dir) {

		if (prev_dir != 1) {
			int nr = row + dir[prev_dir][0];
			int nc = col + dir[prev_dir][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 1) {
				return true;
			}
		} else {
			for (int i = 0; i < next_dir[prev_dir].length; i++) {
				int nr = row + dir[next_dir[prev_dir][i]][0];
				int nc = col + dir[next_dir[prev_dir][i]][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) {
					return false;
				}
			}

			return true;
		}

		return false;
	}

}
