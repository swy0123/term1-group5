package com.sy.secweek.mon;

import java.util.Scanner;
/**
 * 문제23: SWEA : 1289 원재의 메모리복구 ( 제어문 기본 ) 3
 * @author swy05
 */
public class mon_swea_1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		int ret;
		char cur;
		
		for(int t=1; t<=T; t++) {
			ret = 0;
			cur = '0';
			String str = sc.nextLine();
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) != cur) {
					ret++;
					cur = str.charAt(i);
				}
			}
			
			System.out.println("#"+t+" "+ret);
			
		}

	}

}
