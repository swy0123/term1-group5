package week3;

import java.util.Scanner;

/**
 * boj 15650 N과 M (2) 실버 3
 * 
 * @author elder
 *
 */
public class boj_15650 {

	static boolean[] visit;
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		visit = new boolean[N];
		arr = new int[M];

		BT(arr, visit, N, M, 0, 0);
	}

	private static void BT(int[] arr, boolean[] visit, int n, int m, int depth, int start) {
		// TODO Auto-generated method stub
		if (depth == m) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				arr[depth] = i + 1;
				BT(arr, visit, n, m, depth + 1, i + 1);
				visit[i] = false;
			}
		}

	}

}
