package com.sy;

import java.util.Scanner;

public class RobotMoving {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int t=1; t<testCase+1; t++) {
			int n = sc.nextInt();
			
			int[][] arr = new int[n][n];
			int sum = 0;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					char input = sc.next().charAt(0);
					if(input=='S') {
						arr[i][j] = 0;
					}
					else if(input=='W') {
						arr[i][j] = 1;
					}
					else if(input=='A') {
						arr[i][j] = 2;
					}
					else if(input=='B') {
						arr[i][j] = 3;
					}
					else if(input=='C') {
						arr[i][j] = 4;
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]==2) {
						for(int k=j+1; k<n; k++) {
							if(arr[i][k]==0) sum++;
							else break;
						}
					}
					else if(arr[i][j]==3) {
						for(int k=j+1; k<n; k++) {
							if(arr[i][k]==0) sum++;
							else break;
						}
						for(int k=j-1; k>=0; k--) {
							if(arr[i][k]==0) sum++;
							else break;
						}
					}
					else if(arr[i][j]==4) {
						for(int k=j+1; k<n; k++) {
							if(arr[i][k]==0) sum++;
							else break;
						}
						for(int k=j-1; k>=0; k--) {
							if(arr[i][k]==0) sum++;
							else break;
						}
						for(int k=i+1; k<n; k++) {
							if(arr[k][j]==0) sum++;
							else break;
						}
						for(int k=i-1; k>=0; k--) {
							if(arr[k][j]==0) sum++;
							else break;
						}
					}
				}
			}
			System.out.println("#"+t+" "+sum);
			
		}

	}

}
