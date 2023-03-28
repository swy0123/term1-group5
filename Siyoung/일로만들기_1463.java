package test;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class 일로만들기_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		Arrays.fill(arr, 100001);
		arr[1] = 0;
		for(int i=2; i<=n; i++) {
			if(i%3==0) {
				arr[i] = Math.min(arr[i], arr[i/3]+1);
			}
			if(i%2==0) {
				arr[i] = Math.min(arr[i], arr[i/2]+1);
			}
			arr[i] = Math.min(arr[i], arr[i-1]+1);
			
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[n]);
		
	}

}
