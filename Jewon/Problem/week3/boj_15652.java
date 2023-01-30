package week3;

import java.util.Scanner;

/**
 * boj 15652 N과 M (4) silver 3
 * 
 * @author elder
 *
 */
public class boj_15652 {
	static int[] arr;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[M];
		visit = new boolean[N];

		BT(N, M, 0, 0);

	}

	private static void BT(int n, int m, int depth, int start) {
		// TODO Auto-generated method stub
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			arr[depth] = i + 1;
			BT(n, m, depth + 1, i);
		}
	}

}
