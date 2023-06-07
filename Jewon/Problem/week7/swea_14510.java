package week7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class swea_14510 {

	static int N;
	static int[] Trees;
	static int MaxValue;
	static int odd;
	static int even;
	static int Ans;

	public static void main(String[] args) throws IOException {
//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("D:\\code\\Java_Practice\\Ssafy_Algorithm\\src\\swea_14510.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			MaxValue = 0;
			odd = 0;
			even = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Trees = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Trees[i] = Integer.parseInt(st.nextToken());
				if (MaxValue < Trees[i]) {
					MaxValue = Trees[i];
				}

			}

			for (int i = 0; i < N; i++) {
				even += (MaxValue - Trees[i]) / 2;
				odd += (MaxValue - Trees[i]) % 2;
			}

//			System.out.println(odd + " " + even);

			if (even > odd) {
				int temp = (even - odd) / 3;
				even -= temp;
				odd += temp * 2;

				if ((even - odd) % 3 == 2) {
					even -= 1;
					odd += 2;
				}
			}

			if (even >= odd) {
				Ans = even * 2;
			}

			if (odd > even) {
				Ans = 2 * odd - 1;
			}

			System.out.println("# " + test_case + " " + Ans);

		}

	}

}
