package com.sy.secweek.mon;

import java.util.Scanner;
/**
 * 문제27: SWEA : 6730 장애물 경주 난이도
 * @author swy05
 */
public class mon_swea_6730 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n, up, down;
		
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			up = 0;
			down = 0;
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=1; i<n; i++) {
				if(arr[i]>arr[i-1]) {
					if(arr[i]-arr[i-1] > up) up = arr[i]-arr[i-1];
				}
				else if(arr[i]<arr[i-1]) {
					if(arr[i-1]-arr[i] > down) down = arr[i-1]-arr[i];
				}
			}
			
			System.out.println("#"+t+" "+up+" "+down);
		}

	}

}
