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
	static int[][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		memo = new int[N][N];
		
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}

		System.out.println(DFS(0, 1, 2));
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
	}

	private static int DFS(int row, int col, int prev) {
		if (row == N - 1 && col == N - 1) {
			return memo[row][col] = 1;
		}

		if (memo[row][col] != -1) {
			return memo[row][col];
		} else {
			memo[row][col] = 0;
		}

		for (int i = 0; i < next_dir[prev].length; i++) {
			int nr = row + dir[next_dir[prev][i]][0];
			int nc = col + dir[next_dir[prev][i]][1];

			if (check(nr, nc, next_dir[prev][i])) {
				memo[row][col] += DFS(nr, nc, next_dir[prev][i]);
			}
		}

		return memo[row][col];
	}

	private static boolean check(int nr, int nc, int dir) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			if (dir != 1) {
				if (map[nr][nc] != 1) {
					return true;
				}
			} else {
				if (map[nr][nc] != 1 && map[nr - 1][nc] != 1 && map[nr][nc - 1] != 1) {
					return true;
				}
			}
		}

		return false;
	}

}
