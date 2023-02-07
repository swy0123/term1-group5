package com.ssafy.feb.week1;

import java.util.Scanner;
/*
 * 난이도 하 7236. 저수지의 물의 총 깊이 구하기 D3
 */
public class tue_swea_7236 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			sc.nextLine();
			int[][] map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String[] str = sc.nextLine().split(" ");
				for(int j=0; j<n; j++) {
					if(str[j].charAt(0) == 'G') {
						map[i][j] = 0;
					}
					else {
						map[i][j] = 1;
					}
				}
			}
			int max = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == 1) {
						int cur = 0;
						for(int ci=-1; ci<=1; ci++) {
							for(int cj=-1; cj<=1; cj++) {
								if(i+ci>=0 && i+ci<n && j+cj>=0 && j+cj<n) {
									if(map[i+ci][j+cj]==1) {
										cur++;
									}
								}
							}
						}
						if(cur!=1)cur--;
						if(cur > max) max = cur;
					}
					
				}
			}
			System.out.println("#"+test_case+" "+max);
		
		}
	}

}
