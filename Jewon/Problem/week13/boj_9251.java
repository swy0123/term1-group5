package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// LCS 1
public class boj_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = br.readLine();
		String B = br.readLine();

		int[][] dp = new int[A.length() + 1][B.length() + 1];

		for (int i = 1; i < A.length() + 1; i++) {
			for (int j = 1; j < B.length() + 1; j++) {

				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}
		}

		System.out.println(dp[A.length()][B.length()]);

	}

}
