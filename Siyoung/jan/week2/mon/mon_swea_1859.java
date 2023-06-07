package com.sy.secweek.mon;

import java.util.Scanner;
/**
 * 문제26: SWEA : 1859 백만 장자 프로젝트
 * @author swy05
 */
public class mon_swea_1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n, max;
		long sum;
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			sum = 0;
			max = 0;
			int[] arr = new int[n];

			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=arr.length-1; i>=0; i--) {
				if(arr[i] >= max) max = arr[i];
				else {
					sum += max - arr[i];
				}
				
			}
			
			System.out.println("#"+t+" "+sum);
		}

	}

}
