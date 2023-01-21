package com.sy.firstweek.sat;

import java.util.Scanner;
/**
 * 3985번 - 롤 케이크
 * @author swy05
 */
public class sat_baek_3985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int n = sc.nextInt();
		int p, k;
		int res1 = 0, res2 = 0, max = 0;
		
		int[] arr = new int[l];
		for(int i=0; i<l; i++) {
			arr[i] = 0;
		}
		int[] narr = new int[n];
		for(int i=0; i<n; i++) {
			narr[i] = 0;
		}
		
		for(int i=0; i<n; i++) {
			p = sc.nextInt()-1;
			k = sc.nextInt()-1;
			
			if(k-p+1 > max) {
				res1 = i+1;
				max = k-p+1;
			}
			
			for(int j=p; j<=k; j++) {
				if(arr[j]==0) arr[j]=i+1;
			}
		}
		
		for(int i=0; i<l; i++) {
			if(arr[i]==0) continue;
			narr[arr[i]-1]++;
		}
		max = 0;
		for(int i=0; i<n; i++) {
			if(narr[i]>max) {
				max = narr[i];
				res2 = i+1;
			}
		}
//		for(int i=0; i<l; i++) {
//			System.out.printf("%d ", arr[i]);
//		}
//		System.out.println();
		System.out.println(res1);
		System.out.println(res2);
	}

}
