import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thu_swea_2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] table = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxValue = Integer.MIN_VALUE;

			for (int i = 0; i <= n - m; i++) {
				for (int j = 0; j <= n - m; j++) {
					int sum = 0;
					for (int y = i; y < i + m; y++) {
						for (int x = j; x < j + m; x++) {
							sum += table[y][x];
						}
					}
					maxValue = Math.max(maxValue, sum);
				}
			}
			System.out.println("#" + tc + " " + maxValue);
		}
	}
}
