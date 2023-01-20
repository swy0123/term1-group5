package coding_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SaltBugOverlap {

	static int[] move = { 3, 2, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < testCase + 1; tc++) {
			String[] input = br.readLine().split(" ");

			int n = Integer.parseInt(input[0]);
			int bug = Integer.parseInt(input[1]);

			boolean[][] visited = new boolean[n][n];

			boolean flag = true;
			String[] row = new String[bug];

			for (int i = 0; i < bug; i++) {
				row[i] = br.readLine();
			}

			for (int i = 1; i < bug + 1; i++) {
				String[] split = row[i-1].split(" ");
				int y = Integer.parseInt(split[0]);
				int x = Integer.parseInt(split[1]);
				int dir = Integer.parseInt(split[2]);

				// 현재 위치 체크
				if (visited[y][x]) {
					System.out.println("#" + tc + " " + i);
					break;
				}
				// 방문처리
				visited[y][x] = true;

				// visited check
				// 방향에 따른 dy dx 필요
				if (dir == 2) {
					flag = calX(tc, n, visited, i, y, x);
					if (!flag) {
						break;
					}
				} else {
					flag = calY(tc, n, visited, i, y, x);
					if (!flag) {
						break;
					}
				}
			}
			if (flag) {
				System.out.println("#" + tc + " " + 0);
			}
		}
	}

	private static boolean calY(int tc, int n, boolean[][] visited, int i, int ny, int x) {
		for (int j = 0; j < 3; j++) {
			ny = ny + move[j];
			if (ny >= 0 && ny < n) {
				if (visited[ny][x]) {
					System.out.println("#" + tc + " " + i);
					return false;
				}
				visited[ny][x] = true;
			} else {
				break;
			}
		}
		return true;
	}

	private static boolean calX(int tc, int n, boolean[][] visited, int i, int y, int nx) {
		for (int j = 0; j < 3; j++) {
			nx = nx + move[j];
			if (nx >= 0 && nx < n) {
				if (visited[y][nx]) {
					System.out.println("#" + tc + " " + i);
					return false;
				}
				visited[y][nx] = true;
			} else {
				break;
			}
		}
		return true;
	}
}
