package com.sy.secweek.thu;

import java.util.Scanner;
/**
 * [swea] 7964 : 부먹왕국의 차원 관문
 * @author swy05
 */
public class thu_swea_7964 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int n, d, sum, cnt;
		
		for(int t=1; t<=T; t++) {
			n = sc.nextInt();
			d = sc.nextInt();
			
			int[] map = new int[n+1];
			map[0] = 1;
			for(int i=1; i<=n; i++) {
				map[i] = sc.nextInt();
			}
			sum = 0;
			cnt = d;
			for(int i=0; i<=n; i++) {
				if(map[i] == 1) cnt = d;
				else cnt--;
				if(cnt == 0) {
					sum++;
					cnt = d;
				}
			}
			System.out.println("#"+t+" " + sum);
			 
		}
	}

}
