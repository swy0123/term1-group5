package solving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * boj_14501 퇴사 실버3
 * 
 * @author SSAFY
 *
 */
public class boj_14501 {

	static int N;
	static int[][] list;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		list = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		System.out.println(max);
	}

	static int temp = 0;

	private static void dfs(int depth, int prev) {
		if (depth == N) {
			max = Math.max(max, temp);
			return;
		}

		if (depth > N) {
			temp -= list[prev][1];
			max = Math.max(max, temp);
			temp += list[prev][1];
			return;
		}

		for (int i = depth; i < list.length; i++) {
			temp += list[i][1];
			dfs(i + list[i][0], i);
			temp -= list[i][1];
		}

	}

}
