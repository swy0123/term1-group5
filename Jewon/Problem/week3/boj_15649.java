package week3;

import java.util.Scanner;

/**
 * boj_15649 N과 M (1) 실버 3
 * 
 * @author elder
 *
 */

public class boj_15649 {
	static boolean[] visit;
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		visit = new boolean[N];
		arr = new int[M];
		BT(arr, visit, N, M, 0);
	}

	private static void BT(int[] arr, boolean[] visit, int n, int m, int depth) {
		// TODO Auto-generated method stub
		if(depth == m) {
			for(int i : arr) {
				System.out.print(i+ " ");
			}
			System.out.println();
			return;
		}
		
		
		for (int j = 0; j < n; j++) {
			if(visit[j] == false) {
				visit[j] = true;
				arr[depth] = j+1;
				BT(arr,visit,n,m,depth+1);
				visit[j] = false;
			}
		}
	}

}
