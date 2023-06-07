package algorithm;

import java.util.Scanner;

public class boj_2748 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		long[] memo = new long[num + 2];
		memo[0] = 0;
		memo[1] = 1;

		for (int i = 2; i < num + 1; i++) {
			memo[i] = memo[i - 2] + memo[i - 1];
		}

		System.out.println(memo[num]);
	}

}
