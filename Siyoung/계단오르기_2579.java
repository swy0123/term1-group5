package test;

import java.util.Arrays;
import java.util.Scanner;

public class 계단오르기_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] map = new int[n+2];
		for(int i=1; i<=n; i++) {
			map[i] = sc.nextInt();
		}
		
		int[] arr = new int[n+2];
		arr[1]=map[1];
		arr[2]=map[1]+map[2];
		
		for(int i=3; i<=n; i++) {
			arr[i] = Math.max(arr[i-3]+map[i-1]+map[i], arr[i-2]+map[i]);
		}

		System.out.println(arr[n]);	
//		System.out.println(Arrays.toString(arr));	
		
	}
}
