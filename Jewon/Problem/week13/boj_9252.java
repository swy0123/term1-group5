package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//LCS 2
public class boj_9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		int[][] dp = new int[B.length() + 1][A.length() + 1];

		for (int j = 1; j < A.length() + 1; j++) {
			for (int i = 1; i < B.length() + 1; i++) {
				if (A.charAt(j - 1) == B.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		System.out.println(dp[B.length()][A.length()]);

		int cur = dp[B.length()][A.length()];
		int col = A.length();
		int row = B.length();
		StringBuilder sb = new StringBuilder();
//		while (sb.length() != dp[A.length()][B.length()]) {
		while (dp[row][col] != 0) {
			if (B.charAt(row - 1) == A.charAt(col - 1)) {
				sb.append(B.charAt(row - 1));
				row -= 1;
				col -= 1;
			} else {
				if (dp[row - 1][col] > dp[row][col - 1]) {
					row -= 1;
				} else {
					col -= 1;
				}
			}
		}

		System.out.print(sb.reverse());

	}

}
