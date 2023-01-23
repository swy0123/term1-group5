package com.sy.secweek.mon;

import java.util.Scanner;

public class mon_swea_6958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int n, m, sum, max, ret;
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			ret = 0;
			
			int[][] arr = new int[n][m];
			int[] score = new int[n];
			max = 0;
			for(int i=0; i<n; i++) {
				sum = 0;
				for(int j=0; j<m; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] == 1) sum++;
				}
				score[i] = sum;
				if(sum>max) max = sum;
			}
			
			for(int i=0; i<n; i++) {
				if(score[i] == max) ret++;
			}
			System.out.println("#"+t+" "+ret+" "+max);
		}

	}

}
