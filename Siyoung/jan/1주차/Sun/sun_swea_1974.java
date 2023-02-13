package com.sy.firstweek.sun;

import java.util.Scanner;
/**
 * 문제19: SWEA : 1974 스도쿠 검증 ( 배열 연습 입문 ) 1
 * @author swy05
 */
public class sun_swea_1974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		boolean pass;
		int[] check = new int[9];
		
		
		for(int t=1; t<=T; t++) {
			int[][] board = new int[9][9];
			pass = true;
			//입력
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			//가로
			for(int i=0; i<9; i++) {
				for(int n=0; n<9; n++) {
					check[n] = 0;
				}
				for(int j=0; j<9; j++) {
					if(check[board[i][j]-1]!=0) {
						pass = false;
						break;
					}
					else check[board[i][j]-1] = 1;
				}
				if(!pass) break;
			}
			
			
			//세로
			for(int j=0; j<9; j++) {
				for(int n=0; n<9; n++) {
					check[n] = 0;
				}
				for(int i=0; i<9; i++) {
					if(check[board[i][j]-1]!=0) {
						pass = false;
						break;
					}
					else check[board[i][j]-1] = 1;
				}
				if(!pass) break;
			}
			
			//네모
			for(int i=0; i<9; i+=3) {
				for(int j=0; j<9; j+=3) {
					for(int n=0; n<9; n++) {
						check[n] = 0;
					}
					
					for(int k=0; k<3; k++) {
						for(int l=0; l<3; l++) {
							if(check[board[i+k][j+l]-1]!=0) {
								pass = false;
								break;
							}
							else check[board[i+k][j+l]-1] = 1;
						}
						if(!pass) break;
					}
				}
			}
				
			if(pass) System.out.println("#"+t+" 1");
			else System.out.println("#"+t+" 0");
		}

	}

}
