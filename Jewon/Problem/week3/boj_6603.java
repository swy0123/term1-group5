package week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * boj_6603번 로또 실버2
 * 
 * @author elder
 *
 */
public class boj_6603 {
	static int[] arr;
	static int[] arr2;
	static boolean[] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			int N = sc.nextInt();

			if (N == 0) {
				return;
			}

			arr = new int[N];
			visit = new boolean[N];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}

			Lotto(arr, visit, N, 0, 0);

		}
	}

	private static void Lotto(int[] arr, boolean[] visit, int n, int depth, int start) {
		// TODO Auto-generated method stub
		if(depth == 2) {
			for(int i =0; i< n; i++) {
				if(visit[i] == true) {
					System.out.print(arr[i] + " ");					
				}
			}
			System.out.println();
			return;
		}
		
		
		for (int j = start; j < n; j++) {
			if(visit[j] == false) {
				visit[j] = true;
				Lotto(arr, visit, n, depth+1, j+1);
				visit[j] = false;
			}		
		}
		
	}

	// 사전순 ?

}
