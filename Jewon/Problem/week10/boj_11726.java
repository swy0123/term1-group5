package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11726 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] memo = new int[N + 2];
		memo[1] = 1;
		memo[2] = 2;
		
		for (int i = 3; i < N + 1; i++) {
			memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
		}

		System.out.println(memo[N]);
//		System.out.println(Arrays.toString(memo));
	}

}
