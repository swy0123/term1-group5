package com.sy;

import java.util.Scanner;

//2008. 데일리 실습 3-3 빌딩건설 Lv.3
public class BuildingTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int testCase = 0; testCase < t; testCase++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					char input = sc.next().charAt(0);
					if(input=='G') {
						map[i][j] = 0;
					}
					if(input=='B') {
						map[i][j] = 1;
					}
				}
			}
			int max = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]==0) continue;
					boolean flag=true;
					
					for(int a=-1; a<=1; a++){
						for(int b=-1; b<=1; b++)	{
							if(i+a<0 || i+a>=n || j+b<0 ||j+b>=n) continue;
							if(map[i+a][j+b]==0) {
								flag = false;
								break;
							}							
						}
					}
					
					if(!flag)continue;
					int sum = 0;
					for(int l=0; l<n; l++) {
						if(map[i][l]==1) sum++;
						if(map[l][j]==1) sum++;
					}
					max = Math.max(max, sum-1);
					
				}
			}
			System.out.println("#"+(testCase+1)+" "+max);
		}
	}
}
