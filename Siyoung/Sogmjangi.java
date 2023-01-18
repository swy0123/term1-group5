package com.sy;

import java.util.Scanner;

public class Sogmjangi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		for(int t=1; t<test+1; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int ret=0;
			int[][] map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = 0;
				}
			}
			
			for(int cnt=0; cnt<m; cnt++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				int dir=sc.nextInt();
				if(ret!=0) continue;
				if(map[x][y]!=0) {
					ret = cnt+1;
					continue;
				}
				else {
					map[x][y]=1;
				}
				if(dir==1) {
					if(x+3<n) {
						if(map[x+3][y]!=0) {
							ret = cnt+1;
							continue;
						}
						else {
							map[x+3][y]=1;
						}
					}
					if(x+5<n) {
						if(map[x+5][y]!=0) {
							ret = cnt+1;
							continue;
						}
						else {
							map[x+5][y]=1;
						}
					}
					if(x+6<n) {
						if(map[x+6][y]!=0) {
							ret = cnt+1;
							continue;
						}
						else {
							map[x+6][y]=1;
						}
					}					
				}
				else if(dir==2) {
					if(y+3<n) {
						if(map[x][y+3]!=0) {
							ret = cnt+1;
							continue;
						}
						else {
							map[x][y+3]=1;
						}
					}
					if(y+5<n) {
						if(map[x][y+5]!=0) {
							ret = cnt+1;
							continue;
						}
						else {
							map[x][y+5]=1;
						}
					}
					if(y+6<n) {
						if(map[x][y+6]!=0) {
							ret = cnt+1;
							continue;
						}
						else {
							map[x][y+6]=1;
						}
					}				
				}
				
			}
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.printf("%d ", map[i][j]);
//				}
//				System.out.println();
//			}
			
			System.out.println("#"+t + " " + ret);
			
		}

	}

}
