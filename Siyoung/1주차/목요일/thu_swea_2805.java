package com.sy;

import java.util.Scanner;

public class thu_swea_2805 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
			sc.nextLine();
			int sum = 0;
			
			int[][] map = new int[n][n];
			int cur = n/2;
			int min = cur;
			int max = cur;
			String input;
			for(int i=0; i<n; i++) {
				input = sc.nextLine();
				for(int j=0; j<n; j++) {
					map[i][j] = (input.charAt(j))-48;
					if(j>=min && j<=max) {
						sum+=map[i][j];
					}
				}
				if(i<cur) {
					min--;
					max++;
				}
				else {
					min++;
					max--;
				}
			}
			System.out.println("#"+test_case+" "+sum);
			
		}
	}

}
