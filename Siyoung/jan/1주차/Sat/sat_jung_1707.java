package com.sy.firstweek.sat;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 정올 1707 : 달팽이사각형
 * @author swy05
 */
public class sat_jung_1707 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//오른쪽, 아래, 왼쪽, 위
		int[] di = {0, 1, 0, -1};
		int[] dj = {1, 0, -1, 0};
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][n];
		
		int ci = 0;
		int cj = 0;
		int cur = 1;
		int dir = 0;
		arr[ci][cj] = cur;
		for(int i=0; i<n*n-1; i++) {
			cur++;
			if(ci+di[dir]<0 || ci+di[dir]>=n || cj+dj[dir]<0 || cj+dj[dir]>=n) {
				dir = (dir+1)%4;
			}
			else if(arr[ci+di[dir]][cj+dj[dir]]!=0) {
				dir = (dir+1)%4;
			}
			ci = ci+di[dir];
			cj = cj+dj[dir];
			arr[ci][cj] = cur;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.printf("%d ", arr[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
