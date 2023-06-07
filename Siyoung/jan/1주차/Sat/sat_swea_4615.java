package com.sy.firstweek.sat;

import java.util.Scanner;
/**
 * 문제13 : SWEA : 4615. 재미있는 오셀로 게임
 * @author swy05
 */
public class sat_swea_4615 {
	
//	static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
//	static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};
//	
//	static boolean check(int n, int ci, int cj, int dir, int cnt) {
//		return (ci+di[dir]*cnt>=0 && ci+di[dir]*cnt<n && cj+dj[dir]*cnt>=0 && cj+dj[dir]*cnt<n);
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int n, m, ci, cj, color, cnt;
		boolean flag;
		int black, white;

		for(int test_case = 1; test_case <= T; test_case++) {
			black=0;
			white=0;
			n = sc.nextInt();
			m = sc.nextInt();
			int[][] board = new int[n][n];
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					board[a][b] = 0;
				}
			}
			board[n/2-1][n/2-1] = 2;
			board[n/2][n/2] = 2;
			board[n/2-1][n/2] = 1;
			board[n/2][n/2-1] = 1;
			
			for(int x=0; x<m; x++) {
				ci = sc.nextInt()-1;
				cj = sc.nextInt()-1;
				color = sc.nextInt();
				flag = false;
				board[ci][cj] = color;
				
				for(int i=-1; i<=1; i++) {
					for(int j=-1; j<=1; j++) {
						if(i==0 && j==0) continue;
						if(ci+i>=0 && ci+i<n && cj+j>=0 && cj+j<n) {
							if(!(board[ci+i][cj+j] != 0 && board[ci+i][cj+j] != color)) continue;
							cnt = 2;
							flag = true;
							while(flag) {
								if(ci+i*cnt>=0 && ci+i*cnt<n && cj+j*cnt>=0 && cj+j*cnt<n) {
									if(board[ci+i*cnt][cj+j*cnt] != 0 && board[ci+i*cnt][cj+j*cnt] != color) {
										cnt++;
										continue;
									}
									if(board[ci+i*cnt][cj+j*cnt] == color) {
										for(int k=1; k<cnt; k++) {
											board[ci+i*k][cj+j*k] = color;
										}
									}
									flag = false;
								}
								else flag = false;
							}
						}
						
					}
				}
//				System.out.println("----------------------");
//				for(int a=0; a<n; a++) {
//					for(int b=0; b<n; b++) {
//						System.out.printf("%d ", board[a][b]);
//					}
//					System.out.println();
//				}
				
			}
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					if(board[a][b]==1) black++;
					if(board[a][b]==2) white++;
				}
			}
			System.out.println("#"+ test_case + " "+black+" "+white);
		}
	}

}
