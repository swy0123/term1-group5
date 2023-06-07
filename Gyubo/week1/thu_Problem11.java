import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thu_Problem11 {

	static final int[][] move = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {

			/**
			 * 초기 입력처리
			 */
			int n = Integer.parseInt(br.readLine());
			String[][] table = new String[n][n];
			for (int i = 0; i < table.length; i++) {
				table[i] = br.readLine().split(" ");
			}

			// 하나씩 탐색
			int count = 0;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					String curValue = table[y][x];
					// 로봇이 아니면 continue
					if (curValue.equals("S") || curValue.equals("W")) {
						continue;
					}
					// 로봇이면 계산 시작
					// 3가지 케이스 분리

					if (curValue.equals("A")) {
						count = calculate(n, table, count, y, x, 1);
					}

					if (curValue.equals("B")) {
						count = calculate(n, table, count, y, x, 2);
					}

					if (curValue.equals("C")) {
						count = calculate(n, table, count, y, x, 4);
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}

	}

	private static int calculate(int n, String[][] table, int count, int y, int x, int div) {
		for (int i = 0; i < div; i++) {
			int dx = move[i][0];
			int dy = move[i][1];

			for (int j = 1; j < Integer.MAX_VALUE; j++) {
				int nx = x + dx * j;
				int ny = y + dy * j;
				// 배열 범위 안에만 탐색
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 벽이나 로봇을 만나면 break
					if (table[ny][nx].equals("W") || table[ny][nx].equals("A") || table[ny][nx].equals("B")
							|| table[ny][nx].equals("C")) {
						break;
					}
					// 만나지 않았다면 계속 탐색, conut ++
					count++;
				} else {
					break;
				}
			}
		}
		return count;
	}

}
