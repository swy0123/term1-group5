package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * boj_14501 DFS
 * boj_15486 퇴사 DP
 * @author SSAFY
 *
 */
public class boj_15486 {

	static int N;
	static int[] times;
	static int[] cost;
	static int Ans = 0;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		times = new int[N];
		cost = new int[N];
		memo = new int[N+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}

		dp();
//		dfs(0, 0);
//		System.out.println(Arrays.toString(memo));
		System.out.println(Ans);
	}

	private static void dp() {
		for (int i = 0; i < cost.length; i++) {
			// 일안하고 다음날 가는 상황 = 뒤에날 그대로 당겨오기
			if (i != 0)
				memo[i] = Math.max(memo[i - 1], memo[i]);

			// 초과 근무일이 아니면 일한거 업뎃하기
			if (i + times[i] <= N) {
				memo[i + times[i]] = Math.max(memo[i + times[i]], memo[i] + cost[i]);
			}
		}

		Ans = Arrays.stream(memo).max().getAsInt();
	}

	private static void dfs(int day, int money) {
		if (day + 1 > N) {
			Ans = Math.max(Ans, money);
			return;
		}

		if (day + times[day] > N) {
			dfs(day + 1, money);
			return;
		}

		dfs(day + times[day], money + cost[day]);
		dfs(day + 1, money);
	}

}
