import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class thu_Problem13 {

	static int[][] move = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			int n = Integer.parseInt(br.readLine());

			String[][] table = new String[n][n];

			for (int i = 0; i < n; i++) {
				String[] row = br.readLine().split(" ");
				table[i] = row;
			}

			int result = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (table[i][j].equals("G")) {
						continue;
					}

					boolean flag = false;
					for (int k = 0; k < move.length; k++) {
						int nx = j + move[k][0];
						int ny = i + move[k][1];

						if (ny >= 0 && ny < n && nx >= 0 && nx < n) {
							if (table[ny][nx].equals("G")) {
								result = Math.max(result, 2);
								flag = true;
								break;
							}
						}
					}
					if (!flag) {
						int count = 0;
						for (int x = 0; x < n; x++) {
							if (table[i][x].equals("B")) {
								count++;
							}
						}
						for (int y = 0; y < n; y++) {
							if (table[y][j].equals("B")) {
								count++;
							}
						}
						result = Math.max(result, count - 1);
					}
				}
			}
			System.out.println("#" + testCase + " " + result);
		}
	}
}
