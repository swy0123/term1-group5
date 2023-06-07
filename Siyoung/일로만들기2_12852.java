package test;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class 일로만들기2_12852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n+1];
		Arrays.fill(arr, 100001);
		int[] root = new int[n+1];
		for(int i=0; i<=n; i++) {
			root[i] = i;
		}
		
		arr[1] = 0;
		for(int i=2; i<=n; i++) {
			if(i%3==0) {
				if(arr[i] > arr[i/3]+1) {
					arr[i] = arr[i/3]+1;
					root[i] = i/3;
				}
			}
			if(i%2==0) {
				if(arr[i] > arr[i/2]+1) {
					arr[i] = arr[i/2]+1;
					root[i] = i/2;
				}
			}
			if(arr[i] > arr[i-1]+1) {
				arr[i] = arr[i-1]+1;
				root[i] = i-1;
			}
			
		}
		System.out.println(arr[n]);
		int cnt = arr[n];
		while(cnt>=0) {
			System.out.print(n+" ");
			n = root[n];
			cnt--;
		}
	}
}
