package IM;

/**
 * boj_11399 ATM 실버4
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class boj_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			ans += (arr[i] * (N - i));
		}

		System.out.println(ans);
	}

}
