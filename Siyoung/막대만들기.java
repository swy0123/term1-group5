package test;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class 막대만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		arr[1] = 2;
		arr[2] = 5;
		
		for(int i=3; i<=n; i++) {
			arr[i] = arr[i-1]*2 + arr[i-2];
		}
		
//		System.out.println(Arrays.toString(arr));
		System.out.println(arr[n]);
		
	}
}
