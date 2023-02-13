package com.sy.firstweek.fri;

import java.util.Scanner;

public class fri_baek_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, m;
		n = sc.nextInt();
		m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int max = 0;
		for(int i=0; i<n-2; i++) {
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					sum = arr[i] + arr[j] + arr[k];
					if(sum <= m && sum > max) max = sum;
				}
			}
		}
		System.out.println(max);
	}
}
