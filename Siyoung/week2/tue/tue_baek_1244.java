package com.sy.secweek.tue;

import java.util.Scanner;
/**
 * 문제30: 백준 : 1244 스위치 켜고 끄기 ( 제어문 기본 ) 3
 * @author swy05
 */
public class tue_baek_1244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t, n, idx;
		t = sc.nextInt();
		int[] map = new int[t];
		for(int i=0; i<t; i++) {
			map[i] = sc.nextInt();
		}
		n = sc.nextInt();
		int[][] student = new int[n][2];
		for(int i=0; i<n; i++) {
			student[i][0] = sc.nextInt();
			student[i][1] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
//			for (int j = 0; j < t; j++) {
//				System.out.printf("%d ", map[j]);
//			}
//			System.out.println("------------");
			idx = student[i][1];
			
			if(student[i][0] == 1) {
				for(int j=0; j<t; j++) {
					if((j+1)%idx == 0) map[j] = map[j]==0? 1: 0;
				}
			}
			else{
				for(int j=0; j<t; j++) {
					if((idx-1-j>=0) && (idx-1+j<t)) {
						if(map[idx-1-j] == map[idx-1+j]) {
							map[idx-1-j] = map[idx-1-j]==0? 1: 0;
							map[idx-1+j] = map[idx-1-j];
						}
						else break;
					}
					else break;
				}
			}
		}
		
		for (int i = 0; i < t; i++) {
			System.out.printf("%d ", map[i]);
			if((i+1)%20 == 0) System.out.println();
		}
		System.out.println();
	}

}
