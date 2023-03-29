package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1149 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		int[][] cost = new int[num][3];
		int[][] memo = new int[num][3];

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memo[0][0] = cost[0][0];
		memo[0][1] = cost[0][1];
		memo[0][2] = cost[0][2];

		for (int i = 1; i < num; i++) {
			memo[i][0] = cost[i][0] + Math.min(memo[i - 1][1], memo[i - 1][2]);
			memo[i][1] = cost[i][1] + Math.min(memo[i - 1][0], memo[i - 1][2]);
			memo[i][2] = cost[i][2] + Math.min(memo[i - 1][0], memo[i - 1][1]);
		}

		System.out.println(Math.min(Math.min(memo[num - 1][0], memo[num - 1][1]), memo[num - 1][2]));
	}

}
