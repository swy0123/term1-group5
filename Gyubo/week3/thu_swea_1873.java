import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class thu_swea_1873 {

	private static final int[][] move = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < testCase + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			int curX = 0;
			int curY = 0;
			int vector = 0;

			String[][] table = new String[h][w];
			for (int i = 0; i < h; i++) {
				String[] split = br.readLine().split("");
				for (int j = 0; j < w; j++) {
					String tmp = split[j];
					table[i][j] = tmp;
					// 현재 위치와 방향을 저장
					if (tmp.equals("^")) {
						curX = j;
						curY = i;
						vector = 0;
					} else if (tmp.equals(">")) {
						curX = j;
						curY = i;
						vector = 1;
					} else if (tmp.equals("v")) {
						curX = j;
						curY = i;
						vector = 2;
					} else if (tmp.equals("<")) {
						curX = j;
						curY = i;
						vector = 3;
					}
				}
			}

			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split("");
			// 입력 종료

			Loop: for (String com : input) {
//				System.out.println(Arrays.deepToString(table));
//				System.out.println(com);
				if (com.equals("S")) {
					int bx = curX;
					int by = curY;
					while (true) {
						int nx = bx + move[vector][0];
						int ny = by + move[vector][1];
						if (nx >= w || ny >= h || nx < 0 || ny < 0) {
							continue Loop;
						}
						if (table[ny][nx].equals("*")) {
							table[ny][nx] = ".";
							continue Loop;
						}
						if (table[ny][nx].equals("#")) {
							continue Loop;
						}
						bx = nx;
						by = ny;
					}
				}
				if (com.equals("U")) {
					int nx = curX + move[0][0];
					int ny = curY + move[0][1];
					table[curY][curX] = "^";
					vector = 0;
					if (nx >= w || ny >= h || nx < 0 || ny < 0) {
						continue;
					}
					if (table[ny][nx].equals(".")) {
						table[curY][curX] = ".";
						table[ny][nx] = "^";
						curX = nx;
						curY = ny;
					}

				}
				if (com.equals("R")) {
					int nx = curX + move[1][0];
					int ny = curY + move[1][1];
					table[curY][curX] = ">";
					vector = 1;
					if (nx >= w || ny >= h || nx < 0 || ny < 0) {
						continue;
					}
					if (table[ny][nx].equals(".")) {
						table[curY][curX] = ".";
						table[ny][nx] = ">";
						curX = nx;
						curY = ny;
					}

				}
				if (com.equals("D")) {
					int nx = curX + move[2][0];
					int ny = curY + move[2][1];
					table[curY][curX] = "v";
					vector = 2;
					if (nx >= w || ny >= h || nx < 0 || ny < 0) {
						continue;
					}
					if (table[ny][nx].equals(".")) {
						table[curY][curX] = ".";
						table[ny][nx] = "v";
						curX = nx;
						curY = ny;
					}

				}
				if (com.equals("L")) {
					int nx = curX + move[3][0];
					int ny = curY + move[3][1];
					table[curY][curX] = "<";
					vector = 3;
					if (nx >= w || ny >= h || nx < 0 || ny < 0) {
						continue;
					}
					if (table[ny][nx].equals(".")) {
						table[curY][curX] = ".";
						table[ny][nx] = "<";
						curX = nx;
						curY = ny;
					}

				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(table[i][j]);
				}
				System.out.println();
			}
		}
	}
}
