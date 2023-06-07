package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1486 {

	static int N, B;
	static int[] H;
	static int Ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			H = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);

			System.out.println("#" + test_case + " " + (Ans - B));
		}
	}

	private static void dfs(int depth, int sum) {
		if (sum > Ans) {
			return;
		}

		if (depth == N) {
			if (sum >= B) {
				Ans = Math.min(Ans, sum);
			}
			return;
		}

		dfs(depth + 1, sum + H[depth]);
		dfs(depth + 1, sum);
	}

}
