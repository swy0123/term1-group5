package specialweek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * swea_9229 한빈이와 Spot Mart d3
 * 
 * @author SSAFY
 *
 */

public class swea_9229 {
	static int N;
	static int M;
	static int[] arr;
	static int max_value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			max_value = -1;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			recur(0, 0);

			System.out.println("#" + test_case + " " + max_value);
		}
	}

	static int[] temp_arr = new int[2];

	private static void recur(int depth, int start) {
		if (depth == 2) {
			max_value = Math.max(max_value, temp_arr[0] + temp_arr[1]);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			if ((depth == 1 && temp_arr[0] + arr[i] <= M) || (depth == 0 && arr[i] <= M)) {
				temp_arr[depth] = arr[i];
				recur(depth + 1, i + 1);
			}
		}
	}

}
